package com.eBay.NativeApp.TestHelpers;

import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;

public class VirtualDeviceController {


	private static String genymotionVDStartCommand;
	private static String genymotionVDStopCommand;
	private static String adbKillCommand;

	/**
	 * Starts Genymotion Android VD from command line.<br>
	 * You should pass the exact name of the Virtual Device that is created in Genymotion dashboard.<br>
	 * NOTE: Please create a device with no spaces in the name. Since this method makes use of the Process Builder it splits the command based upon spaces.
	 * @param suiteName
	 * @throws Exception
	 */
	public static void startGenymotionAndroidEmulator(String virtualDeviceName) throws Exception {

		if(System.getProperty("os.name").startsWith("Mac"))
		{
			genymotionVDStartCommand = "/Applications/Genymotion.app/Contents/MacOS/player.app/Contents/MacOS/player --vm-name " + virtualDeviceName;
			CLICommandExecutor.executeCommandUsingRunTime(genymotionVDStartCommand);
			CustomWaitUtils.waitForSeconds(30);
		}
		else if(System.getProperty("os.name").startsWith("Windows"))
		{
		}
	}


	/**
	 * Stops a Genymotion VD
	 * @throws Exception
	 */
	public static void stopGenymotionAndroidEmulator() throws Exception {

		if(System.getProperty("os.name").startsWith("Mac"))
		{
			genymotionVDStopCommand = "killall player";
			adbKillCommand = "killall adb";
			CLICommandExecutor.executeCommand(genymotionVDStopCommand);
			CLICommandExecutor.executeCommand(adbKillCommand);
		}
		else if(System.getProperty("os.name").startsWith("Windows"))
		{
			//
		}

	}


}
