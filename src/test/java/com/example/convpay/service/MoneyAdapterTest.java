package com.example.convpay.service;

import static com.example.convpay.type.MoneyUseResult.USE_FAIL;
import static com.example.convpay.type.MoneyUseResult.USE_SUCCESS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.convpay.type.MoneyUseCancelResult;
import com.example.convpay.type.MoneyUseResult;
import org.junit.jupiter.api.Test;

class MoneyAdapterTest {

  MoneyAdapter moneyAdapter = new MoneyAdapter();

  @Test
  void money_use_fail() {
    // given
    Integer payAmount = 1000_001;

    // when
    MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

    // then
    assertEquals(USE_FAIL, moneyUseResult);


  }

  @Test
  void money_use_success() {
    // given
    Integer payAmount = 1000_000;

    // when
    MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

    // then
    assertEquals(USE_SUCCESS, moneyUseResult);


  }

  @Test
  void money_use_cancel_success() {
    // given
    Integer paycancelAmount = 101;

    // when
    MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(paycancelAmount);

    // then
    assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS, moneyUseCancelResult);
  }


  @Test
  void money_use_cancel_fail() {
    // given
    Integer paycancelAmount = 99;

    // when
    MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(paycancelAmount);

    // then
    assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL, moneyUseCancelResult);
  }
}