package com.testng.test;

import org.testng.annotations.Test;

public class TestNgFeatures {

	@Test
	public void loginTest()
	{
		System.out.println("Login Test");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homepageTest()
	{
		System.out.println("Homepage Test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void menuTest()
	{
		System.out.println("Menu Test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void registerPageTest()
	{
		System.out.println("Registration Test");
	}
}
