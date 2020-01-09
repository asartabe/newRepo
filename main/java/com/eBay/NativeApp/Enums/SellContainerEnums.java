package com.eBay.NativeApp.Enums;

public class SellContainerEnums {

	public static enum SellContainer {
		ACTIVE,
		SOLD,
		UNSOLD;
	}
	
	public static enum SellContainerFilters {
		ALL(""),
		ACTIVE_AUCTIONS("Auctions"),
		ACTIVE_FIXEDPRICE("Fixed price"),
		ACTIVE_NEWOFFERS("Have new offers"),
		SOLD_AWAITINGPAYMENT("Awaiting payment"),
		SOLD_PAID_SENDNOW("Paid - send now");
		
		String s = new String();
		SellContainerFilters(String val){
			s= val;
		}
		
		public String getValue(){
			return s;
		}
	}
	
}
