package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
   //TODO: Ver si este método es necesario!!!
    // Optional<Loan>findByUserAppDocument(Long document);


}
