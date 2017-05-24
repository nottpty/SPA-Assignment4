package com.patinya.spa4.invoices;

import com.patinya.spa4.banking.Payment;
import com.patinya.spa4.banking.PaymentCreator;
import com.patinya.spa4.banking.PaymentException;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

/**
 * Created by patinya on 2017-05-13.
 */
@Component
public class ForeignPaymentCreator implements PaymentCreator {

    private static final String CURRENT_IBAN_ACC = "current-iban-acc";

    @Override
    @Transformer
    public Payment createPayment(Invoice invoice) throws PaymentException {
        if (null == invoice.getIban()) {
            throw new PaymentException("IBAN mustn't be null when creating foreign payment!");
        }
        return new Payment(CURRENT_IBAN_ACC, invoice.getIban(), invoice.getDollars());
    }
}
