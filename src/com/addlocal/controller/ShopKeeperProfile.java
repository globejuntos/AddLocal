package com.addlocal.controller;

import java.io.*;
import java.util.*;

public class ShopKeeperProfile implements Serializable {
	int ID;
	String name;
	String email;
	String password;
	String shopname;
	
	
	static HashSet<ShopKeeper> shopkeepers = new HashSet<ShopKeeper>();
	static HashSet<String> emailset = new HashSet<String>();	
	
	{
		try{
			
			File f = new File("D:/KAUSHIK_SRINIVAS/OfficialData/WORKSPACES/JAVA_MARS/GlobeTrotter/src/com/globetrotter/adlocal/model/Objects.txt");
			if(f.length()!=0){
				FileInputStream fis = new FileInputStream (f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				ShopKeeperProfile.shopkeepers = (HashSet<ShopKeeper>)ois.readObject();
				Iterator<ShopKeeper> it = ShopKeeperProfile.shopkeepers.iterator();
				while (it.hasNext()){
					ShopKeeperProfile.emailset.add(it.next().getEmail());
				}
				ois.close();
			}
			
			
		}
		catch(Exception e){
			System.out.println("caught in ShopKeeperProfile static block");
			e.printStackTrace();
		}		
	}
	
	ShopKeeperProfile(int ID,String name, String email, String password, String shopname){
		System.out.println(name);
		try{
		if (ShopKeeperProfile.emailset.add(email)){
			System.out.println("Done Added");
			System.out.println("Email is unique");
			this.ID = ID;
			this.name = name;
			this.email = email;
			this.password = password;
			this.shopname = shopname;			
		}
		else{
			System.out.println("ERROR: email id is not unique");
			//this.ID = (Integer)null;
			this.name = null;
			this.email = null;
			this.password = null;
			this.shopname = null;
		}
		}
		catch(Exception e){
			System.out.println("Caught in ShopKeeperProfile constructor class");

		}
	}
	
	
	
}
