package com.healthPro.pages;

import org.openqa.selenium.By;

public class ClientsPage {
	
	//OR	Menu
	//Suitability
	public static By suitabilityOptions=By.xpath("(//span[contains(text(),'Suitability')])[1]");
	public static By saveChangesbtn=By.xpath("//button[contains(@class,'m-red')]");
	
	public static By clientsMenu=By.xpath("(//span[contains(text(),'Clients')])[1]");
	public static By myProfileMenu=By.xpath("//span[contains(text(),'My Profile')]");
	
	
	//My Clients
	public static By myClientsOptions=By.xpath("(//span[contains(text(),'My Clients')])[1]");
	public static By basicInfoOptions=By.xpath("//span[contains(text(),'Basic Info')]");
	public static By homeVisitLocationsOptions=By.xpath("//span[contains(text(),'Home Visit Locations')]");
	public static By creditCardsOptions=By.xpath("//span[contains(text(),'Credit Cards')]");
		
	//Invite Clients
	public static By inviteClientbtn=By.xpath("//button[@data-profiles-import]");
	
	//Fill In Form
	public static By fillInFormbtn=By.xpath("//button[@data-type-fill]");
	
	//upload And SendMail
	public static By uploadNSendMailbtn=By.xpath("//button[@data-upload]");
	
	public static By viewReportsbtn=By.xpath("//button[@class='professional_clients_import--stat_cta' and text()='View Reports']");

	public static By donebtn=By.xpath("//button[@class='btn m-large m-green']");
	//Upload & Send Emails



	
	//li[text()='test@harry.com']
	
	
	
	
	
	

}
