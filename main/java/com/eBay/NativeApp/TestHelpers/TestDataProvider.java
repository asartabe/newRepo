package com.eBay.NativeApp.TestHelpers;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.eBay.NativeApp.Commons.ProdUserData;
import com.eBay.NativeApp.Commons.ResourceFiles;
import com.eBay.NativeApp.Enums.ItemsToSearch;
import com.eBay.NativeApp.Enums.ProdUserCredentials;
import com.ebay.quality.testdataautil.api.ItemHelper;
import com.ebay.quality.testdataautil.api.ItemHelper.ItemTemplateType;
import com.ebay.quality.testdataautil.common.EasyFilter;
import com.ebay.quality.testdataautil.common.SpreadSheetUtil;
import com.ebay.quality.testdataautil.type.TestObject;
import com.ebay.quality.testdataautil.type.User;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ReturnPolicyType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;

public class TestDataProvider {

	/*=========================================================================================================================
	 **************************************************DATA PROVIDERS**********************************************************
	=========================================================================================================================*/
	
	@DataProvider(name="getRegUserData")
	public static Iterator<Object[]> getRegUserData(Method m, ITestContext tc) throws Exception 
	{
		String methodName = m.getName();
		EasyFilter filter = EasyFilter.equalsIgnoreCase(TestObject.TEST_METHOD, methodName);
		filter = EasyFilter.and(filter, 
				EasyFilter.equalsIgnoreCase(TestObject.TEST_SITE, TestParams.CommonTestEnv.site.from(tc).get()));

		LinkedHashMap<String, Class<?>> entityClazzMap = new LinkedHashMap<String, Class<?>>();
		entityClazzMap.put("TestObject", TestObject.class);
		entityClazzMap.put("User", User.class);

		return SpreadSheetUtil.getEntitiesFromSpreadsheet(m.getDeclaringClass(), entityClazzMap, "TestData.xls", 3, null, filter);
	}
	
	@DataProvider(name="getProdItem")
	public static Iterator<Object[]> getProdItem(Method m, ITestContext tc) throws Exception 
	{
		String methodName = m.getName();
		EasyFilter filter = EasyFilter.equalsIgnoreCase(TestObject.TEST_METHOD, methodName);
		filter = EasyFilter.and(filter, 
				EasyFilter.equalsIgnoreCase(TestObject.TEST_SITE, TestParams.CommonTestEnv.site.from(tc).get()));

		LinkedHashMap<String, Class<?>> entityClazzMap = new LinkedHashMap<String, Class<?>>();
		entityClazzMap.put("TestObject", TestObject.class);
		entityClazzMap.put("Item", ItemType.class);

		return SpreadSheetUtil.getEntitiesFromSpreadsheet(m.getDeclaringClass(), entityClazzMap, "TestData.xls", 1, null, filter);
	}
	
	@DataProvider(name="getSellItem")
	public static Iterator<Object[]> getSellItemData(Method m, ITestContext tc) throws Exception 
	{
		String methodName = m.getName();
		EasyFilter filter = EasyFilter.equalsIgnoreCase(TestObject.TEST_METHOD, methodName);
		filter = EasyFilter.and(filter, 
				EasyFilter.equalsIgnoreCase(TestObject.TEST_SITE, TestParams.CommonTestEnv.site.from(tc).get()));

		LinkedHashMap<String, Class<?>> entityClazzMap = new LinkedHashMap<String, Class<?>>();
		entityClazzMap.put("TestObject", TestObject.class);
		entityClazzMap.put("Item", ItemType.class);

		return SpreadSheetUtil.getEntitiesFromSpreadsheet(m.getDeclaringClass(), entityClazzMap, "TestData.xls", 2, null, filter);
	}
	
	@DataProvider(name="srchData")
	public static Iterator<Object[]> getCnCSearchData(){
		List<String> srchData = new ArrayList<String>();
		srchData.add(ItemsToSearch.Member.AU_BOPIS_OFFICEWORKS.getMemberName());
		srchData.add(ItemsToSearch.Member.AU_PUDO_FUTUONLINE.getMemberName());
		
		Collection<Object[]> data = new ArrayList<Object[]>();
		srchData.forEach(item -> data.add(new Object[]{item}));
		return data.iterator();
	}
	
	/*=========================================================================================================================
	=========================================================================================================================*/
	
	public static HashMap<String, String> getResourceData(ResourceFiles file){

		HashMap<String, String> testMap = new HashMap<String, String>();
		try{
			Properties properties = new Properties();
			properties.load(new FileInputStream(file.getPath()));

			Set<Object> keys = properties.keySet();
			Iterator<Object> iterateKeys = keys.iterator();

			while(iterateKeys.hasNext()){
				String key = iterateKeys.next().toString();
				testMap.put(key, properties.getProperty(key));
			}
		}catch(Exception ex){
			new ReportLogger().logRedStep(ex.getMessage());
		}

		return testMap;
	}

	public static User getDummyUserData(){

		User user = new User();
		HashMap<String, String> testItem = getResourceData(ResourceFiles.DUMMY_USER_DATA);
		user.setUserFullName(testItem.get("User.userFirstName") + " " + testItem.get("User.userLastName"));
		user.setFirstName(user.getUserFullName());
		user.setLastName(user.getUserFullName());
		user.setAddress(testItem.get("User.address"));
		user.setAddress2(testItem.get("User.address2"));
		user.setBaseEmail(testItem.get("User.baseEmail"));
		user.setPassword(testItem.get("User.password"));

		if(TestParams.get("site").equalsIgnoreCase("AU")){
			user.setCity(testItem.get("User.cityAU"));
			user.setState(testItem.get("User.stateAU"));
			user.setDayPhone1(testItem.get("User.dayPhone1"));
			user.setDayPhone(testItem.get("User.dayPhone2"));
			user.setZip(testItem.get("User.zipAU"));
		}
		else if(TestParams.get("site").equalsIgnoreCase("SG") || TestParams.get("site").equalsIgnoreCase("MY")
				|| TestParams.get("site").equalsIgnoreCase("PH")){
			user.setCity(testItem.get("User.city" + TestParams.get("site").toUpperCase()));
			user.setState(testItem.get("User.state" + TestParams.get("site").toUpperCase()));
			user.setZip(testItem.get("User.zip" + TestParams.get("site").toUpperCase()));
			user.setDayPhone(testItem.get("User.dayPhone" + TestParams.get("site").toUpperCase()));
		}
		
		return user;
	}

	public static ProdUserData getProductionUser(ProdUserCredentials userCredential) throws Exception{

		EasyFilter filter = EasyFilter.equalsIgnoreCase(TestObject.TEST_METHOD, userCredential.getValue());
		filter = EasyFilter.and(filter,EasyFilter.equalsIgnoreCase(TestObject.TEST_SITE,
				TestParams.CommonTestEnv.site.get().toUpperCase()));

		LinkedHashMap<String, Class<?>> entityClazzMap = new LinkedHashMap<String, Class<?>>();

		entityClazzMap.put("TestObject", TestObject.class);
		entityClazzMap.put("ProdUserData", ProdUserData.class);

		Iterator<Object[]> iteObjects = SpreadSheetUtil.getEntitiesFromSpreadsheet(null, entityClazzMap, ResourceFiles.PROD_USER_DETAILS.getPath(), 0, null, filter);

		ProdUserData prodUser = (ProdUserData) iteObjects.next()[1];
		return prodUser;
	}

	public static ItemType getItemTypeObject(ItemTemplateType template){
		ItemType item = new ItemType();
		try{
			item = ItemHelper.getItemTemplate(template);
			
			item.setListingDuration("Days_7");
			
			ReturnPolicyType retPolicy = new ReturnPolicyType();
			retPolicy.setRefundOption("MoneyBack");
			retPolicy.setReturnsAcceptedOption("ReturnsAccepted");
			retPolicy.setReturnsWithinOption("Days_30");
			item.setReturnPolicy(retPolicy);
			
			ShippingDetailsType shipDetails = item.getShippingDetails();
			ShippingServiceOptionsType shipOptions = shipDetails.getShippingServiceOptions(0);
			shipOptions.setShippingServicePriority(1);
			item.setShippingDetails(shipDetails);
			
		}catch(Exception ex){
			new ReportLogger().logRedStep("Failed to provide ItemType object for specified Template Type: "+template.name());
		}
		return item;
	}
	
	/**
	 * Lists an Item on Production (default uses - TESTAUANCHOR Seller)
	 */
	/*public static ItemType getProductionItem(ItemType item) throws Exception{

		ProdUserData prodUser = TestDataProvider.getProductionUser(ProdUserCredentials.TEST_ANCHORSTORE);

		item.setTitle("APPTEST_ITEM_DONT_BUY_"+System.currentTimeMillis());

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("item", item);
		param.put("prodUser", prodUser);

		String xmlInput = FileUtil.getFileContent(TestDataProvider.class, "PROD_AddItem.vsl", param);

		Map<String, String> headers = new HashMap<String, String>();
//		headers.putAll(TestDataProvider.getResourceData(ResourceFiles.PROD_API_HEADER_DETAILS));
		headers.put("X-EBAY-API-COMPATIBILITY-LEVEL", TestParams.get("APICompatibilityLevel").substring(1));
		headers.put("X-EBAY-API-SITEID", Integer.toString(Site.valueOf(TestParams.get("site").toUpperCase()).getId()));
		headers.put("X-EBAY-API-CALL-NAME", "AddItem");
		headers.put("X-EBAY-API-DETAIL-LEVEL", "0");
		headers.put("X-EBAY-API-DEV-NAME", "pebaysj");
		headers.put("X-EBAY-API-CERT-NAME", "pebaysj0001p");
		headers.put("X-EBAY-API-APP-NAME", "ebaysjinternal");
		headers.put("X-EBAY-API-RESPONSE-ENCODING", "XML");

		APIRequest request = new APIRequest("https://api.ebay.com/ws/api.dll", headers, xmlInput);
		APIDriver driver = new APIDriver();
		APIResponse response = driver.execute(request);

		if(!response.getResponseBody().contains("Failure") || !response.getResponseBody().contains("failure")){
			item.setItemID((response.getResponseBody().split("<ItemID>")[1]).split("</ItemID>")[0]);
		}
		else
			Assert.fail("Failed to List Item...!");

		return item;

	}*/

}
