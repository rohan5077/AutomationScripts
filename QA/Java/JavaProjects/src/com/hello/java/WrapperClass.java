package com.hello.java;

public class WrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String x = "100";
		System.out.println(x+20);
		
		
		int i = Integer.parseInt(x);
		System.out.println(i+20);
		
		double d = Double.parseDouble(x);
		System.out.println(d+20);
		
		//String to char conversion
		
		String s = "true";
		boolean b = Boolean.parseBoolean(s);
		System.out.println(b);
		
		//Integer to String
		
		int j = 20;
		System.out.println(j+20);
		String h = String.valueOf(j);
		System.out.println(h+20);
		
	}

}
