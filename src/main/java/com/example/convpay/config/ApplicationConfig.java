package com.example.convpay.config;

import com.example.convpay.service.CardAdapter;
import com.example.convpay.service.ConveniencePayService;
import com.example.convpay.service.DiscountByPayMethod;
import com.example.convpay.service.MoneyAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {
    @Bean
    public ConveniencePayService conveniencePayService() {
        return new ConveniencePayService(new HashSet<>(Arrays.asList(moneyAdapter(), getCardAdapter())), getDiscountInterface());

    }

    @Bean
    private static CardAdapter getCardAdapter() {
        return new CardAdapter();
    }

    @Bean
    private static MoneyAdapter moneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public static DiscountByPayMethod getDiscountInterface() {
        return new DiscountByPayMethod();
    }

}
