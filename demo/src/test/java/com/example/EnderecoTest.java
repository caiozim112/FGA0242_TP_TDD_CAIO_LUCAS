package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EnderecoTest {
    private String estado;
    private boolean capital;

    public EnderecoTest(String estado, boolean capital) {
        this.estado = estado;
        this.capital = capital;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"DF", true},
                {"SP", false},
                {"RJ", true},
                {"MG", false}
        });
    }

    @Test
    public void testCadastroEndereco() {
        Endereco endereco = new Endereco(estado, capital);
        assertEquals(estado, endereco.getEstado());
        assertEquals(capital, endereco.isCapital());
    }
}
