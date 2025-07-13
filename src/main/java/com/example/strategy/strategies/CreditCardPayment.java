package com.example.strategy.strategies;

import com.example.strategy.PaymentStrategy;

/**
 * Implementação concreta da estratégia para pagamento via cartão de crédito.
 */
public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        // Lógica simplificada apenas para demonstração
        System.out.printf("Pagando R$ %.2f usando Cartão de Crédito %s%n", amount, maskCard());
    }

    private String maskCard() {
        // Mascara todos os dígitos exceto os 4 últimos
        if (cardNumber.length() > 4) {
            return "*".repeat(cardNumber.length() - 4) + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber;
    }
} 
