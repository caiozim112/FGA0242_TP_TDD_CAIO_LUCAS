package com.example;

public class Cliente {
    private String nome;
    private ClienteTipo tipo;
    private Endereco endereco;
    private double cashback;

    public Cliente(String nome, ClienteTipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.cashback = 0.0;
    }

    public ClienteTipo getTipo() {
        return tipo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getCashback() {
        return cashback;
    }

    public void adicionarCashback(double valor) {
        this.cashback += valor;
    }

    public void utilizarCashback(double valor) {
        this.cashback -= valor;
    }
}
