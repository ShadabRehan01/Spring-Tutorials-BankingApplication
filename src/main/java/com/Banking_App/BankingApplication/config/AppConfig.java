package com.Banking_App.BankingApplication.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//First inject the dependency of model mapper
@Configuration
public class AppConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
