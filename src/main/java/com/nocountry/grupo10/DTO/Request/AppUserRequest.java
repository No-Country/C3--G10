package com.nocountry.grupo10.DTO.Request;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class AppUserRequest {
    
    @NotNull(message = "Name cannot be null,")
    private String name;

    @NotNull(message = "LastName cannot be null")
    private String lastName;

    @NotNull(message = "Username cannot be null")
    private String username;

    @NotNull(message = "Email cannot be null")
    private String email;

    private Long phoneNumber;

    @NotNull(message = "Document cannot be null")
    private Long document;

    @NotNull(message = "Address cannot be null")
    private String address;

    @NotNull(message = "Birthdate cannot be null")
    private LocalDate birthdate;

    @NotNull(message = "Password cannot be null")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
