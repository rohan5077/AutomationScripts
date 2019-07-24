package com.testng.test;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {

//	@Test(timeOut=2)				//2 milliseconds
//	public void infiniteLoopTest()
//	{
//		int i = 1;
//		while(i == 1)
//		{
//			System.out.println(i);
//		}
//	}
	
	
	@Test(timeOut=20,expectedExceptions=NumberFormatException.class)
	public void test1()
	{
		String x = "100A";
		Integer.parseInt(x);
	}
}
