package com.example.convpay;

import com.example.convpay.dto.PayCancelRequest;
import com.example.convpay.dto.PayCancelResponse;
import com.example.convpay.dto.PayRequest;
import com.example.convpay.dto.PayResponse;
import com.example.convpay.service.ConveniencePayService;
import com.example.convpay.type.ConvenienceType;
import com.example.convpay.type.PayMethodType;

public class UserClient {

  public static void main(String[] args) {
    // 사용자 -> 편결이 -> 머니
    ConveniencePayService conveniencePayService = new ConveniencePayService();

    // G25, 결제 1000원
    PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);
    PayResponse payResponse = conveniencePayService.pay(payRequest);

    System.out.println(payResponse);

    // G25, 취소 500원
    PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,
        ConvenienceType.G25, 500);
    PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

    System.out.println(payCancelResponse);


  }

}
