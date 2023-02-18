package com.wz.wallet.mapper;

import org.apache.ibatis.annotations.Param;

public interface LogMapper {

    void insertLog(@Param("userId") Long userId,@Param("content") String content);
}