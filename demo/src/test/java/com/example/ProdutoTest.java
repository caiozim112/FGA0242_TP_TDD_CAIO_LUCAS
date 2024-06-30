package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void testCadastroProduto() {
        Produto produto = new Produto(1, "Camiseta", 50.0, "peça");
        assertEquals(1, produto.getCodigo());
        assertEquals("Camiseta", produto.getDescricao());
        assertEquals(50.0, produto.getValor(), 0.01);
        assertEquals("peça", produto.getUnidade());
    }
}
