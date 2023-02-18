package com.wz.wallet.controller;

import com.wz.wallet.entity.Result;
import com.wz.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
* (tb_wallet)表控制层
*
* @author wz
*/
@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    /**
     * 获取钱包余额
     * @param userId 用户id
     * @return Result<String>
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
     * @param userId 用户id
     * @param consume 消费金额
     * @return Result<String>
     */

    @GetMapping("/consume")
    public Result<String> consume(@RequestParam Long userId,@RequestParam BigDecimal consume){
        walletService.consume(userId, consume);
        return Result.success("消费成功");
    }

    /**
     * 退款接口
     * @param userId 用户id
     * @param refund 退费金额
     * @return Result<String>
     */

    @PostMapping("/refund")
    public Result<String> refund(@RequestParam Long userId,@RequestParam BigDecimal refund){
        walletService.refund(userId, refund);
        return Result.success("退款成功");
    }


}
