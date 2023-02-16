package com.wz.wallet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wz.wallet.mapper")
public class WalletApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApiApplication.class, args);
    }

}
