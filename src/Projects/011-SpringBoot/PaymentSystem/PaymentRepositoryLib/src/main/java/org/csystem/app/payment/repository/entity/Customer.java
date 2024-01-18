package org.csystem.app.payment.repository.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer { //POJO
    @Id
    public String username;

    @Column(nullable = false, length = 512)
    public String name;

    @Column(name = "register_date", nullable = false)
    public LocalDate registerDate;

    public boolean active;

    @OneToMany()
    public Set<Payment> payments;

    //...
}


