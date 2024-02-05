package cn.devcorp.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Aspect
public class LoggerAspect {
    @Pointcut("@annotation(cn.devcorp.demo.annocation.EsealAuditLog)")
    public void logPointCut() {

    }
    @Around("logPointCut()")
    public Object beforeAdviceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取连接点所对应的方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的方法的参数
        Object[] args = joinPoint.getArgs();
        Optional<Object> optional = Arrays.stream(args).filter(arg -> arg instanceof String && "name".equals(arg))
                .findFirst();
        optional.ifPresent(object -> {
            System.out.println("找到相关元素");
        });
        System.out.println("LoggerAspect,方法: "+signature.getName()+",参数: "+ Arrays.toString(args));
        Object result = joinPoint.proceed();
        return result;
    }
}