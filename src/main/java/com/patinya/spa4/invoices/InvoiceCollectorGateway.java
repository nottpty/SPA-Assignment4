package com.patinya.spa4.invoices;

import java.util.Collection;

/**
 * Created by patinya on 2017-05-13.
 */
public interface InvoiceCollectorGateway {
    void collectInvoices(Collection<Invoice> invoices);
}
