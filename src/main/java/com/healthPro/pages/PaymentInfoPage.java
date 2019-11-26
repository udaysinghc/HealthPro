package com.healthPro.pages;

import org.openqa.selenium.By;

public class PaymentInfoPage {
	
	public static By paymentInfoSideBar=By.xpath("(//span[text()='Payment Info'])[1]");
	public static By accountPlanMenu=By.xpath("//span[text()='Account Plan']");
	public static By upgradePlan=By.xpath("//button[@data-choose-upgrade]");
	public static By chnageToMonthlyPlanbtn=By.xpath("//button[contains(@class,'m-blue_mute')]");
	public static By changebtn=By.name("upgrade");
	
	public static By nextbtn=By.xpath("//button[contains(text(),'Next')]");
	
	public static By billingName=By.name("bill_to_name");
	public static By billingAddress=By.name("bill_to_address");
	public static By updateBillingBtn=By.xpath("//button[contains(@class,'btn m-blue')]");
	
	public static By okbtn=By.xpath("//button[contains(text(),'Ok')]");
	

}
