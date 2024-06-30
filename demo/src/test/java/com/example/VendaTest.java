package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class VendaTest {

    @Test
    public void testCalculoDescontoClienteEspecial() {
        Cliente cliente = new Cliente("Maria", ClienteTipo.ESPECIAL);
        Produto produto = new Produto(1, "Camiseta", 100.0, "peça");
        Venda venda = new Venda(cliente);
        venda.adicionarProduto(produto, 1);
        venda.setMetodoPagamento(MetodoPagamento.CARTAO_CREDITO_EMPRESA);
        assertEquals(80.0, venda.calcularValorTotal(), 0.01);
    }

    @Test
    public void testCalculoFreteClientePrime() {
        Cliente cliente = new Cliente("Pedro", ClienteTipo.PRIME);
        Endereco endereco = new Endereco("DF", true);
        cliente.setEndereco(endereco);
        Produto produto = new Produto(1, "Camiseta", 100.0, "peça");
        Venda venda = new Venda(cliente);
        venda.adicionarProduto(produto, 1);
        assertEquals(100.0, venda.calcularValorTotal(), 0.01);
        assertEquals(0.0, venda.calcularFrete(), 0.01);
    }

    @Test
    public void testCalculoImpostosDF() {
        Produto produto = new Produto(1, "Camiseta", 100.0, "peça");
        Venda venda = new Venda(new Cliente("João", ClienteTipo.PADRAO));
        venda.adicionarProduto(produto, 1);
        venda.setEnderecoEntrega(new Endereco("DF", true));
        double[] impostos = venda.calcularImpostos();
        assertEquals(18.0, impostos[0], 0.01); // ICMS
        assertEquals(0.0, impostos[1], 0.01);  // Imposto municipal
    }
}
