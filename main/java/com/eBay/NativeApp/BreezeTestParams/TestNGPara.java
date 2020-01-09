package com.eBay.NativeApp.BreezeTestParams;

import org.testng.ITestContext;

import com.ebay.testinfrastructure.params.TestParams;

public class TestNGPara {
	
	private static String site = new String();
	
	public TestNGPara(ITestContext tc){
		site = TestParams.get(tc, "site");
	}
	
	public static String getSite(){
		return site;
	}
	
}
