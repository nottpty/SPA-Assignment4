package com.patinya.spa4.invoices;

import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Component;

/**
 * Created by patinya on 2017-05-13.
 */
@Component
public class InvoiceFilter {
    public static final int LOW_ENOUGH_THRESHOLD = 10_000;

    @Filter
    public boolean accept(Invoice invoice) {
        boolean lowEnough = invoice.getDollars().intValue() < LOW_ENOUGH_THRESHOLD;
        System.out.println(String.format("Amount of $%s %s be automatically processed by system.", invoice.getDollars(), lowEnough ? " can" : " can not"));
        return lowEnough;
    }
}
