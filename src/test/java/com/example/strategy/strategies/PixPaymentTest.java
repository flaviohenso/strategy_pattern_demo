package com.example.strategy.strategies;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para {@link PixPayment}.
 */
class PixPaymentTest {

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
    void payShouldPrintPixKeyAndAmount() {
        String pixKey = "flavio@example.com";
        double amount = 150.0;
        PixPayment strategy = new PixPayment(pixKey);

        strategy.pay(amount);

        String output = outContent.toString().trim();
        assertTrue(output.matches(".*R\\$\\s*150[.,]00.*"), "A saída deve conter o valor formatado (150,00 ou 150.00)");
        assertTrue(output.contains(pixKey), "A saída deve conter a chave PIX informada");
    }
}

