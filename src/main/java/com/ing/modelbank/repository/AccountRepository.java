package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumber(Integer accountNumber);

}


