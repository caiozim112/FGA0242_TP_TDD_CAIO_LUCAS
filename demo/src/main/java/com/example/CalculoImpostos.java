package com.example;

public class CalculoImpostos {
    
    public static double[] calcularImpostos(String estado, double valorTotal) {
        double icms = 0.0;
        double impostoMunicipal = 0.0;

        if (estado.equals("DF")) {
            icms = valorTotal * 0.18;
        } else {
            icms = valorTotal * 0.12;
            impostoMunicipal = valorTotal * 0.04;
        }

        return new double[]{icms, impostoMunicipal};
    }
}
