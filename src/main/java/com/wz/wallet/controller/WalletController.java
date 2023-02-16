package com.wz.wallet.controller;

import com.wz.wallet.entity.Result;
import com.wz.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* (tb_wallet)表控制层
*
* @author
*/
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    /**
     * 获取钱包余额
     * @param
     * @return
     */
    @GetMapping("/balance/{userId}")
    public Result<Long> getBalance(@PathVariable("userId") Long userId){
        Long balance = walletService.getBalance(userId);
        return Result.success(balance);
    }


}
