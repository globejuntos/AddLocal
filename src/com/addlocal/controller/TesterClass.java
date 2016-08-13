package com.addlocal.controller;

public class TesterClass {
	public static void main(String args[]){
		try{
			UserOperations u1 = new UserOperations("kaushik", "kaushik20491@gmail.com", "wolves", "tea shop");
			Thread t1 = new Thread(u1);
			UserOperations u2 = new UserOperations("kumar", "kuma@gmail.com", "tigers", "pan shop");
			Thread t2 = new Thread(u2);
			
			t1.setName("kaushik thread");
			t2.setName("harsha thread");
			
			t1.start();
			t2.start();

		}catch(Exception e){
			System.out.println("caught in main");
		}
		
	}
}
