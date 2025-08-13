package com.example.ahihi.sevices;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ahihi.entities.Invoice;
import com.example.ahihi.repository.InvoiceRepository;

@Service
public class InvoiceService {
    @Autowired
    public InvoiceRepository invoiceRepository;

    public Invoice getInvoiceByCode(String code) {
        var invoice = invoiceRepository.findOneByCode(code);
        var asubtotal = invoice.getInvoiceDetails().stream()
                .map(dt -> (dt.getUnitPrice().multiply(new BigDecimal(dt.getQuantity()))))
                .toArray(BigDecimal[]::new);
        var sum = Arrays.stream(asubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (invoice.getTotalAmount() == null) {
            invoice.setTotalAmount(sum);
            invoice = invoiceRepository.save(invoice);
        }
        return invoice;
    }

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
