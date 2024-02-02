package practiceAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvices {
	@AfterReturning (value = "execution (* practiceAOP.Order.* (..))") 
	public void afterReturningMethod (JoinPoint jp) {
		System.out.println("After returning method : " + jp.getSignature());
	}
	
	@AfterThrowing (value = "execution (* practiceAOP.Order.* (..))", throwing = "ex")
	public void afterThrowableMethod (JoinPoint jp, Exception ex) {
		System.out.println("Error : " + ex.getMessage());
	}
}