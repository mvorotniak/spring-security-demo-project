package com.example.springsecuritydemoproject.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecuritydemoproject.entity.Customer;
import com.example.springsecuritydemoproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final Optional<Customer> customerOptional = this.customerRepository.findFirstByEmail(email);
        if (customerOptional.isEmpty()) {
            log.info("Query returned no results for customer with email '" + email + "'");
            throw new UsernameNotFoundException(String.format("Email [%s] not found", email));
        } else {
            final Customer customer = customerOptional.get();

            final Set<GrantedAuthority> dbAuthsSet = new HashSet<>();
            dbAuthsSet.add(new SimpleGrantedAuthority(customer.getRole()));

            return new User(customer.getEmail(), customer.getPassword(), dbAuthsSet);
        }
    }

}
