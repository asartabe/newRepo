package com.eBay.NativeApp.Commons;

public class SearchRefinementType {

	public static enum View{
		LIST,
		GRID;
	}
	
	public static enum BuyingFormat{
		BUYITNOW("//android.widget.CheckedTextView[@text='Buy It Now']"),
		AUCTION("//android.widget.CheckedTextView[@text='Auction']"),	// or @text='auction'
		BESTOFFER("//android.widget.CheckedTextView[@text='Best Offer']");
		
		private String s = new String();
		BuyingFormat(String val){
			s = val;
		}
		
		public String getLocator(){
			return s;
		}
	}
	
	public static enum Sort{
		BESTMATCH("//*[@text='Best Match']"),
		LOW_PRICE_POSTAGE("//*[@text='Lowest price + postage' or @text='Priced lowest']"),
		HIGH_PRICE_POSTAGE("//*[@text='Highest price + postage' or @text='Priced highest']"),
		ENDING_SOON("//*[@text='Ending soonest']"),
		NEWLY_LISTED("//*[@text='Newly listed' or  @text='Newest listings']"),
		NEAREST_FIRST("//*[@text='Nearest first']"),
		RECENTLY_ADDED("//*[@text='Recently added']");
		
		private String s = new String();
		Sort(String val){
			s = val;
		}
		public String getLocator(){
			return s;
		}
	}
	
	public static enum Condition{
		NEW("//android.widget.CheckedTextView[@text='New']"),
		USED("//android.widget.CheckedTextView[@text='Used']"),
		NOT_SPECIFIED("//android.widget.CheckedTextView[@text='Not specified']");
		
		private String s = new String();
		Condition(String val){
			s = val;
		}
		
		public String getLocator(){
			return s;
		}
	}
	
	public static enum DeliveryOptions{
		FREE_POSTAGE("//android.widget.Switch[contains(@text,'Free postage')]"),
		CLICK_AND_COLLECT("//android.widget.Switch[contains(@text,'Click & Collect')]"),
		LOCAL_PICKUP("//android.widget.Switch[contains(@text,'Local pickup')]");
		
		private String s = new String();
		DeliveryOptions(String val){
			s = val;
		}
		
		public String getLocator(){
			return s;
		}
	}
	
	public static enum ItemLocation{
		AUSTRALIA_ONLY("//android.widget.CheckedTextView[contains(@text,'Only')]"),
		WORLDWIDE("//android.widget.CheckedTextView[contains(@text,'Worldwide')]");
		
		private String s = new String();
		ItemLocation(String val){
			s = val;
		}
		
		public String getLocator(){
			return s;
		}
	}
	
	public static enum GlobalFilterSwitches{
		COMLPETED_ITEMS("//android.widget.Switch[contains(@text, 'Completed items')]"),
		SOLD_ITEMS("//android.widget.Switch[contains(@text, 'Sold items')]"),
		DEALS_SAVINGS("//android.widget.Switch[contains(@text, 'Deals & savings')]"),
		SRCH_DESCRIPTION("//android.widget.Switch[contains(@text, 'Search in description')]");
		
		private String s = new String();
		GlobalFilterSwitches(String val){
			s = val;
		}
		
		public String getLocator(){
			return s;
		}
	}
	
	public static enum eGD{
		NO_PREFRENCES("//android.widget.CheckedTextView[contains(@text, 'No Preference')]"),
		ONE_DAY_SHIPPING("//android.widget.CheckedTextView[contains(@text, '1 day shipping')]"),
		TWO_DAY_SHIPPING("//android.widget.CheckedTextView[contains(@text, '2 day shipping')]"),
		THREE_DAY_SHIPPING("//android.widget.CheckedTextView[contains(@text, '3 day shipping')]");
		
		private String s = new String();
		eGD(String val){
			s = val;
		}
		
		public String getLocator(){
			return s;
		}
	}
}
