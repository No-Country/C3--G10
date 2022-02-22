package com.nocountry.grupo10.configuration;

import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.model.entity.Role;
import com.nocountry.grupo10.model.entity.RoleType;
import com.nocountry.grupo10.repository.AppUserRepository;
import com.nocountry.grupo10.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.nocountry.grupo10.model.entity.RoleType.ROLE_ADMIN;
import static com.nocountry.grupo10.model.entity.RoleType.ROLE_USER;


/**
 * Una Clase para llenar la base de datos con Roles, un ADMIN y un USER
 * Corre al inicio de la aplicación y crea ROLE_ADMIN y ROLE_USER
 * Si la Tabla user esta vacia crea 2: 1 con ROLE_ADMIN y ROLE USER y otro solo con ROLE_USER
 * @author NoCountry-G10
 * @version 1.0
 */
@Configuration
public class InitialUsers implements CommandLineRunner {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        createRolesIfNotExist();
        createAdminIfNotExist();
    }

    public void createRolesIfNotExist(){

        if(roleRepository.findByName(RoleType.ROLE_ADMIN).isEmpty()){
            Role adminRole = new Role();
            adminRole.setName(ROLE_ADMIN);
            adminRole.setDescription("Rol de administrador tiene acceso total a las funcionalidades");
            roleRepository.save(adminRole);
        }
        if(roleRepository.findByName(ROLE_USER).isEmpty()){
            Role userRole = new Role();
            userRole.setName(RoleType.ROLE_USER);
            userRole.setDescription("Rol de usuario tiene acceso limitado a operar en el banco");
            roleRepository.save(userRole);
        }
    }


    public void createAdminIfNotExist(){

        Set<Role> roles = new HashSet<>();
        Optional<Role> roleAdministrador = roleRepository.findByName(ROLE_ADMIN);
        if(roleAdministrador.isPresent()) roles.add(roleAdministrador.get());
        Optional<Role> roleUser = roleRepository.findByName(ROLE_USER);
        if(roleUser.isPresent()) roles.add(roleUser.get());

        if(userRepository.findAll().isEmpty()){
            AppUser admin = new AppUser();
            admin.setName("initial");
            admin.setLastName("admin");
            admin.setUsername("admin");
            admin.setEmail("admin@gmail.com");
            admin.setPhoneNumber(2616112237l);
            admin.setDocument(43553949l);
            admin.setAddress("Calle falsa");
            admin.setAddressNumber(123l);
            String initialDate = "1999/03/15";
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            admin.setBirthdate(LocalDate.parse(initialDate, df));
            admin.setPassword("q1w2e3r4");
            admin.setRoles(roles);
            userRepository.save(admin);
            createUserIfNotexist();
        }
    }

    public void createUserIfNotexist(){

        Set<Role> roles = new HashSet<>();
        Optional<Role> roleUser = roleRepository.findByName(ROLE_USER);
        if(roleUser.isPresent()) roles.add(roleUser.get());

            AppUser user = new AppUser();
            user.setName("initial");
            user.setLastName("user");
            user.setUsername("user");
            user.setEmail("user@gmail.com");
            user.setPhoneNumber(2616123456l);
            user.setDocument(10213688l);
            user.setAddress("San Martin");
            user.setAddressNumber(7253l);
            String initialDate = "1999/03/15";
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            user.setBirthdate(LocalDate.parse(initialDate,df));
            user.setPassword("q1w2e3r4");
            user.setRoles(roles);
            userRepository.save(user);

    }




}
