package com.example.strategy.service;

import org.springframework.stereotype.Component;

@Component
public class EntregaEconomica implements FreteStrategy {

    @Override
    public double calcular(double peso) {
        return 1.7 * peso;
    }

    @Override
    public String tipoFrete() {
        return "Entrega Econômica";
    }
}
