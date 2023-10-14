package com.example.convpay.dto;

import com.example.convpay.type.PayResult;

/*
결제 응답객체
-결제 결과
-결제 성공 금액
 */
public class PayResponse {

  // 결제 결과
  PayResult payResult;

  // 결제 성공 금액
  Integer paidAmount;


  // 생성자
  public PayResponse(PayResult payResult, Integer paidAmount) {
    this.payResult = payResult;
    this.paidAmount = paidAmount;
  }

  // Getter, Setter
  public PayResult getPayResult() {
    return payResult;
  }

  public void setPayResult(PayResult payResult) {
    this.payResult = payResult;
  }

  public Integer getPaidAmount() {
    return paidAmount;
  }

  public void setPaidAmount(Integer paidAmount) {
    this.paidAmount = paidAmount;
  }


  @Override
  public String toString() {
    return "PayResponse{" + "payResult=" + payResult + ", paidAmount=" + paidAmount + '}';
  }
}
