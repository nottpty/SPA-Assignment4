package com.patinya.spa4.banking;

import com.patinya.spa4.invoices.Invoice;

/**
 * Created by patinya on 2017-05-13.
 */
public interface PaymentCreator {
    Payment createPayment(Invoice invoice) throws PaymentException;
}
