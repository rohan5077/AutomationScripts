package com.hello.java;

public class StaticNonStatic {
	
	static int age = 25;
	String name = "Java";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaticNonStatic obj = new StaticNonStatic();
		sum();
		StaticNonStatic.sum();
		obj.test();
		System.out.println(age);
		System.out.println(obj.name);
		
	}
	
	public void test()
	{
		System.out.println("Test Method");
	}
	
	public static void sum()
	{
		System.out.println("Sum Method");
	}

}
