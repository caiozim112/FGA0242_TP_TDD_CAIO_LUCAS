package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class VendaTest {
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private MetodoPagamento metodoPagamento;
    private double valorTotalEsperado;
    private double[] impostosEsperados;
    private Endereco endereco;

    public VendaTest(Cliente cliente, Produto produto, int quantidade, MetodoPagamento metodoPagamento,
                     double valorTotalEsperado, double freteEsperado, double[] impostosEsperados, Endereco endereco) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.metodoPagamento = metodoPagamento;
        this.valorTotalEsperado = valorTotalEsperado;
        this.impostosEsperados = impostosEsperados;
        this.endereco = endereco;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Cliente("Maria", ClienteTipo.ESPECIAL), new Produto(1, "Camiseta", 100.0, "peça"), 1, MetodoPagamento.CARTAO_CREDITO_EMPRESA, 81.0, 7.0, new double[]{18.0, 0.0}, new Endereco("DF", true)},
                {new Cliente("Pedro", ClienteTipo.PRIME), new Produto(1, "Camiseta", 100.0, "peça"), 1, MetodoPagamento.DINHEIRO, 100.0, 0.0, new double[]{18.0, 0.0}, new Endereco("DF", true)},
                {new Cliente("João", ClienteTipo.PADRAO), new Produto(1, "Camiseta", 100.0, "peça"), 1, MetodoPagamento.CARTAO_CREDITO_OUTROS, 100.0, 10.0, new double[]{12.0, 4.0}, new Endereco("SP", true)}
        });
    }

    @Test
    public void testCalculoValorTotal() {
        Venda venda = new Venda(cliente);
        venda.adicionarProduto(produto, quantidade);
        venda.setMetodoPagamento(metodoPagamento);
        assertEquals(valorTotalEsperado, venda.calcularValorTotal(), 0.01);
    }

    @Test
    public void testCalculoFrete() {
        Cliente cliente = new Cliente("Maria", ClienteTipo.ESPECIAL);
        Endereco endereco = new Endereco("SP", true);
        cliente.setEndereco(endereco);
        Produto produto = new Produto(1, "Camiseta", 100.0, "peça");
        Venda venda = new Venda(cliente);
        venda.adicionarProduto(produto, 1);
        venda.setEnderecoEntrega(endereco);
        assertEquals(4.9, venda.calcularFrete(), 0.01); // 7.0 * 0.7
        
        endereco = new Endereco("SP", false);
        venda.setEnderecoEntrega(endereco);
        assertEquals(7.0, venda.calcularFrete(), 0.01); // 10.0 * 0.7
    }

    @Test
    public void testCalculoImpostos() {
        Venda venda = new Venda(cliente);
        venda.adicionarProduto(produto, quantidade);
        venda.setEnderecoEntrega(endereco);
        double[] impostos = venda.calcularImpostos();
        assertEquals(impostosEsperados[0], impostos[0], 0.01); // ICMS
        assertEquals(impostosEsperados[1], impostos[1], 0.01);  // Imposto municipal
    }
}
