package com.easy.mall.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Pointcut(value="execution(* com.easy.mall.service.impl.*.*(..))")
    public void point(){
    }


//    @Around("execution(* com.easy.mall.service.impl.*.*(..))")
    @Around(value = "point()")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("========== 开始执行 {}.{} ==========", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        if (duration > 3000) {
            logger.error("执行结束，耗时：{} 毫秒", duration);
        } else if (duration > 2000) {
            logger.warn("执行结束，耗时：{} 毫秒", duration);
        } else {
            logger.info("执行结束，耗时：{} 毫秒", duration);
        }
        return result;
    }

    @After(value = "point()")
    public void afterLog() {
        logger.info("========== 执行结束 ==========");
    }
}
