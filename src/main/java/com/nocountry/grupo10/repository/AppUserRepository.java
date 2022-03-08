package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

/**
 * Interface repositorio de la Clase AppUser.
 * @author NoCountry-G10
 * @version 1.0
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByNameAndLastName(String name, String lastName);
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByDocument(Long document);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByNameAndLastName(String name, String lastName);
    //TODO: En caso de que concatenar nombres no funcione, implementar manualmente los metodos.!!

}
