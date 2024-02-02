package day23;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@Primary
public class OnlineCourses implements Courses {
	public OnlineCourses() {
		System.out.println("Online Courses() ");
	}
	
	@Override
	public List<String> getCoursesList() {
		return List.of( "Web Development Fundamentals",
			    "Data Analysis and Visualization",
			    "Cybersecurity Fundamentals");
	}

	@Override
	public List<String> getTrainersList() {
		return List.of("Kanye", "Travis", "Abel");
	}
}