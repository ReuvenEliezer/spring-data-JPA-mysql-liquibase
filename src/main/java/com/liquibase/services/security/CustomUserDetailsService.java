package com.liquibase.services.security;

import com.liquibase.entities.Employee;
import com.liquibase.repositories.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeDao userRepository;

    @Autowired
    public CustomUserDetailsService(EmployeeDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        Employee employee = user.get();
        return org.springframework.security.core.userdetails.User.builder()
                .username(employee.getEmail())
                .password(employee.getPassword())
                .roles(roles.toArray(new String[0]))
                .build();
    }
}