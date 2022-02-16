package com.nocountry.grupo10.model.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUser;

    @Column(name = "name")
    @NotBlank
    @Size(min = 6, max = 50)
    private String name;

    @Column(name = "last_name")
    @NotBlank
    @Size(min = 6, max = 50)
    private String lastName;

    @Column(name = "email", unique = true)
    @NotBlank
    @Email
    @Size(min = 12, max = 50)
    private String email;

    @Column(name = "phone_number")
    @NotBlank
    @Size(min = 8, max = 12)
    private Long phoneNumber;

    @Column(name = "dni")
    @NotBlank
    @Size(min = 7, max = 8)
    private Long document;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "adress_number", nullable = false)
    private Long adressNumber;

    @Column(name = "birthdate")
    @NotBlank
    @DateTimeFormat(
            pattern = "yyyy/MM/dd"
    )
    @NotBlank
    private LocalDate birthdate;

    @Column(name = "password")
    @NotBlank
    @Size(min = 8)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles = new ArrayList<>();


    //TODO: Email como username para logear?? o aplicar username

}