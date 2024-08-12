package com.example;

public class Produto {
    private int codigo;
    private String descricao;
    private Preco preco;
    private String unidade;

    public Produto(int codigo, String descricao, Preco preco, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.unidade = unidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return preco.getValor();
    }

    /*
    Comentário (Trabalho 2: Refatoração):
        A classe "Produto" foi refatorada para mover o atributo valor para uma nova classe "Preco". Isso permite que a lógica relacionada ao preço seja isolada em uma classe específica, facilitando a modificação e extensão, como aplicar diferentes tipos de descontos ou taxas.
    */

    public String getUnidade() {
        return unidade;
    }
}
