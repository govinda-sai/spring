package day23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class PrintCourses implements CommandLineRunner {
	@Autowired (required = false)
	@Qualifier (value = "onlineCourses")
	Courses courses;

	public PrintCourses(Courses courses) {
		this.courses = courses;
	}

	public void run(String... args) {
		if (courses != null) {
			for (var c : courses.getCoursesList()) {
				System.out.println(c);
			}
			
			for (var t : courses.getTrainersList()) {
				System.out.println(t);
			}
		} else {
			System.out.println("Object is null");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(PrintCourses.class, args);
	}
}