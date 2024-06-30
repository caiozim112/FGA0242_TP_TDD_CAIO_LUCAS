package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void testCadastroClientePadrao() {
        Cliente cliente = new Cliente("João", ClienteTipo.PADRAO);
        assertEquals(ClienteTipo.PADRAO, cliente.getTipo());
    }

    @Test
    public void testCadastroClienteEspecial() {
        Cliente cliente = new Cliente("Maria", ClienteTipo.ESPECIAL);
        assertEquals(ClienteTipo.ESPECIAL, cliente.getTipo());
    }

    @Test
    public void testCadastroClientePrime() {
        Cliente cliente = new Cliente("Pedro", ClienteTipo.PRIME);
        assertEquals(ClienteTipo.PRIME, cliente.getTipo());
    }
}
