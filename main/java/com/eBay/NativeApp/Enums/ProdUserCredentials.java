package com.eBay.NativeApp.Enums;

public enum ProdUserCredentials {
	
	TEST_NONESTORE("getTokenNone"),
	TEST_BASICSTORE("getTokenBasic"),
	TEST_PREMIUMSTORE("getTokenPremium"),
	TEST_ANCHORSTORE("getTokenAnchor"),
	TEST_BUYER1("getTokenBuyer1"),
	TEST_BUYER2("getTokenBuyer2"),;
	
	private String s = new String();
	
	ProdUserCredentials(String name){
		s=name;
	}
	
	public String getValue(){
		return s;
	}
	
}
