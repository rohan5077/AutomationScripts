package com.hello.java;

public class FunctionMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FunctionMethod obj = new FunctionMethod();
		obj.test();
		int l = obj.add();
		System.out.println(l);
		
	}
	
	public void test()
	{
		System.out.println("Test Method");
	}
	
	public int add()
	{
		int a =10;
		int b=20;
		int c =a+b;
		 
		return c;
	}

}
