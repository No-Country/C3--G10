package com.nocountry.grupo10.model.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/**
 * Entidad encargada de generar la tabla "user"
 * Usa nombre AppUser para diferenciarse de la clase "User" del package de security
 * Sus valores iniciales en DB se crean con un CommandLineRunner
 * El request de datos se hace via {@link com.nocountry.grupo10.authsecurity.payload.request.SignupRequest}
 * @author NoCountry-Grupo10
 * @version 1.0
 */
@Entity
@Table(name = "user")
@Data
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "name")
    @NotBlank
    @Size(min = 3, max = 25)
    private String name;

    @Column(name = "last_name")
    @NotBlank
    @Size(min = 3, max = 25)
    private String lastName;


    @Column(name = "username")
    @NotBlank
    @Size(min = 3, max = 40)
    private String username;

    @Column(name = "email", unique = true)
    @Email
    @NotBlank
    @Size(max = 50)
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "dni")
    private Long document;

    @Column(name = "address")
    @NotBlank
    @Size(min = 3, max = 40)
    private String address;

    @Column(name = "address_number")
    private Long addressNumber;

    @Column(name = "birthdate")
    @DateTimeFormat(
            pattern = "yyyy/MM/dd"
    )

    private LocalDate birthdate;

    @Column(name = "password")
    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet();

    @OneToOne
    private Loan loan;
}