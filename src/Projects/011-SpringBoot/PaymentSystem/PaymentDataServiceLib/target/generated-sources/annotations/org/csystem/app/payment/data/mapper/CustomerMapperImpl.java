package org.csystem.app.payment.data.mapper;

import javax.annotation.processing.Generated;
import org.csystem.app.payment.data.dto.CustomerSaveDTO;
import org.csystem.app.payment.repository.entity.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-13T22:59:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements ICustomerMapper {

    @Override
    public Customer toCustomer(CustomerSaveDTO customerSaveDTO) {
        if ( customerSaveDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.username = customerSaveDTO.username;
        customer.name = customerSaveDTO.name;
        customer.active = customerSaveDTO.active;

        return customer;
    }
}
