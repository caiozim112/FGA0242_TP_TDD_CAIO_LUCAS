package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ClienteTest {
    private String nome;
    private ClienteTipo tipo;

    public ClienteTest(String nome, ClienteTipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"João", ClienteTipo.PADRAO},
                {"Maria", ClienteTipo.ESPECIAL},
                {"Pedro", ClienteTipo.PRIME}
        });
    }

    @Test
    public void testCadastroCliente() {
        Cliente cliente = new Cliente(nome, tipo);
        assertEquals(tipo, cliente.getTipo());
    }
}
