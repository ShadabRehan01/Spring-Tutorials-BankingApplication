/*

package com.Banking_App.BankingApplication.config;

import com.Banking_App.BankingApplication.dto.AccountDto;
import com.Banking_App.BankingApplication.entities.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
              account.getId(),
              account.getAccountHolderName(),
              account.getBalance()
        );
    }
//    We can also use ModelMapper for reduced Boilerplate Code
//    @Configuration
//    public class ModelConfig {
//        @Bean
//        public ModelMapper getModelMapper(){
//            return new ModelMapper();
//        }
//    }
}

*/
