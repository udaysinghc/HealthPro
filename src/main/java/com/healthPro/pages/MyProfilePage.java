package com.healthPro.pages;

import org.openqa.selenium.By;

import com.healthPro.base.SetupClass;

public class MyProfilePage extends SetupClass{
	
	
	
	//OR	
	public static By photoAndMediaMenu=By.xpath("//span[contains(text(),'Photos & Media')]");
	
	//Photo
	public static By uploadPhotobtn=By.xpath("//span[@class='edit_media--add_photo']");
	
	//SocailMedia
	
	public static By link=By.name("social_pages[link]");
	public static By twitter=By.name("social_pages[twitter]");
	public static By facebook=By.name("social_pages[facebook]");
	public static By linkedin=By.name("social_pages[linkedin]");
	public static By pinterest=By.name("social_pages[pinterest]");
	public static By instagram=By.name("social_pages[instagram]");
	public static By youtube=By.name("social_pages[youtube]");
	public static By ideafit=By.name("social_pages[ideafit]");
	public static By amazon=By.name("social_pages[amazon]");
	
	//Update btn
	
	public static By updatebtn=By.xpath("//button[contains(text(),'Update')]");
	
	public static By dialogMessage=By.xpath("//div[@class='vex-dialog-message']");
	public static By okbtn=By.xpath("//button[contains(text(),'OK')]");
	
	//Edit photo
	public static By editPhoto=By.xpath("//button[contains(text(),'Edit Title')]");	
	public static By txtEditPhoto=By.xpath("//textarea[@class='edit_media--item_text_input']");	
	public static By saveTitleBtn=By.xpath("//button[contains(text(),'save title')]");
	
	//Edit Video
	public static By addVideobtn=By.xpath("//button[contains(@class,'js-edit_videos--show_form')]");
	public static By addUrl=By.name("url");
	public static By addVideoTitle=By.name("title");
	public static By submitVideobtn=By.xpath("//button[contains(@class,'edit_media--submit_button')]");
	public static By editVideo=By.xpath("(//button[contains(text(),'Edit Title')])[2]");	
	public static By txtEditVideo=By.xpath("(//textarea[@class='edit_media--item_text_input'])[2]");	
	public static By saveVideoTitleBtn=By.xpath("(//button[contains(text(),'save title')])[2]");
	

}
