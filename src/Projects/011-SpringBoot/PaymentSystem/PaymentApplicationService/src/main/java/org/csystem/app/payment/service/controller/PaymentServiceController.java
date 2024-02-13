package org.csystem.app.payment.service.controller;


import org.csystem.app.payment.data.dto.CustomerSaveDTO;
import org.csystem.app.payment.data.service.PaymentAppDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentServiceController {
    private final PaymentAppDataService m_paymentAppDataService;

    public PaymentServiceController(PaymentAppDataService paymentAppDataService)
    {
        m_paymentAppDataService = paymentAppDataService;
    }

    @PostMapping("/customer/save")
    public CustomerSaveDTO saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO)
    {
        m_paymentAppDataService.saveCustomer(customerSaveDTO);

        return customerSaveDTO;
    }
}
