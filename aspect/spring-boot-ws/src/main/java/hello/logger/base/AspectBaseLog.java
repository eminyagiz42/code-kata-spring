package hello.logger.base;

import org.aspectj.lang.JoinPoint;

public interface AspectBaseLog {
    void afterReturningLogging(JoinPoint joinPoint, Object retVal);
    void afterThrowingLoging(JoinPoint joinPoint, Exception exec);
}
