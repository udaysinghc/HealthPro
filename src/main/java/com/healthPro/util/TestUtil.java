package com.healthPro.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthPro.base.SetupClass;

public class TestUtil extends SetupClass{
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 120;
	
	/*
	 * 
	 * // This function will handle WebDriverWait for presenceOfElementLocated
	 * 
	 */
	
	public static WebElement presenceOfElementWait(By locator) {
		webelement = (new WebDriverWait(driver, 180)).until(ExpectedConditions.presenceOfElementLocated(locator));
		return webelement;
	}

	/*
	 * 
	 * // This function will handle WebDriverWait for elementToBeClickable
	 * 
	 */
	
	public static WebElement elementToBeClickableWait(By locator) {
		webelement = (new WebDriverWait(driver, 120)).until(ExpectedConditions.elementToBeClickable(locator));
		return webelement;
	}
	
	/*
	 * 
	 * // This function will used for upload file
	 * 
	 */
	
	 public static void uploadFile(String path) throws InterruptedException, AWTException 
    {
 	 //Store the location of the file in clipboard 
		Thread.sleep(1500);
		 StringSelection strSel = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
		
		//Create an object for robot class
		Robot robot = new Robot();
		
		//Control key in the keyboard
		//Ctrl+V 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
    }
	
	//location of file
    public static String avatarFile=System.getProperty("user.dir")+"\\Resources\\avatar.jpg";
    
   

}
