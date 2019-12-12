package hello.logger;

import hello.logger.base.AspectBaseLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogHelloAspect {

    @Autowired
    AspectBaseLog aspectBaseLog;

    private Logger logger = LogManager.getLogger("/hello-greeting-LoggerDB");

    @Pointcut("execution(* hello.controller.Controller.*(..))")
    public void greeting() { }

    @AfterReturning(pointcut = "execution(* hello.controller.Controller.greeting(..))",returning = "retVal")
    public void greetingReturn(JoinPoint joinPoint, Object retVal) {
        aspectBaseLog.afterReturningLogging(joinPoint,retVal);
        logger.info("hello --> greetingReturn  --> AfterReturning");
    }

    @AfterThrowing(pointcut = "execution(* hello.controller.Controller.greeting(..))", throwing = "exec")
    public void greetingThrow(JoinPoint joinPoint, Exception exec) {
        aspectBaseLog.afterThrowingLoging(joinPoint, exec);
        logger.info("/hello --> greetingThrow  --> AfterThrowing --> NOT SUCCESSFUL");
    }
}
