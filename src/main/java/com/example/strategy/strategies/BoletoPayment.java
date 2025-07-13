package com.example.strategy.strategies;

import com.example.strategy.PaymentStrategy;

import java.util.UUID;

/**
 * Implementação concreta da estratégia para pagamento via boleto bancário.
 */
public class BoletoPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        String boletoNumber = generateBoletoNumber();
        System.out.printf("Gerando boleto no valor de R$ %.2f. Número do boleto: %s%n", amount, boletoNumber);
    }

    private String generateBoletoNumber() {
        // Gera um identificador único para o boleto (mock)
        return UUID.randomUUID().toString().replace("-", "").substring(0, 47);
    }
} 
