package com.youlearn.SpringBootJPA.repository;

import com.youlearn.SpringBootJPA.model.BankUser;
import org.springframework.data.repository.CrudRepository;

public interface BankUserRepository extends CrudRepository<BankUser, Long> {
}
