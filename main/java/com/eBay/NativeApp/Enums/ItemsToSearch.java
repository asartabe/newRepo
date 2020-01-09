package com.eBay.NativeApp.Enums;

import com.ebay.testinfrastructure.params.TestParams;

public class ItemsToSearch {

	public static enum KeyWord{
		IPHONE("iPhone"),
		CAMERA("cameras"),
		SHIRTS("shirts"),
		MERCHPROMO("test keyword4"),
		DCS_KEYWORD("m0bil3h3ad!");

		private String s = new String();
		KeyWord(String val){
			s = val;
		}

		public String getKeyWord(){
			return s;
		}

	}

	public enum Categories {

		DIGITAL_CAMERAS("Cameras>Digital Cameras", "Cameras & Photo>Digital Cameras"),
		MOBILE_PHONES("Phones & Accessories>Mobile Phones", "Cell Phones & Accessories>Cell Phones & Smartphones"),
		MOBILEACC_BATTERIES("Phones & Accessories>Mobile Phones>Batteries", "Cell Phones & Accessories>Cell Phone Accessories>Batteries"),
		TEST_ATTRIBUTE1("Lots More...>Test Auctions>Attributes>Attributes1", "Everything Else>Test Auctions>Attributes>Attributes1");

		private String au_Value = new String();
		private String sea_Value = new String();
		Categories(String au_Val, String sea_Val){
			au_Value = au_Val;
			sea_Value = sea_Val;
		}

		public String getCategoryTree(){
			return (TestParams.CommonTestEnv.site.get().equalsIgnoreCase("AU") ? au_Value : sea_Value);
		}
	}

	public static enum Member{
		AU_BOPIS_SUPERCHEAPAUTO("supercheapauto"),
		AU_BOPIS_OFFICEWORKS("officeworks"),
		AU_BOPIS_THEGOODGUYSAU("thegoodguysaustralia"),
		AU_PUDO_SURFSTITCH("surfstitch"),
		AU_PUDO_FUTUONLINE("futu_online"),
		AU_SELLER("shallothead"),
		AU_TESTAUBASIC("testaubasic"),
		AU_BINGLEE("binglee"),
		SG_SELLER("meyou_my"),
		MY_SELLER("meyou_my"),
		PH_SELLER("bespoke_fashions_uk");

		private String s = new String();
		Member(String val){
			s = val;
		}

		public String getMemberName(){
			return s;
		}

	}

	public static enum SME{
		PROMO_ITEM1("PROMO_ITEM1"),
		PROMO_ITEM2("PROMO_ITEM2"),
		PROMO_ITEM3("PROMO_ITEM3");

		private String s = new String();
		SME(String val){
			s = val;
		}

		public String getValue(){
			return s;
		}

	}

}
