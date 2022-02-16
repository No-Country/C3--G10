package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByNameAndLastName(String name, String lastName);
    Boolean existsByEmail(String email);
    Boolean existsByNameAndLastName(String name, String lastName);
    //TODO: En caso de que concatenar nombres no funcione, implementar manualmente los metodos!!
}
