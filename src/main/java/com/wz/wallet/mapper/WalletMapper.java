package com.wz.wallet.mapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface WalletMapper {

    BigDecimal queryBalance(@Param("userId") Long userId);

    int updateBalanceByConsume(@Param("userId") Long userId, @Param("consume") BigDecimal consume);

    void updateBalanceByRefund(@Param("userId") Long userId, @Param("refund") BigDecimal refund);
}