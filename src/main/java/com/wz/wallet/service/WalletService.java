package com.wz.wallet.service;

import com.wz.wallet.entity.Result;

import java.math.BigDecimal;

public interface WalletService{


    BigDecimal balance(Long userId);

    void consume(Long userId,BigDecimal consume);

    void refund(Long userId, BigDecimal refund);
}
