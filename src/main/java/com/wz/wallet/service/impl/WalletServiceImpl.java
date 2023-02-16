package com.wz.wallet.service.impl;

import com.wz.wallet.mapper.WalletMapper;
import com.wz.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletMapper walletMapper;
    @Override
    public Long getBalance(Long userId) {
        Long balance =  walletMapper.selectById(userId);
        return balance;
    }
}
