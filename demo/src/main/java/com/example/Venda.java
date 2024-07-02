package com.example;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<Produto> produtos;
    private MetodoPagamento metodoPagamento;
    private Endereco enderecoEntrega;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            this.produtos.add(produto);
        }
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setEnderecoEntrega(Endereco endereco) {
        this.enderecoEntrega = endereco;
    }

    public double calcularValorTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getValor();
        }

        if (cliente.getTipo() == ClienteTipo.ESPECIAL) {
            total *= 0.9; // 10% de desconto
            if (metodoPagamento == MetodoPagamento.CARTAO_CREDITO_EMPRESA) {
                total *= 0.9; // Mais 10% de desconto
            }
        } else if (cliente.getTipo() == ClienteTipo.PRIME) {
            double cashback = total * 0.03; // Cashback de 3%
            if (metodoPagamento == MetodoPagamento.CARTAO_CREDITO_EMPRESA) {
                cashback = total * 0.05; // Cashback de 5%
            }
            cliente.adicionarCashback(cashback);
        }

        return total;
    }

    public double calcularFrete() {
        if (cliente.getTipo() == ClienteTipo.PRIME) {
            return 0.0;
        }

        String estado = enderecoEntrega.getEstado();
        boolean isCapital = enderecoEntrega.isCapital();
        double frete = 0.0;

        switch (estado) {
            case "DF":
                frete = 5.0;
                break;
            case "GO":
            case "MS":
            case "MT":
                frete = isCapital ? 10.0 : 13.0;
                break;
            case "BA":
            case "SE":
            case "PE":
            case "AL":
            case "PB":
            case "RN":
                frete = isCapital ? 15.0 : 18.0;
                break;
            case "AM":
            case "PA":
            case "RO":
            case "RR":
            case "AC":
            case "AP":
                frete = isCapital ? 20.0 : 25.0;
                break;
            case "SP":
            case "RJ":
            case "MG":
            case "ES":
                frete = isCapital ? 7.0 : 10.0;
                break;
            case "RS":
            case "SC":
            case "PR":
                frete = isCapital ? 10.0 : 13.0;
                break;
            default:
                frete = 0.0;
                break;
        }

        if (cliente.getTipo() == ClienteTipo.ESPECIAL) {
            frete *= 0.7; // 30% de desconto no frete
        }

        return frete;
    }

    public double[] calcularImpostos() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getValor();
        }

        double icms = 0.0;
        double impostoMunicipal = 0.0;

        if (enderecoEntrega.getEstado().equals("DF")) {
            icms = total * 0.18;
        } else {
            icms = total * 0.12;
            impostoMunicipal = total * 0.04;
        }

        return new double[]{icms, impostoMunicipal};
    }
}
