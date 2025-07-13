package com.example.strategy;

import com.example.strategy.strategies.BoletoPayment;
import com.example.strategy.strategies.CreditCardPayment;
import com.example.strategy.strategies.PixPayment;

/**
 * Classe de demonstração do padrão Strategy.
 */
public class Main {

    public static void main(String[] args) {
        // Cria contexto usando pagamento via cartão inicialmente
        PaymentContext context = new PaymentContext(new CreditCardPayment("1234567890123456"));
        context.checkout(250.0);

        // Troca para PIX em runtime
        context.setStrategy(new PixPayment("flavio@example.com"));
        context.checkout(180.0);

        // Troca para boleto
        context.setStrategy(new BoletoPayment());
        context.checkout(90.0);
    }
} 
