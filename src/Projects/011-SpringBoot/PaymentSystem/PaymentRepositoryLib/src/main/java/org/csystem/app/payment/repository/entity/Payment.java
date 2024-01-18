package org.csystem.app.payment.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class Payment { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    public long id;

    public double quantity;

    @Column(name = "unit_price", nullable = false)
    public BigDecimal unitPrice;

    @ManyToOne()
    public Customer customer;
    //...
}
