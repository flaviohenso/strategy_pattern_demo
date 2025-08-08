package com.example.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para a classe {@link PaymentContext}.
 */
class PaymentContextTest {

    /**
     * Implementação dummy de {@link PaymentStrategy} para fins de teste.
     */
    private static class DummyStrategy implements PaymentStrategy {
        double lastAmount = -1;

        @Override
        public void pay(double amount) {
            lastAmount = amount;
        }
    }

    @Test
    void checkoutDelegatesToStrategy() {
        DummyStrategy dummy = new DummyStrategy();
        PaymentContext context = new PaymentContext(dummy);
        double value = 123.45;

        context.checkout(value);

        assertEquals(value, dummy.lastAmount,
                "O contexto deve delegar a chamada do pagamento para a estratégia");
    }

    @Test
    void setStrategyShouldChangeStrategyAtRuntime() {
        DummyStrategy first = new DummyStrategy();
        DummyStrategy second = new DummyStrategy();
        PaymentContext context = new PaymentContext(first);

        // Primeira chamada usando a primeira estratégia
        context.checkout(50.0);
        assertEquals(50.0, first.lastAmount, 0.0001);

        // Altera a estratégia em tempo de execução
        context.setStrategy(second);
        context.checkout(70.0);

        assertEquals(70.0, second.lastAmount, 0.0001,
                "Após alterar a estratégia, as chamadas devem ser encaminhadas para a nova instância");
    }
}

