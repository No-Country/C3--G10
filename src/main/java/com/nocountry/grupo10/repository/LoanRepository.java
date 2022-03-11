package com.nocountry.grupo10.repository;


import com.nocountry.grupo10.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findAllByStateTrue();
    List<Loan> findAllByStateFalse();
}
