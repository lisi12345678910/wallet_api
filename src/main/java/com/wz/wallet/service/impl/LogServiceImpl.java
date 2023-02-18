package com.wz.wallet.service.impl;

import com.wz.wallet.entity.Log;
import com.wz.wallet.mapper.LogMapper;
import com.wz.wallet.service.LogService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {


    private final LogMapper logMapper;


    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    @Async//异步
    @Override
    public void saveLog(Log log) {
        logMapper.insertLog(log.getUserId(), log.getContent());
    }
}
