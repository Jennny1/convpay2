package com.example.convpay.config;

import com.example.convpay.service.CardAdapter;
import com.example.convpay.service.ConveniencePayService;
import com.example.convpay.service.DiscountByPayMethod;
import com.example.convpay.service.MoneyAdapter;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig {

    public ConveniencePayService conveniencePayServiceDiscountConvenience() {
        return new ConveniencePayService(new HashSet<>(Arrays.asList(new MoneyAdapter(), new CardAdapter())), new DiscountByPayMethod());

    }

    public ConveniencePayService conveniencePayServiceDiscountPayMethod() {
        return new ConveniencePayService(new HashSet<>(Arrays.asList(new MoneyAdapter(), new CardAdapter())), new DiscountByPayMethod());

    }
}
