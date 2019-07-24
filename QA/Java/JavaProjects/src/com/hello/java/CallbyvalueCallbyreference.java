package com.hello.java;

public class CallbyvalueCallbyreference {
	
	int swap1;
	int swap2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CallbyvalueCallbyreference obj = new CallbyvalueCallbyreference();
		int x = 10;
		int y = 20;
		int sum = obj.testSum(x,y); 		//call by value
		System.out.println(sum);
		
		obj.swap1 = 50;
		obj.swap2 = 40;
		
		obj.swap(obj);
		System.out.println(obj.swap1);
		System.out.println(obj.swap2);
		
	}
	
	//call by value or pass by value
	public int testSum(int a , int b)
	{
		int c = a+b;
		return c;
	}
	
	public void swap(CallbyvalueCallbyreference t)
	{
		int temp = t.swap1;
		t.swap1 = t.swap2;
		t.swap2 = temp;
	}

}
