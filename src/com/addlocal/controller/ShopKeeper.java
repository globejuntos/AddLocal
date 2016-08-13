package com.addlocal.controller;

import java.io.Serializable;

public class ShopKeeper implements Serializable{
	
	ShopKeeperProfile profile;
	static int ID = 0;
	
	ShopKeeper(String name, String email, String password, String shopname){
		ShopKeeper.ID = ShopKeeper.ID + 1;
		System.out.println(ID+name);
		
		this.profile = new ShopKeeperProfile(ShopKeeper.ID,name,email,password,shopname);
	}
	
	public String getEmail(){
		return this.profile.email;
	}
	
	public boolean validate(){
		if(this.profile.email == null){
			return false;
		}
		else {
			return true;
		}
	}
	
}
