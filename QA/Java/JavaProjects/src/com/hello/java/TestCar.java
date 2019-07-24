package com.hello.java;

public class TestCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BMW bmw = new BMW();
		bmw.start();				//method overriding, same method present in parent and child class
		bmw.stop();
		bmw.ABS();
		bmw.AntiTheft();
		
		System.out.println("*******");
		
		//dynamic polymorphism
		
		Inheritance in = new BMW();
		//only overridden and parent method can be called
		in.start();
		in.stop();
	}

}
