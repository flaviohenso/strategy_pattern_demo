package com.example.strategy;

/**
 * Strategy (interface) que define o contrato para algoritmos de pagamento.
 *
 * Cada nova forma de pagamento deverá implementar esta interface,
 * permitindo que o Context delegue a execução sem conhecer detalhes
 * da implementação concreta.
 */
public interface PaymentStrategy {

    /**
     * Executa o pagamento para o valor especificado.
     *
     * @param amount valor a ser pago, em reais.
     */
    void pay(double amount);
} 
