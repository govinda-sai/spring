package practiceAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {
	public AspectDemo() {
		System.out.println("LogAspect()");
	}
	
	@Before (value = "execution (* practiceAOP.Order.*(..))")
	public void beforeAdviceMethod(JoinPoint jp) {
		System.out.println("Before Log Advice --> " + jp.getSignature());
	}
	
	@After (value = "execution (* practiceAOP.Order.*(..))") 
	public void afterAdviceMethod(JoinPoint jp) {
		System.out.println("After Log Advice --> " + jp.getSignature());
	}
}