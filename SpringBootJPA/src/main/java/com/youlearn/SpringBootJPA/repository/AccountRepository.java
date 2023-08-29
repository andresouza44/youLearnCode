package com.youlearn.SpringBootJPA.repository;

import com.youlearn.SpringBootJPA.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
