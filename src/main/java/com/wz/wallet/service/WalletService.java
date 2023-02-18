package com.wz.wallet.service;


import java.math.BigDecimal;

public interface WalletService {


    BigDecimal balance(Long userId);

    void consume(Long userId, BigDecimal consume);

    void refund(Long userId, BigDecimal refund);
}
