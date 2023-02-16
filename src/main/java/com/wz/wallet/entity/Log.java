package com.wz.wallet.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private Long id;

    private String content;

    private Date createTime;
}