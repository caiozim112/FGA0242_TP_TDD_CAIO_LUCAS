package com.example;

import java.util.ArrayList;
import java.util.List;


    /*
    Comentário (Trabalho 2: Refatoração):
        O método "calcular()" implementa a lógica que antes estava em "Venda::calcularValorTotal()". Agora essa lógica está encapsulada em uma classe separada, seguindo o princípio de responsabilidade única.
    */

public class CalculoVenda {
    public MetodoPagamento metodoPagamento;
    private Cliente cliente;
    public List<Produto> produtos;

    public CalculoVenda(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double calcular() {
        double total = calcularValorProdutos();
        total = aplicarDesconto(total);
        aplicarCashback(total);
        return total;
    }

    private double calcularValorProdutos() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getValor();
        }
        return total;
    }

    private double aplicarDesconto(double total) {
        if (cliente.getTipo() == ClienteTipo.ESPECIAL) {
            total *= 0.9; // 10% de desconto
            if (metodoPagamento == MetodoPagamento.CARTAO_CREDITO_EMPRESA) {
                total *= 0.9; // Mais 10% de desconto
            }
        }
        return total;
    }

    private void aplicarCashback(double total) {
        if (cliente.getTipo() == ClienteTipo.PRIME) {
            double cashback = total * 0.03; // Cashback de 3%
            if (metodoPagamento == MetodoPagamento.CARTAO_CREDITO_EMPRESA) {
                cashback = total * 0.05; // Cashback de 5%
            }
            cliente.adicionarCashback(cashback);
        }
    }
}