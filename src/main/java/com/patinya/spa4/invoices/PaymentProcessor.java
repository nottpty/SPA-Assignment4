package com.patinya.spa4.invoices;

import com.patinya.spa4.banking.BankingService;
import com.patinya.spa4.banking.Payment;
import com.patinya.spa4.banking.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by patinya on 2017-05-13.
 */
@Component
public class PaymentProcessor {

    @Autowired
    BankingService bankingService;

    @ServiceActivator
    public void processPayment(Payment payment) throws PaymentException {
        bankingService.pay(payment);
    }
}
