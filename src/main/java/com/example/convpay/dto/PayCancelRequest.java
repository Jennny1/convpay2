package com.example.convpay.dto;

import com.example.convpay.type.ConvenienceType;
import com.example.convpay.type.PayMethodType;

public class PayCancelRequest {
  // 결제수단
  PayMethodType payMethodType;

  // 편의점 종류
  ConvenienceType convenienceType;

  // 결제 취소 금액
  Integer payCancelAmount;


  // 생성자
  public PayCancelRequest(PayMethodType payMethodType, ConvenienceType convenienceType,
      Integer payCancelAmount) {
    this.payMethodType = payMethodType;
    this.convenienceType = convenienceType;
    this.payCancelAmount = payCancelAmount;
  }

  // Getter Setter
  public PayMethodType getPayMethodType() {
    return payMethodType;
  }

  public void setPayMethodType(PayMethodType payMethodType) {
    this.payMethodType = payMethodType;
  }

  public ConvenienceType getConvenienceType() {
    return convenienceType;
  }

  public void setConvenienceType(ConvenienceType convenienceType) {
    this.convenienceType = convenienceType;
  }

  public Integer getPayCancelAmount() {
    return payCancelAmount;
  }

  public void setPayCancelAmount(Integer payCancelAmount) {
    this.payCancelAmount = payCancelAmount;
  }
}
