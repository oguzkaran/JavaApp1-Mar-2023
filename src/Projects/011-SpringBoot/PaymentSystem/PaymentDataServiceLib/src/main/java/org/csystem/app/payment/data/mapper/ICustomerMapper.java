package org.csystem.app.payment.data.mapper;


import org.csystem.app.payment.data.dto.CustomerSaveDTO;
import org.csystem.app.payment.repository.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CustomerMapperImpl", componentModel = "spring")
public interface ICustomerMapper {
    Customer toCustomer(CustomerSaveDTO customerSaveDTO);
}
