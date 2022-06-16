package com.mycompany.invoice.invoiceweb.controller;

import com.mycompany.invoice.core.controller.InvoiceControllerInterface;
import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import com.mycompany.invoice.invoiceweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
    /*
        @PostMapping("")
        public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {
            if(results.hasErrors()) {
                return "invoice-create-form";
            } else {
                Invoice invoice = new Invoice();
                invoice.setCustomerName(invoiceForm.getCustomerName());
                invoice.setOrderNumber(invoiceForm.getOrderNumber());
                invoiceService.createInvoice(invoice);
                return "invoice-created";
            }
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
        */
    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoiceForm) {
        return "invoice-create-form";
    }
}
