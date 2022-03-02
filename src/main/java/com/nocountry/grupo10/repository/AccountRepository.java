package com.nocountry.grupo10.repository;


import com.nocountry.grupo10.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountNumber(Long AccountNumber);

    List<Account> findBySoftDeleteIsNullOrSoftDeleteIsFalse();
}