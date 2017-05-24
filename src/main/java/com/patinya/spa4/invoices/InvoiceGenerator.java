package com.patinya.spa4.invoices;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by patinya on 2017-05-13.
 */
@Component
public class InvoiceGenerator {

    private Random rand = new Random();

    public Invoice nextInvoice() {
        return new Invoice(rand.nextBoolean() ? iban() : null, address(), account(), dollars());
    }

    private BigDecimal dollars() {
        return new BigDecimal(1 + rand.nextInt(20_000));
    }

    private String account() {
        return String.format("test-account-%d", rand.nextInt(1000) + 1000);
    }

    private String address() {
        return String.format("Test street %d", rand.nextInt(100) + 1);
    }

    private String iban() {
        return String.format("test-iban-%d", rand.nextInt(1000) + 1000);
    }
}
