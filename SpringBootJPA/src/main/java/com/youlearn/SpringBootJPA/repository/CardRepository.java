package com.youlearn.SpringBootJPA.repository;

import com.youlearn.SpringBootJPA.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
