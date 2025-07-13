package com.example.strategy.strategies;

import com.example.strategy.PaymentStrategy;

/**
 * Implementação concreta da estratégia para pagamento via PIX.
 */
public class PixPayment implements PaymentStrategy {

    private final String pixKey;

    public PixPayment(String pixKey) {
        this.pixKey = pixKey;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Pagando R$ %.2f via PIX utilizando a chave %s%n", amount, pixKey);
    }
} 
