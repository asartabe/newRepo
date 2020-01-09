package com.eBay.NativeApp.Commons;

import java.io.File;

import com.ebay.testinfrastructure.params.TestParams;

public enum ResourceFiles {
	
	PICTURE(ConvertResourcePath.getPicturePath()),
	
	PICTURE_URL("https://s15.postimg.org/4no75mwnf/Transformer_Open_and_Short_Circuit_Tests.png"),
	//https://placeholdit.imgix.net/~text?txtsize=200&txt=Test_Item&w=1024&h=768
	//https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Test-Logo.svg/2000px-Test-Logo.svg.png
	
	/*BOPIS_FLAG_HEADERS(ConvertResourcePath.getBOPISHeadersPath()),
	
	ITEM_DATA(ConvertResourcePath.getItemDataFilePath()),*/
	
	DUMMY_ITEM_DATA(ConvertResourcePath.getDummyItemDataPath()),
	
	DUMMY_USER_DATA(ConvertResourcePath.getDummyUserDataPath()),
	
	USER_CREDENTIAL_PROP(ConvertResourcePath.getUserCredPropFilePath()),
	
	PAYPAL_CREDENTIAL_PROP(ConvertResourcePath.getPayPalCredPropFilePath()),
	
	/*RATE_TABLE_DATA_PROP(ConvertResourcePath.getRateTablePropFilePath()),
	
	TESTING_ITEM_DATA(ConvertResourcePath.getAdditionalTestDataPath()),*/
	
	PROMOTION_DATA(ConvertResourcePath.getPromotionsItemDataPath()),
	
	PROD_USER_DETAILS(ConvertResourcePath.getProdUserDetailsFilePath()),
	PROD_API_HEADER_DETAILS(ConvertResourcePath.getProdHeadersDetailsFilePath());
	
	private String s = new String();
	ResourceFiles(String path){
		s = path;
	}

	public String getPath(){
		return s;
	}
	
}

class ConvertResourcePath{

	static char sep = File.separatorChar;
	private static String globalPath = System.getProperty("user.dir") +sep+ "src" +sep+ "test" +sep+ "resources" +sep ;	

	public static String getPicturePath(){
		return globalPath + "testing.jpg";
	}

	/*public static String getItemDataFilePath(){
		return globalPath + "ItemData.xls";
	}*/
	
	public static String getDummyItemDataPath(){
		return globalPath +sep+ "dummyData" +sep+ "DummyItem.properties";
	}
	
	public static String getDummyUserDataPath(){
		return globalPath +sep+ "dummyData" +sep+ "DummyUser.properties";
	}
	
	public static String getUserCredPropFilePath(){
		return globalPath +sep+ "credentials" +sep+ "UserCredentials_"+TestParams.get("site").toUpperCase()+".properties";
	}
	
	public static String getPayPalCredPropFilePath(){
		return globalPath +sep+ "PropFiles" +sep+ "TestPaypalAddress.properties";
	}
	
	/*public static String getRateTablePropFilePath(){
		return globalPath + "RateTablePostageValues.properties";
	}
	
	public static String getAdditionalTestDataPath(){
		if(TestParams.CommonTestEnv.pooltype.get().contentEquals("staging"))
			return globalPath + "AdditionalTestDataQA.properties";
		else
			return globalPath + "AdditionalTestDataPROD.properties";
	}*/
	
	public static String getProdUserDetailsFilePath(){
		return globalPath +sep+ "com" +sep+ "eBay" +sep+ "NativeApp" +sep+ "TestClasses" +sep+ "ProdUserDetails.xls";
	}
	
	public static String getProdHeadersDetailsFilePath(){
		return globalPath +sep+ "credentials" +sep+ "ProdHeaders.properties";
	}
	
	/*public static String getBOPISHeadersPath(){
		return globalPath +sep+ "credentials" +sep+ "SetBOPISFlagHeaders.properties";
	}*/
	
	public static String getPromotionsItemDataPath(){
		return globalPath +sep+ "PropFiles" +sep+ "PromotionItems.properties";
	}
		
}
