package org.csystem.app.payment.repository;

import org.csystem.app.payment.repository.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, String> {
    Iterable<Customer> findByNameAndActive(String name, boolean active);
    Iterable<Customer> findByNameContainsAndActive(String text, boolean active);

    @Query(value = "", nativeQuery = true)
    Iterable<Customer> findByMonthAndYear(int month, int year);
}
