package org.csystem.app.payment.service.controller;


import org.csystem.app.payment.data.dto.ActiveCustomerDTO;
import org.csystem.app.payment.data.dto.CustomerSaveDTO;
import org.csystem.app.payment.data.service.PaymentAppDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/customer/active/username")
    public ResponseEntity<ActiveCustomerDTO> findActiveCustomerByUsername(String name)
    {
        return ResponseEntity.of(m_paymentAppDataService.findActiveCustomerByUsername(name));
    }

    //...
}
