package com.example.app.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String userName;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    public TacoUser toUser(PasswordEncoder passwordEncoder) {
        return new TacoUser(userName, passwordEncoder.encode(password),
                fullName, street, city, state, zip, phone);
    }
}
