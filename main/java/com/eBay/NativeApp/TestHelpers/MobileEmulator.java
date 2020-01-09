package com.eBay.NativeApp.TestHelpers;

import com.ebay.testinfrastructure.params.TestParams;

public class MobileEmulator {

	private static String EMULATOR = null;
	public static void setEmulator()
	{
		EMULATOR = TestParams.UITestEnv.capability.get();
	}

	public static boolean isANDROID()
	{
		return EMULATOR.contains("ANDROID");
	}

	public static boolean isIPHONE()
	{
		return EMULATOR.startsWith("IPHONE");
	}
}
