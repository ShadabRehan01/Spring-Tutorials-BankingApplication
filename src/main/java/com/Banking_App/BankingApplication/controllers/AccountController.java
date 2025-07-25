package com.Banking_App.BankingApplication.controllers;

import com.Banking_App.BankingApplication.dto.AccountDto;
import com.Banking_App.BankingApplication.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    //ADD ACCOUNT OR CREATE NEW ACCOUNT
    @PostMapping
    public ResponseEntity<AccountDto> createNewAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createNewAccount(accountDto), HttpStatus.CREATED);
    }
    // GET ACCOUNT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
    //DEPOSIT AMOUNT INTO ACCOUNT
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount"); // key will be store
        AccountDto accountDto = accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //WITHDRAW AMOUNT FROM ACCOUNT
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount"); // key will be store
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //GET ALL ACCOUNTS LIST
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountsDtoList = accountService.getAllAccounts();
        return ResponseEntity.ok(accountsDtoList);
    }
    //DELETE ACCOUNT BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccountById(@PathVariable Long id){
        boolean deleteAccount = accountService.deleteAccountById(id);
        return ResponseEntity.ok(deleteAccount);
    }
}
