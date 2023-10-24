package com.example.convpay.service;

import com.example.convpay.type.*;
import org.springframework.stereotype.Component;


// 머니 사용
@Component
public class MoneyAdapter implements PaymentInterface {

  public MoneyUseResult use(Integer payAmount) {
    System.out.println("MoneyAdapter.use : " + payAmount);

    // 100만원 이상은 결제실패
    if (payAmount > 1000_000) {
      return MoneyUseResult.USE_FAIL;
    }

    return MoneyUseResult.USE_SUCCESS;

  }


  // 머니 사용 취소
  public MoneyUseCancelResult useCancel(Integer payCancelAmount) {
    System.out.println("MoneyAdapter.useCancel : " + payCancelAmount);

    //
    if (payCancelAmount < 100) {
      return MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL;
    }

    return MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS;

  }

  @Override
  public PayMethodType getPayMethodType() {
    return PayMethodType.MONEY;
  }

  @Override
  public PaymentResult payment(Integer payAmount) {
    MoneyUseResult moneyUseResult = use(payAmount);

    if (moneyUseResult == MoneyUseResult.USE_FAIL) {
      return PaymentResult.PAYMENT_FAIL;
    }
    return PaymentResult.PAYMENT_SUCCESS;
  }

  @Override
  public CancelPaymentResult cancelPayment(Integer cancelAmount) {
    MoneyUseCancelResult moneyUseCancelResult = useCancel(cancelAmount);

    if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
      return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
    }
    return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;

  }
}
