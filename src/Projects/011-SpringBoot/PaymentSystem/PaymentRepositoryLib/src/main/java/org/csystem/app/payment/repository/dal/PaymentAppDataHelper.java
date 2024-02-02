package org.csystem.app.payment.repository.dal;

import com.karandev.util.data.repository.exception.RepositoryException;
import org.csystem.app.payment.repository.ICustomerRepository;
import org.csystem.app.payment.repository.IPaymentRepository;
import org.csystem.app.payment.repository.entity.Customer;
import org.csystem.app.payment.repository.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentAppDataHelper {
    private final ICustomerRepository m_customerRepository;
    private final IPaymentRepository m_paymentRepository;

    public PaymentAppDataHelper(ICustomerRepository customerRepository, IPaymentRepository paymentRepository)
    {
        m_customerRepository = customerRepository;
        m_paymentRepository = paymentRepository;
    }

    public Payment savePayment(Payment payment)
    {
        try {
            return m_paymentRepository.save(payment);
        }
        catch (Throwable ex) {
            throw new RepositoryException("PaymentAppDataHelper.savePayment", ex);
        }
    }

    public Customer saveCustomer(Customer customer)
    {
        try {
            return m_customerRepository.save(customer);
        }
        catch (Throwable ex) {
            throw new RepositoryException("PaymentAppDataHelper.saveCustomer", ex);
        }
    }

    public boolean existsUserByUsername(String username)
    {
        try {
            return m_customerRepository.existsById(username);
        }
        catch (Throwable ex) {
            throw new RepositoryException("PaymentAppDataHelper.existsUserByUsername", ex);
        }
    }

    public boolean existsUserByUsernameAndActive(String username, boolean active)
    {
        try {
            return m_customerRepository.existsByUsernameAndActive(username, active);
        }
        catch (Throwable ex) {
            throw new RepositoryException("PaymentAppDataHelper.existsUserByUsernameAndActive", ex);
        }
    }

    public Optional<Customer> findCustomerByUsernameAndActive(String username, boolean active)
    {
        try {
            return m_customerRepository.findByUsernameAndActive(username, active);
        }
        catch (Throwable ex) {
            throw new RepositoryException("PaymentAppDataHelper.findCustomerByUsernameAndActive", ex);
        }
    }

    public Optional<Customer> findCustomerByUsername(String username)
    {
        try {
            return m_customerRepository.findById(username);
        }
        catch (Throwable ex) {
            throw new RepositoryException("PaymentAppDataHelper.findCustomerByUsername", ex);
        }
    }

    public Optional<Customer> findActiveCustomerByUsername(String username)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    //...
}
