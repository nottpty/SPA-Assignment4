package com.patinya.spa4.banking;

/**
 * Created by patinya on 2017-05-13.
 */
public interface BankingService {
    void pay(Payment payment) throws PaymentException;
}
