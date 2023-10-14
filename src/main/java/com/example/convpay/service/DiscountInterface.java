package com.example.convpay.service;

import com.example.convpay.dto.PayRequest;

public interface DiscountInterface {

  // 할인된 금액
  Integer getDiscountedAmount(PayRequest payRequest);

}
