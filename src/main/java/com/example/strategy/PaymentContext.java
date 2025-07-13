package com.example.strategy;

/**
 * Contexto que armazena uma referência para um objeto Strategy de pagamento.
 *
 * Ele não conhece detalhes da implementação concreta, apenas confia
 * que a estratégia fornecida implementa o método {@link PaymentStrategy#pay(double)}.
 *
 * Isso possibilita a troca da estratégia em tempo de execução, mantendo
 * o princípio Open/Closed (aberto para extensão, fechado para modificação).
 */
public class PaymentContext {

    private PaymentStrategy strategy;

    /**
     * Construtor recebendo a estratégia inicial.
     *
     * @param strategy instância concreta de {@link PaymentStrategy}.
     */
    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Altera a estratégia de pagamento em tempo de execução.
     *
     * @param strategy nova estratégia a ser utilizada.
     */
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Realiza o processo de pagamento delegando para a estratégia atual.
     *
     * @param amount valor a ser pago.
     */
    public void checkout(double amount) {
        strategy.pay(amount);
    }
} 
