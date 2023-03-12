package com.example.springsecuritydemoproject.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritydemoproject.dto.CustomerDto;
import com.example.springsecuritydemoproject.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class RegistrationController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody final CustomerDto customerDto) {
        final CustomerDto createdCustomer = this.customerService.createCustomer(customerDto);

        return Optional.ofNullable(createdCustomer)
            .map(c -> ResponseEntity
                .ok(String.format("Successfully created customer with email %s", c.getEmail())))
            .orElse(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(String.format("Error occurred while trying to create customer with email %s. Please try again.",
                    customerDto.getEmail())));
    }

}
