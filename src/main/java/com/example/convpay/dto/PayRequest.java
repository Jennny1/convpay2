package com.example.convpay.dto;

import com.example.convpay.type.ConvenienceType;
import com.example.convpay.type.PayMethodType;

/*
결제 요청객체
- 편의점 종류
- 결제 금액
 */
public class PayRequest {
  // 결제수단
  PayMethodType payMethodType;
  // 편의점 종류
  ConvenienceType convenienceType;

  // 결제 금액
  Integer payAmount;


  // 생성자
  public PayRequest(PayMethodType payMethodType, ConvenienceType convenienceType,
      Integer payAmount) {
    this.payMethodType = payMethodType;
    this.convenienceType = convenienceType;
    this.payAmount = payAmount;
  }

  // Getter, Setter
  public ConvenienceType getConvenienceType() {
    return convenienceType;
  }

  public void setConvenienceType(ConvenienceType convenienceType) {
    this.convenienceType = convenienceType;
  }

  public Integer getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(Integer payAmount) {
    this.payAmount = payAmount;
  }

  public PayMethodType getPayMethodType() {
    return payMethodType;
  }

  public void setPayMethodType(PayMethodType payMethodType) {
    this.payMethodType = payMethodType;
  }
}
