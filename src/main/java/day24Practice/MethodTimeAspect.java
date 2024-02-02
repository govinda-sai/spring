package day24Practice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodTimeAspect {
	long startTime = 0;
	@After("execution(* day24.Methods.*(..))")
    public void afterAdviceMethod(JoinPoint jp) {
        System.out.println("Time taken by the methods: "
        		+ (System.currentTimeMillis() - startTime) + " ms");
    }
}