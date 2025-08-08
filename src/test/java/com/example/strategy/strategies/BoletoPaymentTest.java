package com.example.strategy.strategies;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para {@link BoletoPayment}.
 */
class BoletoPaymentTest {

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
    void payShouldPrintBoletoNumberAndAmount() {
        double amount = 100.0;
        BoletoPayment strategy = new BoletoPayment();

        strategy.pay(amount);

        String output = outContent.toString().trim();
        assertTrue(output.matches("Gerando boleto no valor de R\\$\\s*100[.,]00.*"),
                "A saída deve começar com a mensagem de geração do boleto e o valor formatado");

        Pattern pattern = Pattern.compile("Número do boleto: (\\w{47})");
        Matcher matcher = pattern.matcher(output);
        assertTrue(matcher.find(), "Deve conter um número de boleto com 47 caracteres");
    }
}

