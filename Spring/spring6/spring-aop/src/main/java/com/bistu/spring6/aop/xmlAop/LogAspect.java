package com.bistu.spring6.aop.xmlAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//在ioc容器中管理
@Component
public class LogAspect {
    //设置切入点和通知类型

    //切入点表达式
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--前置通知" + methodName + Arrays.toString(args));
    }

    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--后置通知" + methodName);
    }

    public void afterReturn(JoinPoint joinPoint, Object result) {

        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--返回通知" + methodName + " " + result);
    }

    public void afterThrow(JoinPoint joinPoint, Throwable ex) {

        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--异常通知" + methodName + " " + ex);
    }

    public Object around(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("环绕通知--目标方法之前");
            result = joinPoint.proceed();
            System.out.println("环绕通知--目标方法返回值之后");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知--出现异常执行");
        } finally {
            System.out.println("环绕通知--目标方法执行完毕");
        }
        return result;
    }

}
