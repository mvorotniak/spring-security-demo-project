package com.example.springsecuritydemoproject.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.springsecuritydemoproject.dto.CustomerDto;
import com.example.springsecuritydemoproject.entity.Customer;
import com.example.springsecuritydemoproject.mapper.CustomerMapper;
import com.example.springsecuritydemoproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    private final CustomerMapper customerMapper;

    public CustomerDto createCustomer(final CustomerDto customerDto) {
        final Customer customer = this.customerMapper.toCustomerEntity(customerDto);

        final String hashPwd = this.passwordEncoder.encode(customer.getPassword());
        customer.setPassword(hashPwd);

        return this.customerMapper.toCustomerDto(this.customerRepository.save(customer));
    }

    public CustomerDto getCustomerByEmail(final String email) {
        return this.customerMapper.toCustomerDto(this.customerRepository.findFirstByEmail(email)
            .orElseThrow(() -> new RuntimeException(String.format("User with email %s was not found", email))));
    }

}
