package com.example.convpay.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.convpay.type.CardUseCancelResult;
import com.example.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

class CardAdapterTest {

  private CardAdapter cardAdapter = new CardAdapter();

  // 매입 테스트
  // 100원 이하면 성공
  // 100원 이상이면 실패
  @Test
  void capture_success() {
    // given
    Integer payAmount = 99;

    // when
    CardUseResult cardUseResult = cardAdapter.capture(payAmount);

    // then
    assertEquals(CardUseResult.USE_SUCCESS, cardUseResult);

  }


  @Test
  void capture_fail() {
    // given
    Integer payAmount = 101;

    // when
    CardUseResult cardUseResult = cardAdapter.capture(payAmount);

    // then
    assertEquals(CardUseResult.USE_FAIL, cardUseResult);

  }

  // 매입 취소 테스트
  // 1000원 이상이면 성공
  // 100원 이하면 실패

  @Test
  void cancelCapture_success() {
    // given
    Integer cancelAmount = 1001;

    // when
    CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

    // then
    assertEquals(CardUseCancelResult.USE_CANCEL_SUCCESS, cardUseCancelResult);


  }


  @Test
  void cancelCapture_fail() {
    // given
    Integer cancelAmount = 99;

    // when
    CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

    // then
    assertEquals(CardUseCancelResult.USE_CANCEL_FAIL, cardUseCancelResult);


  }


}