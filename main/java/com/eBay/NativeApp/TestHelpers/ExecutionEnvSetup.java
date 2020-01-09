package com.eBay.NativeApp.TestHelpers;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.eBay.NativeApp.BreezeTestParams.TestNGPara;
import com.eBay.NativeApp.CustomUtils.CustomWaitUtils;
import com.ebay.testinfrastructure.params.TestParams;
import com.ebay.testinfrastructure.reporter_generator.ReportLogger;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ExecutionEnvSetup{

	ReportLogger reporter = new ReportLogger();
	private static boolean serverState = false;
	static AppiumDriverLocalService appiumSrvc;
	static Field streamField;
	static Field streamsField;
	
	@SuppressWarnings("unchecked")
	@BeforeSuite(alwaysRun=true)
	public void startAppium(ITestContext testContext) throws Exception
	{
		reporter.logInConsoleAndReport("Starting Appium Server");
		try{
			String[] command = { "/usr/bin/killall", "-KILL", "node" };
			try {
				Runtime.getRuntime().exec(command);
			} catch (Exception exc) {
				reporter.logInConsoleAndReport("ERROR!! Failed to Stop Appium Server... : " + exc.getMessage());
			}
			appiumSrvc = 
					/*AppiumDriverLocalService.buildDefaultService();*/ 
					new AppiumServiceBuilder()
					.usingPort(4723)
					.withIPAddress("0.0.0.0")
					.build();
			appiumSrvc.start();
			if(appiumSrvc.isRunning()){
				serverState = true;
				reporter.logInConsoleAndReport("Appium Server started... Listening on: "+appiumSrvc.getUrl());
			}
			
			if(TestParams.get(testContext, "appiumServerLogsInConsole").equalsIgnoreCase("false")){
				/*CODE TO SKIP APPIUM SERVER LOGS IN CONSOLE*/
				/*================================FROM HERE======================================*/
				try {
					streamField = AppiumDriverLocalService.class.getDeclaredField("stream");
					streamField.setAccessible(true);
					streamsField = Class.forName("io.appium.java_client.service.local.ListOutputStream")
							.getDeclaredField("streams");
					streamsField.setAccessible(true);
				} catch (ClassNotFoundException | NoSuchFieldException e) {
					e.printStackTrace();
				}
				try{
					((ArrayList<OutputStream>) streamsField.get(streamField.get(appiumSrvc))).clear();
				}catch(IllegalAccessException e){
					e.printStackTrace();
				}
				/*================================TILL HERE======================================*/
			}
		}catch(Exception ex){
			ex.printStackTrace();
			int trials = 0;
			do
			{
				CommandLine command = new CommandLine(TestParams.get("appiumNodePath"));
				command.addArgument(TestParams.get("appiumJSPath"),false);
				command.addArgument("--address", false);
				command.addArgument("0.0.0.0");
				command.addArgument("--port", false);
				command.addArgument("4723");
				command.addArgument("--local-timezone", true);
				command.addArgument("--full-reset", false);
				if(TestParams.UITestEnv.uxtype.get().contentEquals("IPHONE")){
					command.addArgument("--native-instruments-lib", true);
				}
				DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
				DefaultExecutor executor = new DefaultExecutor();
				executor.setExitValue(1);
				try {
					executor.execute(command, resultHandler);
					Thread.sleep(5000);
					reporter.logInConsoleAndReport("Appium server started.");
					serverState = true;
				} catch(Exception e){
					reporter.logInConsoleAndReport("Error Starting Appium Server... : " + e.getMessage());
				}
				trials++;
			}while (!serverState && trials < 3);

			if(trials > 1){
				Exception e = new Exception("Failed to Start Appium Server!!!");
				throw e;
			}
		}
		new TestNGPara(testContext);
	}

	@AfterSuite(alwaysRun=true)
	public void stopAppium() throws Exception
	{
		if(serverState){
			reporter.logInConsoleAndReport("Stopping Appium Server");
			try{
				if(appiumSrvc.isRunning()){
					appiumSrvc.stop();
					serverState = false;
				}
			}catch(Exception e){
				if(serverState){
					String[] command = { "/usr/bin/killall", "-KILL", "node" };
					try {
						Runtime.getRuntime().exec(command);
						System.out.println("Appium server stopped.");
					} catch (Exception ex) {
						reporter.logInConsoleAndReport("ERROR!! Failed to Stop Appium Server... : " + e.getMessage());
					}
				}
			}
		}
		CustomWaitUtils.waitForSeconds(10);
		serverState = false;
	}

	/*Start emulator for Android. For iOS Simulator, it triggers on it's own.*/
	@BeforeTest(alwaysRun=true)
	public void startSimulator(ITestContext context) throws Exception
	{
		if(!TestParams.GridEnv.autopickgrid.from(context).isON()){
			if(!TestParams.UITestEnv.realdevice.isTrue())
			{
				System.out.println("Start Android emulator");
				MobileEmulator.setEmulator();
				VirtualDeviceController.startGenymotionAndroidEmulator(TestParams.get("emulatorName"));
			}
			else if(TestParams.UITestEnv.capability.get().contains("IPHONE"))
				MobileEmulator.setEmulator(); 
			else
				System.out.println("Running test on physical device. No emulator started");
		}
	}

	@AfterTest(alwaysRun=true)
	public void stopSimulator(ITestContext context) throws Exception
	{
		if(!TestParams.GridEnv.autopickgrid.from(context).isON()){
			if(!TestParams.UITestEnv.realdevice.isTrue())
			{
				System.out.println("Stopping Android emulator");
				VirtualDeviceController.stopGenymotionAndroidEmulator();
			}
		}
	}


}
