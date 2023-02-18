package com.wz.wallet.utils;

import com.wz.wallet.entity.Log;
import com.wz.wallet.entity.User;
import com.wz.wallet.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;

    //切入点
    @Pointcut("@annotation(com.wz.wallet.utils.LogAnno)")
    public void logPointCut(){
    }


    //配置huanraotzh
    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        //获取钱包操作金额数并且存入log对象
        Object[] args = joinPoint.getArgs();
        Log log = new Log();
        Long userId = (Long) args[0];
        log.setUserId(userId);
        //从注解获取操作方式并且存入log对象
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LogAnno annotation = methodSignature.getMethod().getAnnotation(LogAnno.class);
        String doString = annotation.value();//获取操作内容
        BigDecimal number = (BigDecimal) args[1];//获取操作金额
        String content = doString+number+"元";//拼接成日志内容
        log.setContent(content);
        //存入数据库
        logService.saveLog(log);
        return result;
    }

}
