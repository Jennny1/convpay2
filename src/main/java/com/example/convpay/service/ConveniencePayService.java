package com.example.convpay.service;

import com.example.convpay.dto.PayCancelRequest;
import com.example.convpay.dto.PayCancelResponse;
import com.example.convpay.dto.PayRequest;
import com.example.convpay.dto.PayResponse;
import com.example.convpay.type.CancelPaymentResult;
import com.example.convpay.type.PayCancelResult;
import com.example.convpay.type.PayMethodType;
import com.example.convpay.type.PayResult;
import com.example.convpay.type.PaymentResult;

/*
결제
결제취소
 */
public class ConveniencePayService {

  private final MoneyAdapter moneyAdapter = new MoneyAdapter();
  private final CardAdapter cardAdapter = new CardAdapter();
  private final DiscountInterface discountInterface = new DiscountByPayMethod();


  public PayResponse pay(PayRequest payRequest) {
    PaymentInterface paymentInterface;

    if (payRequest.getPayMethodType() == PayMethodType.CARD) {
      paymentInterface = cardAdapter;
    } else {
      paymentInterface = moneyAdapter;
    }

    PaymentResult payment = paymentInterface.payment(payRequest.getPayAmount());

    // Exception Case
    if (payment == PaymentResult.PAYMENT_FAIL) {
      return new PayResponse(PayResult.FAIL, 0);
    }

    // Success Case (Only One)
    return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());

  }

  public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
    PaymentInterface paymentInterface;

    if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
      paymentInterface = cardAdapter;
    } else {
      paymentInterface = moneyAdapter;
    }

    CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(
        payCancelRequest.getPayCancelAmount());

    // Exception Case
    if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
      return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
    }

    // Success Case
    return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
        payCancelRequest.getPayCancelAmount());
  }
}
