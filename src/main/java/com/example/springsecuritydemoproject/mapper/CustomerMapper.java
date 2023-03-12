package com.example.springsecuritydemoproject.mapper;

import com.example.springsecuritydemoproject.dto.CustomerDto;
import com.example.springsecuritydemoproject.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomerEntity(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);

}
