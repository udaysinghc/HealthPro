package com.healthPro.pages;

import org.openqa.selenium.By;

import com.healthPro.base.SetupClass;

public class AccountSettingsPage extends SetupClass{
	
	//Or
	//Side barMenu
	
	public static By accountSettingsSideBar=By.xpath("(//span[text()='Account Settings'])[1]");
	public static By paymentGatwayMenu=By.xpath("//span[text()='Payment Gateways']");
	public static By onlineOnlyOptions=By.xpath("//span[text()='Online Only']");
	public static By inPersonNOnlineOptions=By.xpath("//span[text()='In Person & Online']");
	
	
	//panel--header_title
	public static By panelHeaderTitle=By.xpath("//h2[@class='panel--header_title']");
	public static By popupHeaderTitle=By.xpath("//h2[@class='popup--header_title']");
	
	//PayPal
	public static By payPalbtn=By.xpath("//button[@data-method-connect-btn='paypal']");
	public static By payPalHeaderText=By.xpath("//h1[@class='headerText ']");
	public static By payPalEmail=By.id("email");
	public static By payPalNextBtn=By.id("btnNext");
	public static By payPalPassword=By.id("password");
	public static By payPalLoginBtn=By.id("btnLogin");
	public static By PayPalAccountConnected=By.xpath("(//div[@class='receive_payments--label'])[1]");	
	
	//stripe
	public static By stripebtn=By.xpath("//button[@data-method-connect-btn='stripe']");
	public static By stripesignInLink=By.xpath("//a[contains(text(),'Sign in')]");
	public static By stripeEmail=By.id("email");
	public static By stripePassword=By.id("password");
	public static By stripeLoginBtn=By.xpath("//button[@type='submit']");
	public static By stripeHeaderText=By.xpath("//a[text()='Stripe']");
	

}
