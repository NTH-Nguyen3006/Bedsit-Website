package com.example.ahihi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ahihi.entities.Invoice;
import com.example.ahihi.sevices.InvoiceService;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/hoa-don")
    public String page(Model model, @PathParam("code") String code) {
        Invoice invoice = null;
        if (code != null)
            invoice = this.invoiceService.getInvoiceByCode(code);
        model.addAttribute("activePage", "hoa-don");
        model.addAttribute("invoice", invoice);

        return "pages/invoice";
    }

    @GetMapping("/pay/payment-callback")
    public String paymentStatusPage(Model model, @RequestParam Map<String, String> allParam) {
        System.out.println("--------- : " + allParam);

        var code = allParam.get("vnp_OrderInfo");

        if (allParam.get("vnp_TransactionStatus").equals("00")) {
            // giao dịch thành công
            var invoice = invoiceService.getInvoiceByCode(code);
            System.out.println("invoice: " + invoice);
            invoice.setStatus(true);
            invoiceService.save(invoice);
        }

        model.addAttribute(allParam);
        return "pages/statusPayment";
    }

}
