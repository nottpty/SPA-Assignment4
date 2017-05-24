package com.patinya.spa4.invoices;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by patinya on 2017-05-13.
 */
@Component
public class FailedPaymentHandler {

    @ServiceActivator
    public void handleFailedPayment(Exception e) {
        System.out.print(String.format("Payment failed: %s", e));
    }
}
