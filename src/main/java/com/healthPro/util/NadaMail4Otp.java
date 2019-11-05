package com.healthPro.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.healthPro.base.SetupClass;

public class NadaMail4Otp extends SetupClass{
	
	public static void getMail(String mailId) throws InterruptedException 
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.open()");
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	driver.get("https://getnada.com/");
	
	//add index
	webelement=TestUtil.elementToBeClickableWait(By.xpath("//span[contains(text(),'Add Inbox')]"));
	webelement.click();
	
	//add inbox user
	webelement=TestUtil.elementToBeClickableWait(By.xpath("//input[@class='user_name']"));
	webelement.click();
	webelement.clear();
	webelement.sendKeys(mailId);
	
	//click on Accept button
	webelement=TestUtil.elementToBeClickableWait(By.xpath("//a[@class='button success']"));
	webelement.click();
	
	String mail=mailId.toLowerCase();
	//click on added inbox
	webelement=TestUtil.elementToBeClickableWait(By.xpath("//span[contains(text(),'"+mail+"@getnada.com')]"));
	webelement.click();
	
	//get inbox mail
	
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	List<WebElement> listMailOnStart=driver.findElements(By.xpath("//div[@class='waiting']"));
	int totalInboxMailOnStart=listMailOnStart.size();
	System.out.println("Total number of mail :"+totalInboxMailOnStart);
	int maxTryForNewMail=0;
	while(totalInboxMailOnStart>0 && maxTryForNewMail<=6) 
	{
		Thread.sleep(10000);
		System.err.println("Waiting for received mail");
		List<WebElement> listMailOnWait=driver.findElements(By.xpath("//div[@class='waiting']"));
		int totalInboxMailOnWait=listMailOnWait.size();
		System.out.println("Total number of mail totalInboxMailOnWait :"+totalInboxMailOnWait);
		totalInboxMailOnStart=totalInboxMailOnWait;
		System.out.println("Total number of mail totalInboxMailOnStart :"+totalInboxMailOnStart);
		

		maxTryForNewMail++;
	}
	if(maxTryForNewMail>=7) 
	{
	driver.close();
	Thread.sleep(1000);
	driver.switchTo().window(tabs.get(0));
	
	}else {
	
	List<WebElement> list=driver.findElements(By.xpath("//ul[@class='msg_list']//li"));
	int totalInboxMail=list.size();
	System.out.println("Total number of mail :"+totalInboxMail);
	
	int maxTry=0;
	for(int i=1;i<=totalInboxMail;i++) 
	{
		
		webelement=driver.findElement(By.xpath("(//ul[@class='msg_list']//li)["+i+"]"));
		if(webelement.getText().contains("Phone Activation code")) 
		{webelement.click();
		System.out.println("Mail found");
		Thread.sleep(2000);
		driver.switchTo().frame(1);
		
		//for get otp
		webelement=driver.findElement(By.xpath("//p[contains(text(),'Your phone verification code is')]"));
		String otpPasswordWithString=webelement.getText();	
		System.out.println(otpPasswordWithString);
		otpPassword=otpPasswordWithString.replaceAll("Your phone verification code is", "");
		System.out.println("OTP for supplier :" +otpPassword);
		
		//for delete mail
		driver.switchTo().defaultContent();
		webelement=driver.findElement(By.xpath("//i[@class='icon-trash-empty']"));
		webelement.click();
		
		driver.switchTo().window(tabs.get(0));
		break;
		
		}else if(i==list.size() && maxTry<=2) 
		{
			System.out.println("Wait for 30 secounds for get mail in inbox");
			Thread.sleep(30000);
			List<WebElement> list2=driver.findElements(By.xpath("//ul[@class='msg_list']//li"));
			totalInboxMail=list2.size();
			System.out.println("Now Number of mail after 30 secound wait :"+totalInboxMail);
			i=0;
			maxTry++;
		}else if(maxTry==3) 
		{System.out.println("OTP for supplier after MAxTry :" +otpPassword);
			System.out.println("Mail not found");
			driver.switchTo().window(tabs.get(0));
			break;
		}
	}}
	}
	}
