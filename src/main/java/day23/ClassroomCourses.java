package day23;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ClassroomCourses implements Courses {
	public ClassroomCourses () {
		System.out.println("Classroom Courses() ");
		System.out.println();
	}
	
	@Override
	public List<String> getCoursesList() {
		return List.of("Network Administration and Security",
			    "Database Management and SQL",
			    "IT Project Management");
	}

	@Override
	public List<String> getTrainersList() {
		return List.of("Scott", "West", "Drake");
	}
	
}	