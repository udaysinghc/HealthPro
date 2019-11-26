package com.healthPro.pages;

import org.openqa.selenium.By;

public class BasicInfoPage {
	public static By aboutMe=By.cssSelector(".personal_details--data_inner>dl:nth-child(4)>dd>div>textarea");
	public static By professionalStatement =By.name("about_what_i_do");
	public static By languageSearch =By.xpath("//input[@type='search']");
	public static By userMenu=By.xpath("//span[@class='user_menu--opener_text']");
	public static By logoutOptions=By.xpath("//a[contains(@class,'user_menu--logout')]");

}
