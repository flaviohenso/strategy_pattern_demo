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
        // Gera um identificador único de 47 dígitos para o boleto (mock)
        String base = UUID.randomUUID().toString().replace("-", "");
        // Caso o UUID não seja suficiente para 47 caracteres, preenche com zeros.
        if (base.length() < 47) {
            return base + "0".repeat(47 - base.length());
        }
        return base.substring(0, 47);
    }
} 
