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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
결제
결제취소
 */
@Component
public class ConveniencePayService {

  private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap = new HashMap<>();
  private final DiscountInterface discountInterface;

  // 인터페이스 생성자
  public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                               @Qualifier("discountByConvenience")
                               DiscountInterface discountInterface) {

    paymentInterfaceSet.forEach(
            paymentInterface -> paymentInterfaceMap.put(
                    paymentInterface.getPayMethodType(),
                    paymentInterface
            )
    );

    this.discountInterface = discountInterface;
  }


/*
  private final MoneyAdapter moneyAdapter = new MoneyAdapter();
  private final CardAdapter cardAdapter = new Card);
  private final DiscountInterface discountInterface = new Adapter(DiscountByPayMethod();
  private final DiscountInterface discountInterface = new DiscountByConvenience();
*/

  public PayResponse pay(PayRequest payRequest) {
    // paymentInterfaceMap에서 key로 결제수단을 가져옴
    PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());

    Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
    PaymentResult payment = paymentInterface.payment(discountedAmount);

    // Exception Case
    if (payment == PaymentResult.PAYMENT_FAIL) {
      return new PayResponse(PayResult.FAIL, 0);
    }

    // Success Case (Only One)
    return new PayResponse(PayResult.SUCCESS, discountedAmount);

  }

  public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
    // paymentInterfaceMap에서 key로 결제수단을 가져옴
    PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());


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
