package com.example.strategy.service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteService {
    private final List<FreteStrategy> estrategias;
    public FreteService(List<FreteStrategy> estrategies){
        this.estrategias = estrategies;
    }

    public double calcular(String tipoFrete, double peso){
        System.out.println("Tipo recebido: " + tipoFrete);
        System.out.println("Tipos disponíveis:");
        estrategias.forEach(e -> System.out.println("- " + e.tipoFrete()));

        return estrategias.stream()
                .filter(frete -> frete.tipoFrete().equalsIgnoreCase(tipoFrete))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de frete não encontrado"))
                .calcular(peso);
    }
}
