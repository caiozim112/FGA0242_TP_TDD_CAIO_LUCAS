package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ProdutoTest {
    private int codigo;
    private String descricao;
    private Preco preco;
    private String unidade;

    public ProdutoTest(int codigo, String descricao, double valor, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "Camiseta", 50.0, "peça"},
                {2, "Calça", 80.0, "peça"},
                {3, "Sapato", 120.0, "par"}
        });
    }

    @Test
    public void testCadastroProduto() {
        Produto produto = new Produto(codigo, descricao, preco, unidade);
        assertEquals(codigo, produto.getCodigo());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(preco.getValor(), produto.getValor(), 0.01);
        assertEquals(unidade, produto.getUnidade());
    }
}
