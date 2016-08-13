package com.addlocal.controller;

import java.io.*;
import java.util.*;

public class UserOperations implements Serializable,Runnable {
	static HashSet<ShopKeeper> shopkeepers = new HashSet<ShopKeeper>();
	String name;
	String email;
	String password;
	String shopname;

	{
		try{
			File f = new File("D:/KAUSHIK_SRINIVAS/OfficialData/WORKSPACES/JAVA_MARS/GlobeTrotter/src/com/globetrotter/adlocal/model/Objects.txt");
			if(f.length()!= 0){
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream (fis);
				UserOperations.shopkeepers = (HashSet<ShopKeeper>)ois.readObject();
				ois.close();
				fis.close();
			}

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Caught in UserOperations static try block");
		}
	}
	UserOperations(String name, String email, String password, String shopname){
		this.name = name;
		this.email = email;
		this.password = password;
		this.shopname = shopname;
	}
	public void AddUser(){
		
		ShopKeeper s = new ShopKeeper(this.name, this.email, this.password, this.shopname);
		System.out.println("Done");
		boolean flag = s.validate();
		System.out.println(flag);
		if (flag == true){
			 
			try{
				UserOperations.shopkeepers.add(s);				
				File f = new File("D:/KAUSHIK_SRINIVAS/OfficialData/WORKSPACES/JAVA_MARS/GlobeTrotter/src/com/globetrotter/adlocal/model/Objects.txt");
				if(f.length()!=0){
					System.out.println("length check done");
					FileInputStream fis = new FileInputStream(f);
					ObjectInputStream ois = new ObjectInputStream (fis);
					UserOperations.shopkeepers = (HashSet<ShopKeeper>)ois.readObject();
					//UserOperations.shopkeepers.addAll(ois.readObject());
					Iterator<ShopKeeper> i = UserOperations.shopkeepers.iterator();
					while (i.hasNext()){
						System.out.println("iterator in userOperations"+i.next().getEmail());
					}
					ois.close();
					fis.close();
				}
			}
			catch(Exception e){
				System.out.println("Caught in AddUSer method 1st try block");
			}
			try{
				System.out.println("Inside second try user operations");
				FileOutputStream fos = new FileOutputStream("D:/KAUSHIK_SRINIVAS/OfficialData/WORKSPACES/JAVA_MARS/GlobeTrotter/src/com/globetrotter/adlocal/model/Objects.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(UserOperations.shopkeepers);
				oos.flush();
				oos.close();
				fos.close();
				System.out.println("User Addedd Successfully>"+s.getEmail());
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("exception at add user 2nd try block");
			}
			
		}
	}
	
	public void run(){
		boolean flag = true;
		try{
		synchronized(this){
			while (flag == false){
				this.wait();
			}
			flag = false;
			
			this.AddUser();
			
			flag = true;
			this.notifyAll();
			
		}
	}
		catch(Exception e){
			System.out.println("Exception in run block");
		}
	}
}
