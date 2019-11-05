package com.healthPro.pages;

import org.openqa.selenium.By;

public class ClientsLoginPage {
//or
	public static By newPassword=By.id("newPassword");
	public static By confirmNewPassword=By.id("confirmNewPassword");
	public static By agreeTC=By.xpath("//span[@class='checkbox--label']");
	public static By setPasswordbtn=By.xpath("//button[@data-set-password]");
	public static By panelHeaderTitle=By.xpath("//h2[@class='popup--header_title require_password--header_title']");
}
