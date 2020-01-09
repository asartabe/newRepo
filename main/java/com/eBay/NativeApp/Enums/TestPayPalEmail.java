package com.eBay.NativeApp.Enums;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.eBay.NativeApp.Commons.ResourceFiles;

public enum TestPayPalEmail {

	PAYPAL_ADDRESS1(ReadProperties.readFile().getProperty("PAYPAL1_EMAIL"), ReadProperties.readFile().getProperty("PAYPAL1_PSWD"));
	
	private String uname = new String(), pwd = new String();
	TestPayPalEmail(String u, String p){
		uname = u;
		pwd = p;
	}
	
	public String getEmailAddress(){
		return uname;
	}
	
	public String getPassword(){
		return pwd;
	}
}

class ReadProperties{
	
	public static Properties readFile(){
		Properties prop = new Properties();
		try{
			/*char c = File.separatorChar;*/
			String path = ResourceFiles.PAYPAL_CREDENTIAL_PROP.getPath();
					/*System.getProperty("user.dir")+c+"src"+c+"test"+c+"resources"+c+"PropFiles"+c+"TestPaypalAddress.properties";*/
			File file = new File(path);
			prop.load(new FileInputStream(file));
		}catch(Exception e){}
		return prop;
	}
	
}