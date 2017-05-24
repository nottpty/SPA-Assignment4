package com.patinya.spa4.invoices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by patinya on 2017-05-13.
 */
@Component
public class InvoicesJob {

    private int limit = 10;

    @Autowired
    InvoiceCollectorGateway invoiceCollector;

    @Autowired
    InvoiceGenerator invoiceGenerator;

    @Scheduled(fixedRate = 4000)
    public void scheduleInvoicesHandling() {
        Collection<Invoice> invoices = generateInvoices(limit);
        System.out.println(String.format("\n===============> Sending %d invoices to the system.", invoices.size()));
        invoiceCollector.collectInvoices(invoices);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private Collection<Invoice> generateInvoices(int limit) {
        List<Invoice> invoices = new ArrayList<Invoice>();
        for (int i = 0; i < limit; ++i) {
            invoices.add(invoiceGenerator.nextInvoice());
        }
        return invoices;
    }
}
