package com.wz.wallet.controller;

import com.wz.wallet.entity.Result;
import com.wz.wallet.service.WalletService;
import com.wz.wallet.utils.LogAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
     *
     * @param
     * @return
     */
    @GetMapping("/balance/{userId}")
    @ResponseBody
    public Result<String> balance(@PathVariable("userId") Long userId){
        BigDecimal balance = walletService.balance(userId);
        String strBalance = balance.stripTrailingZeros().toPlainString();
        return Result.success(strBalance);
    }

    /**
     * 消费接口
     * @param
     * @return
     */

    @GetMapping("/consume")
    public Result<String> consume(@RequestParam Long userId,@RequestParam BigDecimal consume){
        walletService.consume(userId, consume);
        return Result.success("消费成功");
    }

    /**
     * 退款接口
     * @param
     * @return
     */

    @PostMapping("/refund")
    public Result<String> refund(@RequestParam Long userId,@RequestParam BigDecimal refund){
        walletService.refund(userId, refund);
        return Result.success("退款成功");
    }


}
