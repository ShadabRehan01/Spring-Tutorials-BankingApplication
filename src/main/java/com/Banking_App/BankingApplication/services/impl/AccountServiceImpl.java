package com.Banking_App.BankingApplication.services.impl;

// import com.Banking_App.BankingApplication.config.AccountMapper;
import com.Banking_App.BankingApplication.dto.AccountDto;
import com.Banking_App.BankingApplication.entities.Account;
import com.Banking_App.BankingApplication.exception.ResourceNotFoundException;
import com.Banking_App.BankingApplication.repositories.AccountRepository;
import com.Banking_App.BankingApplication.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public AccountDto createNewAccount(AccountDto accountDto) {
//        Account account = AccountMapper.mapToAccount(accountDto); // dto to entity
//        Account savedAccount = accountRepository.save(account);
//        return AccountMapper.mapToAccountDto(savedAccount);

        Account account = modelMapper.map(accountDto,Account.class); // dto to entity
        return modelMapper.map(accountRepository.save(account),AccountDto.class);
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account = accountRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Account not found with id: "+id));
//        return AccountMapper.mapToAccountDto(account);
        return modelMapper.map(account,AccountDto.class);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Account not found with id: "+id));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
//        return AccountMapper.mapToAccountDto(savedAccount);
        return modelMapper.map(savedAccount,AccountDto.class);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Account not found with id: "+id));
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount,please try again");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
//        return AccountMapper.mapToAccountDto(savedAccount);
        return modelMapper.map(savedAccount,AccountDto.class);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
//        return accountRepository.findAll()
//                .stream()
//                .map(account -> AccountMapper.mapToAccountDto(account))
//                .collect(Collectors.toList());
        return accountRepository.findAll()
                .stream()
                .map(account -> modelMapper.map(account,AccountDto.class))
                .collect(Collectors.toList());
    }

    public void isExistByAccountId(Long accountId){
        boolean exist = accountRepository.existsById(accountId);
        if(!exist) throw new ResourceNotFoundException("Account not found with Id: "+accountId);
    }

    @Override
    public boolean deleteAccountById(Long id) {
        isExistByAccountId(id);
        accountRepository.deleteById(id);
        return true;
    }

}
