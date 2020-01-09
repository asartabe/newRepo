package com.eBay.NativeApp.Flows;

import com.eBay.NativeApp.Commons.ProdUserData;
import com.eBay.NativeApp.Pages.HomeScreen;
import com.eBay.NativeApp.Pages.SignInScreen;
import com.ebay.quality.testdataautil.type.User;
import com.ebay.testinfrastructure.webautil.uitestsdriver.UIListener;

public class LoginFlows {

	public static void signIn(User user){
		new SignInScreen(UIListener.uiDriver.get()).getSignInComponent().signIn(user.getUserID(), user.getPassword());
	}
	
	public static void signIn(ProdUserData prodUser){
		new SignInScreen(UIListener.uiDriver.get()).getSignInComponent().signIn(prodUser.getUserName(), prodUser.getPassword());
	}
	
	public static void signInFromHomeScreen(ProdUserData prodUser){
		new HomeScreen(UIListener.uiDriver.get()).getHomeScreenContentComponent().clickSignIn();
		new SignInScreen(UIListener.uiDriver.get()).getSignInComponent().chooseUsernameAndPasswordOption();
		signIn(prodUser);
		//new SignInScreen(UIListener.uiDriver.get()).getSignInComponent().skipLinkingAccounts();
		
	}
	
	public static void signIn(String username, String password){
		new SignInScreen(UIListener.uiDriver.get()).getSignInComponent().signIn(username, password);
	}
	
	
}
