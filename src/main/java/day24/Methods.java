package day24;

import org.springframework.stereotype.Component;

@Component
public class Methods {
	public void print() {
		System.out.println("print()");
	}
	public int add(int a, int b) {
		System.out.println("add()");
		return a + b;
	}
	public int divide (int a, int b) {
		System.out.println("divide()");
		return a / b;
	}
}