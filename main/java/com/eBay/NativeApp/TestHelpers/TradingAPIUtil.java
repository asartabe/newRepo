package com.eBay.NativeApp.TestHelpers;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.eBay.NativeApp.Commons.URLs;
import com.eBay.NativeApp.CustomUtils.TimeAndDateUtils;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.AddItemResponseType;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BestOfferType;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.EndItemResponseType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.GetBestOffersResponseType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.PlaceOfferResponseType;
import com.ebay.soap.eBLBaseComponents.RespondToBestOfferResponseType;
import com.ebay.testinfrastructure.common_utils.FileUtil;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIDriver;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIException;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIRequest;
import com.ebay.testinfrastructure.serviceautil.apidriver.APIResponse;
import com.ebay.testinfrastructure.serviceautil.rest.MediaType;
import com.ebay.testinfrastructure.serviceautil.rest.Response;
import com.ebay.testinfrastructure.serviceautil.rest.RestfulClient;
import com.ebay.testinfrastructure.serviceautil.testdriver.ServiceBaseTest;
import com.ebay.testinfrastructure.testdrivers.enums.Site;
import com.google.common.collect.ImmutableMap;

public class TradingAPIUtil extends ServiceBaseTest{

	private static CountryCodeType country = CountryCodeType.AU;
	
	private static Response createRequest(Map<String, String> headers, String xmlInput){
		
		return new RestfulClient.Builder().enableConsoleLogging(true).build()
	    .request()                          
	      .headers(headers)                 
	      .payload(xmlInput)                
	      .contentType(MediaType.XML)       
	      .accept(MediaType.XML)            
	      .build()                          
	    .post(URLs.getEndPoint());
		
	}
	
	private static Map<String, String> getHeaders(String callName) {
		
		Map<String, String> headerValues = new HashMap<String, String>();
		if(TestParams.get("pooltype").equalsIgnoreCase("prod")){
			headerValues.put("X-EBAY-API-DEV-NAME", "pebaysj");
			headerValues.put("X-EBAY-API-CERT-NAME", "pebaysj0001p");
			headerValues.put("X-EBAY-API-APP-NAME", "ebaysjinternal");
		}else{
			headerValues.put("X-EBAY-API-DEV-NAME", "Admintest1");
			headerValues.put("X-EBAY-API-CERT-NAME", "AdminCertificate");
			headerValues.put("X-EBAY-API-APP-NAME", "AdminApp");
		}
		
		Map<String, String> headers = new ImmutableMap.Builder<String, String>()
				.put("X-EBAY-API-COMPATIBILITY-LEVEL", "1019")
				.put("X-EBAY-API-SITEID", Integer.toString(Site.valueOf(country.name().toUpperCase()).getId()))	//TestParams.get("site").toUpperCase()	
				.put("X-EBAY-API-DETAIL-LEVEL", "0")
				.put("X-EBAY-API-CALL-NAME", callName)
				.put("X-EBAY-API-RESPONSE-ENCODING", "XML")
				.putAll(headerValues)
				.build();

		return headers;
	}

	public static class ProdItemActions{
		
		static ItemType item = new ItemType();
		static String sellerName = new String();
		static String sellerPassword = new String();
		static Map<String, String> headers;

		private static AddItemResponseType addResp;

		public static class ProdAddItem{

			public ProdAddItem(){
				ProdItemActions.headers = getHeaders("AddItem");
			}

			public ProdAddItem(AddItemResponseType addResp){
				ProdItemActions.addResp = addResp;
				headers = getHeaders("AddItem");
			}

			public ProdAddItem(ItemType item, String sellerName, String sellerPassword){
				ProdItemActions.item = item;
				ProdItemActions.sellerName = sellerName;
				ProdItemActions.sellerPassword = sellerPassword;
				country = item.getCountry();
				headers = getHeaders("AddItem");
			}

			public AddItemResponseType listItem() throws APIException{

				item.setTitle(item.getTitle()+System.currentTimeMillis());
				item.setConditionID(1000);
				item.setPostalCode("2000");
				item.setPayPalEmailAddress("ebayaubondi+webnext@paypal.com");
				
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("item", item);
				param.put("userName", sellerName);
				param.put("userPassword", sellerPassword);
				if(TimeAndDateUtils.customDate.length() > 0)
					param.put("calDate", TimeAndDateUtils.customDate);

				String xmlInput = FileUtil.getFileContent(ProdAddItem.class, "PROD_AddItem.vsl", param);
				AddItemResponseType addResp = createRequest(headers, xmlInput).asPojo(AddItemResponseType.class);
				
				if(!addResp.getAck().equals(AckCodeType.FAILURE))
					item.setItemID(addResp.getItemID());
				else Assert.fail(addResp.getErrors().toString());
				
				return addResp;
			}

			public ItemType getItem(){
				return item;
			}

			public Double getInsertionFees(){
				
				FeesType fees =  addResp.getFees();
				for (int i = 0; i < fees.getFeeLength(); i++) {
					if(fees.getFee(i).getName().equalsIgnoreCase("InsertionFee"))
						return fees.getFee(i).getFee().getValue();
				}
				
				return 0.00;
			}

			public Double getPromoDiscountIfAny(){

				Double promoFee = 0.00;
				try{
					FeesType fees =  addResp.getFees();
					for (int i = 0; i < fees.getFeeLength(); i++) {
						if(fees.getFee(i).getName().equalsIgnoreCase("InsertionFee"))
							promoFee = fees.getFee(i).getPromotionalDiscount().getValue();
					}
				}catch(NullPointerException npe){}

				return promoFee;
			}
		}

		public static class EndItemAction{

			public EndItemAction(ItemType item, String sellerName, String sellerPassword){
				ProdItemActions.item = item;
				ProdItemActions.sellerName = sellerName;
				ProdItemActions.sellerPassword = sellerPassword;
				ProdItemActions.headers = getHeaders("EndItem");
			}
			
			public boolean endItem(EndReasonCodeType endReason) throws APIException{
				
				boolean flag = false;
				
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("item", item);
				param.put("userName", sellerName);
				param.put("userPassword", sellerPassword);
				param.put("endReason", endReason);
				
				String xmlInput = FileUtil.getFileContent(EndItemAction.class, "PROD_EndItem.vsl", param);
				
				EndItemResponseType endedItem = createRequest(headers, xmlInput).asPojo(EndItemResponseType.class);
				
				if(endedItem.getAck().equals(AckCodeType.FAILURE))
					Assert.fail(endedItem.getErrors().toString());
				else flag = true;
				
				return flag;
			}
		}

	}
	
	public static class PurchaseAPI{

		ItemType item = new ItemType();
		String buyerName = new String();
		String buyerPassword = new String();
		static Map<String, String> headers;
		Double bidAmt = 0.00;
		
		PlaceOfferResponseType placeOffer;

		public PurchaseAPI(ItemType item, String buyerName, String buyerPassword){
			this.item = item;
			this.buyerName = buyerName;
			this.buyerPassword = buyerPassword;
			headers = getHeaders("PlaceOffer");
		}
		
		public PurchaseAPI(ItemType item, String buyerName, String buyerPassword, Double bidPrice){
			this.item = item;
			this.buyerName = buyerName;
			this.buyerPassword = buyerPassword;
			this.bidAmt = bidPrice;
			headers = getHeaders("PlaceOffer");
		}
		
		public boolean placePurchase(BidActionCodeType action) throws APIException{

			boolean flag = false;
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("item", item);
			param.put("userName", buyerName);
			param.put("userPassword", buyerPassword);
			param.put("action", action);

			if(action.equals(BidActionCodeType.OFFER)){
				AmountType amt = new AmountType();
				amt.setValue(item.getStartPrice().getValue()-2.00);
				item.setStartPrice(amt);
			}else if(bidAmt > 0.00)
			{
				AmountType amt = new AmountType();
				amt.setValue(bidAmt);
				item.setStartPrice(amt);
			}
			
			String xmlInput = FileUtil.getFileContent(PurchaseAPI.class, "PROD_PlaceOffer.vsl", param);

			PlaceOfferResponseType placeOffer = createRequest(headers, xmlInput).asPojo(PlaceOfferResponseType.class);
			
			if(placeOffer.getAck().equals(AckCodeType.FAILURE))
				Assert.fail(placeOffer.getErrors().toString());
			else flag = true;
			
			return flag;
		}

	}

	public static class GetItemTransactions{

		ItemType item = new ItemType();
		String sellerName = new String();
		String sellerPassword = new String();
		Map<String, String> headers;

		APIResponse response;
		
		static String FVF_Value = new String();
		
		public GetItemTransactions(ItemType item, String sellerName, String sellerPassword){
			this.item = item;
			this.sellerName = sellerName;
			this.sellerPassword = sellerPassword;
			headers = getHeaders("GetItemTransactions");
		}

		int counter = 0;
		public GetItemTransactions callGetItemTransactions() throws APIException{
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("item", item);
			param.put("userName", sellerName);
			param.put("userPassword", sellerPassword);

			String xmlInput = FileUtil.getFileContent(GetItemTransactions.class, "PROD_GetItemTransactions.vsl", param);
			
			APIRequest request = new APIRequest(URLs.getEndPoint(), headers, xmlInput);
			APIDriver driver = new APIDriver();
			response = driver.execute(request);
			
			String ack = (response.getResponseBody().toString().split("<Ack>")[1]).split("</Ack>")[0];
			System.out.println(ack);
			if(!ack.equalsIgnoreCase("success"))
				Assert.fail(response.getResponseBody());
			
			if(response.getResponseBody().toString().contains("FinalValueFee"))
				FVF_Value = ((response.getResponseBody().toString().split("<FinalValueFee")[1]).split("</FinalValueFee>")[0]).split(">")[1]; 
			else if(counter<3){
				counter++;
				callGetItemTransactions();
			}
			else Assert.fail("Response did not contain FVF details: "+response.getResponseBody());
			
			return this;
		}

		public String getFinalValueFee(){
			return FVF_Value;
		}

	}

	public static class ReviewOffers{
		
		ItemType item = new ItemType();
		String sellerName = new String();
		String sellerPassword = new String();
		static Map<String, String> headers;
		
		public ReviewOffers(ItemType item, String sellerName, String sellerPassword){
			this.item = item;
			this.sellerName = sellerName;
			this.sellerPassword = sellerPassword;
			headers = getHeaders("RespondToBestOffer");
		}
		
		private String getOfferID(){
			
			headers = getHeaders("GetBestOffers");
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("item", item);
			param.put("userName", sellerName);
			param.put("userPassword", sellerPassword);
			
			String xmlInput = FileUtil.getFileContent(ReviewOffers.class, "PROD_GetBestOffers.vsl", param);
			
			GetBestOffersResponseType getOffers = createRequest(headers, xmlInput).asPojo(GetBestOffersResponseType.class);
			
			BestOfferType[] bestOffers = getOffers.getBestOfferArray().getBestOffer(); 
			return bestOffers[0].getBestOfferID();
		}
		
		public boolean actOnOffer(BidActionCodeType action){
			
			String offerID = this.getOfferID();
			
			headers = getHeaders("RespondToBestOffer");
			boolean flag = false;
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("item", item);
			param.put("userName", sellerName);
			param.put("userPassword", sellerPassword);
			param.put("offerID", offerID);
			/*param.put("siteID", Site.valueOf(TestParams.get("site")).getId());*/
			param.put("action", action.value());
			
			String xmlInput = FileUtil.getFileContent(ReviewOffers.class, "PROD_RespondToBestOffers.vsl", param);
			
			RespondToBestOfferResponseType boResponse = createRequest(headers, xmlInput).asPojo(RespondToBestOfferResponseType.class);
			
			if(!boResponse.getAck().equals(AckCodeType.FAILURE))
				flag = true;
			else{
				Assert.fail(boResponse.getErrors().toString());
			}
			
			return flag;
		}
		
	}
	
}
