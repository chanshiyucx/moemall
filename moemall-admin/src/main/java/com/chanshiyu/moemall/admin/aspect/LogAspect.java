package com.chanshiyu.moemall.admin.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SHIYU
 * @date 2019/10/9 10:54
 * @description
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.chanshiyu.moemall.admin.controller.*.*(..))")
    public void log() {}

    /**
     * 前置通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        log.info("Request Args   : {}", JSONUtil.parse(joinPoint.getArgs()));
    }

    /**
     * 后置通知
     * @throws Throwable
     */
    @After("log()")
    public void doAfter() throws Throwable {}

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args  : {}", JSONUtil.parse(result));
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

    /**
     * 返回后通知
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("RESPONSE       : {}", object.toString());
        log.info("=========================================== End ===========================================");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(pointcut = "log()")
    public void doAfterThrowing() {
        log.error("doAfterThrowing: {}", " 异常情况!");
    }

}
