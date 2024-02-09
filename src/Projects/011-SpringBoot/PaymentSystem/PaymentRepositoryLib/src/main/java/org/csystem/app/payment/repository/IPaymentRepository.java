package org.csystem.app.payment.repository;

import org.csystem.app.payment.repository.entity.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends CrudRepository<Payment, Long> {
    //@Query(value = "select p.* from payments p inner join customers c on c.username = p.username where c.name=:name", nativeQuery = true)
    //@Query(value = "select p.* from payments p, customers c where c.username = p.username and c.name=:name", nativeQuery = true)
    //@Query("select p from Payment p inner join Customer c where c.name = :name")
    //@Query("from Payment p inner join Customer c where c.name = :name")
    @Query("from Payment p where p.customer.name = :name")
    Iterable<Payment> findByCustomerName(@Param("name") String name);

    @Query("from Payment p where p.customer.username = :username")
    Iterable<Payment> findByCustomerUsername(@Param("username") String username);

    @Query(value = "select * from payments where date_part('month', date_time) = :month and date_part('year', date_time) = :year", nativeQuery = true)
    Iterable<Payment> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}

