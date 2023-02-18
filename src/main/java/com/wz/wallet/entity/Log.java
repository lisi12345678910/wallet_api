package com.wz.wallet.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private Long id;
    private Long userId;

    private String content;

    private Date timeStamp;
}