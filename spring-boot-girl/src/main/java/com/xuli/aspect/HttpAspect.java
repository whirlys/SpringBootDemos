package com.xuli.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/18.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    /**
     * 共用方法，面向切面方法
     */
    @Pointcut("execution(public * com.xuli.controller.GirlController.*(..))")
    public void log(){

    }

    /**
     * 控制层执行之前执行doBefore
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("1111111111");

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        logger.info("url={}", request.getRequestURL());
        // method
        logger.info("method={}", request.getMethod());
        // ip
        logger.info("id={}", request.getRemoteAddr());
        // 类方法
        logger.info("class_Method={}", joinPoint.getSignature().getDeclaringTypeName()+'.'+joinPoint.getSignature().getName() );
        // 参数
        logger.info("args={}", joinPoint.getArgs());
    }

    /**
     * 控制层执行结束后执行doAfter
     */
    @After("log()")
    public void doAfter(){
        logger.info("2222222222");
    }

    /**
     * 执行结束后返回的结果打印出来
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturn(Object object){
//        logger.info("response={}", object.toString());
    }
}
