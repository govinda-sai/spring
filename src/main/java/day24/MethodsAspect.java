package day24;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodsAspect {
	@Around (value = "execution (* day24.Methods.* (..))") //point cut syntax
	public void afterAdviceMethod(ProceedingJoinPoint pjp) {
		Long startTime = System.currentTimeMillis();
		System.out.println("start time: " + startTime + " ms");
		try {
			pjp.proceed();
			Long endTime = System.currentTimeMillis();
			System.out.println("end time : " + endTime + " ms");
			System.out.println("method time: " + (endTime - startTime) + " ms");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}