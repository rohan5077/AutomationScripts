package com.testng.test;

import org.testng.annotations.Test;

public class InvocationCountTest {

	@Test(invocationCount=10)
	public void sum()
	{
		int a = 10;
		int b = 30;
		int c = a+b;
		System.out.println("Sum is: "+c);
	}
}
