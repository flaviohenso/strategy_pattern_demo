package com.example.strategy.strategies;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para {@link CreditCardPayment}.
 */
class CreditCardPaymentTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void payShouldPrintMaskedCardAndAmount() {
        String cardNumber = "1234567812345678";
        double amount = 99.99;
        CreditCardPayment strategy = new CreditCardPayment(cardNumber);

        strategy.pay(amount);

        String output = outContent.toString().trim();
        assertTrue(output.matches(".*R\\$\\s*99[.,]99.*"), "A saída deve conter o valor formatado (99,99 ou 99.99)");
        assertTrue(output.endsWith("5678"), "A saída deve mostrar somente os 4 últimos dígitos do cartão");
        assertFalse(output.contains(cardNumber), "O número completo do cartão nunca deve aparecer na saída");
    }
}

