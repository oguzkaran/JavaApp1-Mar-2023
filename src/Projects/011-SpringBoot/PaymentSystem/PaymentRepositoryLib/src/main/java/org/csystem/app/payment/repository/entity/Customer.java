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
    public LocalDate registerDate = LocalDate.now();

    public boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    public Set<Payment> payments;

    @Override
    public int hashCode()
    {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Customer c && username.equals(c.username);
    }
}


