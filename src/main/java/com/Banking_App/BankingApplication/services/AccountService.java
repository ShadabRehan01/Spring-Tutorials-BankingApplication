package com.Banking_App.BankingApplication.services;

import com.Banking_App.BankingApplication.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createNewAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    boolean deleteAccountById(Long id);
}
