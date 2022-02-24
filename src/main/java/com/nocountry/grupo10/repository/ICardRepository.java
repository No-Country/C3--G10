package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.model.entity.Card;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long>{
    
    boolean existsByCardNumber(Long cardNumber);
    
    List<Card> findBySoftDeleteIsNullOrSoftDeleteIsFalse();
}
