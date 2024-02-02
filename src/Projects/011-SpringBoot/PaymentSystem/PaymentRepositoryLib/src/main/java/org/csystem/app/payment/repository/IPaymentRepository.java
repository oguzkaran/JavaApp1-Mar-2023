package org.csystem.app.payment.repository;

import org.csystem.app.payment.repository.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends CrudRepository<Payment, Long> {

}
