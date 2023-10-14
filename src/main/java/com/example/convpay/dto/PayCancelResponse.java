package com.example.convpay.dto;

import com.example.convpay.type.PayCancelResult;

public class PayCancelResponse {

  PayCancelResult payCancelResult;

  Integer payCanceledAmount;


  // 생성자
  public PayCancelResponse(PayCancelResult payCancelResult, Integer payCancelAmount) {
    this.payCancelResult = payCancelResult;
    this.payCanceledAmount = payCancelAmount;
  }

  // Getter Setter
  public PayCancelResult getPayCancelResult() {
    return payCancelResult;
  }

  public void setPayCancelResult(PayCancelResult payCancelResult) {
    this.payCancelResult = payCancelResult;
  }

  public Integer getPayCancelAmount() {
    return payCanceledAmount;
  }

  public void setPayCancelAmount(Integer payCancelAmount) {
    this.payCanceledAmount = payCancelAmount;
  }

  @Override
  public String toString() {
    return "PayCancelResponse{" + "payCancelResult=" + payCancelResult + ", payCanceledAmount="
        + payCanceledAmount + '}';
  }
}
