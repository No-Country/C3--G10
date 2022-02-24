package com.nocountry.grupo10.repository;


import com.nocountry.grupo10.model.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transfer, Long> {


}
