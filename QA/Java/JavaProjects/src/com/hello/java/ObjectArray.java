package com.hello.java;

public class ObjectArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object object_array[] = new Object[6];
		object_array[0] = "Rohan";
		object_array[1] = 22;
		object_array[2] = 3.30;
		object_array[3] = 'm';
		object_array[4] = "Rohan";
		object_array[5] = 22;
		
		int i;
		  
		for (i=0;i<6;i++)
		{
			System.out.println(object_array[i]);
		}
		
	}

}
