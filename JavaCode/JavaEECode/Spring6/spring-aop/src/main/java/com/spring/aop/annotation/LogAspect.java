package com.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.util.Arrays;

@Component //ioc容器，交给spring管理
@Aspect //表示这是一个切面类
public class LogAspect {

    //设置切入点和通知类型

    //重用切入点表达式
    @Pointcut(value = "execution(* com.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    //通知类型：前置 @Before(value = "切入点表达式")
    //切入点表达式：execution(访问修饰符 + 方法返回值 + 增强方法所在类全路径.方法名称(参数) )
    @Before(value = "execution(* com.spring.aop.annotation.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知，方法为" +  methodName + "，参数："+ Arrays.toString(args));
    }

    //        后置 @After()
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("后置通知,方法为"+methodName);
    }
    //        返回 @AfterReturning
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterRetuningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("返回通知，方法为" +  methodName + "，返回结果：" +result);
    }

    //        异常 @AfterThrowing
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常通知，方法为" +  methodName + "，异常信息：" +ex);
    }

    //        环绕 @Around()
    @Around(value = "pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsString = Arrays.toString(args);
        Object result = null;
        try{
            System.out.println("环绕通知==目标方法之前执行");

            result = joinPoint.proceed();

            System.out.println("环绕通知==目标方法返回值之后");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常执行");
        }finally {
            System.out.println("环绕通知==目标方法执行完毕执行");
        }
        return result;
    }

}
