package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class EnderecoTest {

    @Test
    public void testCadastroEndereco() {
        Endereco endereco = new Endereco("DF", true);
        assertEquals("DF", endereco.getEstado());
        assertTrue(endereco.isCapital());
    }
}
