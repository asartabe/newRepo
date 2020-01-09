package com.eBay.NativeApp.TestHelpers;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CLICommandExecutor {

	  /**
	   * Executes a CLI command using ProcessBuilder. Should be used to execute any command from command line like:<br>
	   * a. Starting appium server from command line.<br>
	   * b. Killing appium server process.<br>
	   * c. Triggering genymotion Android emulator from command line.<br>
	   * d. Killing a genymotion Android emulator from command line.
	   * @param command
	   * @param processOutputFileName
	   * @throws Exception
	   */
	  public static void executeCommand(String command, String processOutputFileName) throws Exception
	  { 
	    List<String> commands = Arrays.asList(command.split(" "));
	    /*A command like cd /user/avaikar/Desktop will be split into an array and then converted to a list of strings.
	    This list will then be passed to processbuilder. You should not directly pass a string which has all the command words.*/
	    
	    if(commands==null)
	      throw new Exception("No command was found to execute. Please supply a valid command");
	    
	    File processOutputFile = new File(processOutputFileName);
	    ProcessBuilder processBuilder = new ProcessBuilder(commands);
	    processBuilder.redirectOutput(processOutputFile);
	    processBuilder.start();
	    Thread.sleep(5000);
	  }

	  /**
	   * Executes a CLI command using ProcessBuilder without logging the output to a file
	   * @param command
	   * @throws Exception
	   */
	  public static void executeCommand(String command) throws Exception 
	  {
	    
	    List<String> commands = Arrays.asList(command.split(" "));
	    
	    if(commands==null)
	      throw new Exception("No command was found to execute. Please supply a valid command");
	    ProcessBuilder processBuilder = new ProcessBuilder(commands);
	    processBuilder.start();
	    Thread.sleep(5000);
	    
	  }

	  public static void executeCommandUsingRunTime(String command) throws Exception {
	    
	    String[] commands = command.split(" ");
	    Runtime.getRuntime().exec(commands);
	    Thread.sleep(15000);
	    
	  }


}
