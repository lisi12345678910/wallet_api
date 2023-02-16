package com.wz.wallet.mapper;


import org.apache.ibatis.annotations.Param;


public interface WalletMapper {

    Long selectById(@Param("userId") Long userId);
}