package com.example;

public class Produto {
    private int codigo;
    private String descricao;
    private double valor;
    private String unidade;

    public Produto(int codigo, String descricao, double valor, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }
}
