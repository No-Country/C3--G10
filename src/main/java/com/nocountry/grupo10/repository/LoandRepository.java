package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.model.entity.Loand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoandRepository extends JpaRepository<Loand, Long> {


}
