package com.mycompany.invoice.invoiceweb.controller;

import com.mycompany.invoice.core.controller.InvoiceControllerInterface;
import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("")
    public String createInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }

    @GetMapping("/home")
    public String displayHome(Model model) {
        System.out.println("La méthode display home a été appelée");
        List<Invoice> invoices = invoiceService.list();
        model.addAttribute("invoices", invoices);
        return "invoice-home";
    }

    @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model) {
        System.out.println("La méthode display home a été appelée");
        Invoice invoice = invoiceService.getInvoiceByNumber(number);
        model.addAttribute("invoice", invoice);
        return "invoice-details";
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute Invoice invoice) {
        return "invoice-create-form";
    }
}
