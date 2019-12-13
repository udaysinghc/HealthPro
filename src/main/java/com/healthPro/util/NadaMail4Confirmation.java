package com.healthPro.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthPro.base.SetupClass;

public class NadaMail4Confirmation extends SetupClass {
	public static boolean verifyMyEmail() throws InterruptedException  
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
		Thread.sleep(500);
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
		
		
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			
			Thread.sleep(1500);
			
			List<WebElement> list=driver.findElements(By.xpath("//ul[@class='msg_list']//li"));
			int totalInboxMail=list.size();
			System.out.println("Total number of mail :"+totalInboxMail);
			
			int maxTry=0;
			for(int i=1;i<=totalInboxMail;i++) 
			{				
				webelement=driver.findElement(By.xpath("(//ul[@class='msg_list']//li)["+i+"]"));
				if(webelement.getText().contains("Confirm Your Email to Get Started with HealthPRO")) 
				{webelement.click();
				System.out.println("Mail found");
				Thread.sleep(2000);
				driver.switchTo().frame(1);
				webelement=(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Verify my email')]")));
				webelement.click();
				break;		
				}else if(i==list.size() && maxTry<=150) 
				{
					System.out.println("Wait for 02 secounds for get mail in inbox");
					Thread.sleep(2000);
					List<WebElement> list2=driver.findElements(By.xpath("//ul[@class='msg_list']//li"));
					totalInboxMail=list2.size();
					i=1;
					maxTry++;
				}else if(maxTry==151) 
				{
					System.out.println("Mail not found");
					break;
				}
			}
			return true;
	}
}
