package com.eBay.NativeApp.Commons;

import com.ebay.testinfrastructure.l10nautil.URLBuilder;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.testdrivers.enums.Site;

public class URLs {

	private static final String PROD_EP = "https://api.ebay.com/ws/api.dll";
	private static final String STAGE_EP = "http://eazye.qa.ebay.com/ws/api.dll";
	
	public static String getEndPoint(){
		if(TestParams.get("pooltype").equalsIgnoreCase("staging"))
			return STAGE_EP;
		else return PROD_EP;
	}
	
	private static String BASE_URL = "https://www.qa.ebay.com";
	
	public String HOMEPAGE = new URLBuilder.Convert(BASE_URL).pool(TestParams.get("pool"))
				.poolType(TestParams.get("pooltype")).prefixWWW(true).site(Site.valueOf(TestParams.get("site")))
				.complete().get();
	
	public static final String MYEBAY_SUMMARY = "http://k2b-bulk.au.paradise.qa.ebay.com/ws/eBayISAPI.dll?SMSummary&ssPageName=STRK:ME:LNLK";
	
}
