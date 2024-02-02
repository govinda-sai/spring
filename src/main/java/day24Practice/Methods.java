package day24Practice;

import org.springframework.stereotype.Component;

@Component
public class Methods {
	public void print() {
		System.out.println("print()");
	}
	public int add (int a, int b) {
		System.out.println("add method()");
		return a + b;
	}
	public int multiply (int a, int b) {
		System.out.println("multiply method()");
		return a * b;
	}
}