package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountNumber(Long accountNumber);
    
    boolean existsByCvu(Long cvuNumber);

    List<Account> findBySoftDeleteIsNullOrSoftDeleteIsFalse();
    
    Optional<Account> findByCvu(Long cvu);
}
