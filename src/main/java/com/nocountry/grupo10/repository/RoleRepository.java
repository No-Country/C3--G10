package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.model.entity.Role;
import com.nocountry.grupo10.model.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
