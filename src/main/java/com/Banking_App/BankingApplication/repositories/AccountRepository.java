package com.Banking_App.BankingApplication.repositories;

import com.Banking_App.BankingApplication.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
