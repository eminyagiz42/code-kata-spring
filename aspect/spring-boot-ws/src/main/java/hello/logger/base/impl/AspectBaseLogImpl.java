package hello.logger.base.impl;

import hello.logger.base.AspectBaseLog;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectBaseLogImpl implements AspectBaseLog {
    @Override
    public void afterReturningLogging(JoinPoint joinPoint, Object retVal) {
        Object[] lArgs = joinPoint.getArgs();
        String strWorld = ((String)lArgs[0]);
        System.out.println(strWorld);
    }

    @Override
    public void afterThrowingLoging(JoinPoint joinPoint, Exception exec) {
        Object[] lArgs = joinPoint.getArgs();
        String message = exec.getMessage();
        StackTraceElement[] stacktrace = exec.getStackTrace();
        //String message = ExceptionUtils.getMessage(exec);
        //String stacktrace = ExceptionUtils.getStackTrace(exec);
        String strWorld = ((String)lArgs[0]);
        System.out.println("World : " + strWorld + "\nMessage : " + message + "\nStackTrace :" + stacktrace);

    }
}
