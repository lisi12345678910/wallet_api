package com.wz.wallet.service.impl;

import com.wz.wallet.entity.CustomException;
import com.wz.wallet.entity.Result;
import com.wz.wallet.mapper.LogMapper;
import com.wz.wallet.mapper.WalletMapper;
import com.wz.wallet.service.WalletService;
import com.wz.wallet.utils.LogAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletMapper walletMapper;



    @Override
    public BigDecimal balance(Long userId) {
        return walletMapper.queryBalance(userId);
    }
    @LogAnno("消费")
    @Override
    public void consume(Long userId,BigDecimal consume) {

        //用正则判断小数位数
        String regular = "^[0-9]+(\\.[0-9]{1,2})?$";
        if (!consume.stripTrailingZeros().toPlainString().matches(regular)) {
            throw new CustomException("请输入正确的格式");
        }

        //判断余额
        BigDecimal balance = walletMapper.queryBalance(userId);
        if (balance.compareTo(consume) < 1) {
            throw new CustomException("余额不足");
        }

        walletMapper.updateBalanceByConsume(userId, consume);
    }
    @LogAnno("退款")
    @Override
    public void refund(Long userId, BigDecimal refund) {

        //用正则判断小数位数
        String regular = "^[0-9]+(\\.[0-9]{1,2})?$";
        if (!refund.stripTrailingZeros().toPlainString().matches(regular)) {
            throw new CustomException("请输入正确的格式");
        }

        walletMapper.updateBalanceByRefund(userId,refund);
    }



}
