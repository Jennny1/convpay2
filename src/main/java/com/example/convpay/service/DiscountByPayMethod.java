package com.example.convpay.service;

import com.example.convpay.dto.PayRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class DiscountByPayMethod implements DiscountInterface{

  @Override
  public Integer getDiscountedAmount(PayRequest payRequest) {
    switch (payRequest.getPayMethodType()) {

      case MONEY:
        return payRequest.getPayAmount() * 7 / 10;
      case CARD:
        return payRequest.getPayAmount();
    }
    return payRequest.getPayAmount();
  }
}
