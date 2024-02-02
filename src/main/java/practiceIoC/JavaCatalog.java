package practiceIoC;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* default scope of the  bean is "singleton" which means 
 * if there are 2 components and one of the components is 
 * annotated with @Primary and if we try to DI 
 * then, both of the object references 
 * point at the @Primary component with same hashCode()
 * we have to make it "prototype" */

//@Component
//@Primary
@Scope (scopeName = "prototype")
//@Lazy // Java componenet won't be created
public class JavaCatalog implements Catalog {

	public JavaCatalog() {
		System.out.println("JavaCatalog no args contructor");
	}

	@Override
	public List<String> getBooks() {
		return List.of("Java Persistence with Hibernate", "Java with Spring");
	}
}