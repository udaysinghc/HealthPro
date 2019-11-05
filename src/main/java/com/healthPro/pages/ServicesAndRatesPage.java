package com.healthPro.pages;

import org.openqa.selenium.By;

public class ServicesAndRatesPage {
	
	//OR	Menu
	public static By services_RatesMenu=By.xpath("(//span[contains(text(),'Services & Rates')])[1]");
	
	//Availability
	public static By availabilityOptions=By.xpath("(//span[contains(text(),'Availability')])[1]");
	
	// Location button
	public static By addLocationbtn=By.xpath("//button[contains(@class,'btn')]");
	
	public static By newIntervalbtn=By.xpath("//button[text()='New Interval']");
	
	//Save location btn	
	public static By saveLocationbtn=By.xpath("//button[contains(@class,'m-light_blue')]");
	
	//Sessions
	public static By sessionsOptions=By.xpath("(//span[contains(text(),'Sessions')])[1]");
	public static By addSessionsbtn=By.xpath("//button[contains(@class,'btn')]");
	public static By divPanelHeaderText=By.xpath("//div[@class='professional_setup--content_title']");
	
	//Contact Info & Meeting Details
	public static By meetingDetailsTxt=By.name("note");
	
	//Add new Session Rate
	public static By addNewSessionRate=By.xpath("//button[@class='professional_setup--sub_footer--add']");
	public static By saveServicebtn=By.xpath("//button[contains(@class,'m-light_blue')]");
	
	public static By dailogMessage=By.xpath("//div[@class='vex-dialog-message']");
	public static By dailogBoxOkbtn=By.xpath("//button[contains(@class,'vex-dialog-button-primary')]");
	
	//Classes
	public static By ClassesOptions=By.xpath("(//span[contains(text(),'Classes')])[1]");
	public static By addNewClassbtn=By.xpath("//button[contains(@class,'btn')]");
	public static By saveClassbtn=By.xpath("//button[contains(@class,'m-light_blue') and contains(text(),'Save Class')]");
	public static By singleDateFromCalenedar=By.name("single_date");
	
	//Packages
	public static By PackagesOptions=By.xpath("(//span[contains(text(),'Packages')])[2]");
	public static By addNewPackagesbtn=By.xpath("(//button[contains(@class,'btn')])[1]");
	public static By savePackagesbtn=By.xpath("//button[contains(@class,'m-light_blue') and contains(text(),'Save Package')]");
	public static By packagesTotalPrice=By.name("price");
	public static By no_Of_Session=By.name("number_of_entities");	

}
