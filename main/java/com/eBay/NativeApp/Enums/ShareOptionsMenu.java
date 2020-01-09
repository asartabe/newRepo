package com.eBay.NativeApp.Enums;

public enum ShareOptionsMenu {
	
	FACEBOOK("Facebook"),
	TWITTER("Tweet"),
	PINTEREST("Create a Pin"),
	BLUETOOTH("Bluetooth"),
	GMAIL("Gmail"),
	MESSAGING("Messaging");
	
	private String val = new String();
	ShareOptionsMenu(String s){
		val = s;
	}
	
	public String getValue(){
		return val;
	}
}
