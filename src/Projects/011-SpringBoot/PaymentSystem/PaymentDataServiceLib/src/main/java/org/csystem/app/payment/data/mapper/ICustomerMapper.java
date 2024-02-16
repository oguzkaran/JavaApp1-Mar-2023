package org.csystem.app.payment.data.mapper;


import org.csystem.app.payment.data.dto.ActiveCustomerDTO;
import org.csystem.app.payment.data.dto.CustomerSaveDTO;
import org.csystem.app.payment.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "CustomerMapperImpl", componentModel = "spring")
public interface ICustomerMapper {
    Customer toCustomer(CustomerSaveDTO customerSaveDTO);

    //@Mappings({@Mapping(source = "registerDate", target = "registerDate", dateFormat = "dd/MM/yyyy"), @Mapping(source = "name", target = "customerName")})
    @Mapping(source = "registerDate", target = "registerDate", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "name", target = "customerName")
    ActiveCustomerDTO toActiveCustomerDTO(Customer customer);
}
