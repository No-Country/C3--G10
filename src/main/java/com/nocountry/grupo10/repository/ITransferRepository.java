package com.nocountry.grupo10.repository;


import com.nocountry.grupo10.model.entity.Transfer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Long> {

    Optional<Transfer> findById(long id);
}
