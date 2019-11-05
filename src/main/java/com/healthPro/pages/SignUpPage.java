package com.healthPro.pages;

import org.openqa.selenium.By;

import com.healthPro.base.SetupClass;

public class SignUpPage extends SetupClass{
	
	
	
	//OR	
	public static By singIN = By.xpath("(//a[contains(text(),'Sign Up / Log In')])[1]");
	public static By login_popup = By.xpath("//div[text()='Log Into Your HealthPRO Account']");
	public static By signup_proff = By.xpath("//a[@class='auth--footer-item btn m-light_blue m-large auth--footer-signup-links-professional']");
    public static By Pricing_active_verify = By.xpath("(//li[@class=' m-current']/descendant::a[contains(text(),'Pricing')])[1]");
    public static By healthpro_buy_div = By.xpath("//div[@class='pricing_box m-red m-healthpro animated fadeInUp']");
    public static By buynow_health = By.xpath("(//button[@class='btn_round m-red_mute'])");
    public static By buynow_HealthProPlus = By.xpath("(//button[@class='btn_round m-blue_mute'])[1]");
    public static By membership_popup = By.xpath("(//h3[@class='membership--title'])[1]");
    
    
    // Sign Up with Email
    public static By first_name = By.xpath("(//input[@id='sign_name_popup'])[2]");
    public static By last_name = By.xpath("(//input[@id='sign_last_popup'])[2]");
    public static By email = By.xpath("(//input[@id='sign_email_popup'])[2]");
    public static By password = By.xpath("(//input[@id='sign_pass_popup'])[2]");
    public static By card_number =By.id("card_number");
    public static By card_name =By.id("card_name");
    public static By card_Holder =By.id("card_holder");
    public static By card_exp =By.id("card_exp");
    public static By card_cvv =By.id("card_cvv");
    public static By I_agree =By.xpath("(//span[@class='checkbox--i'])[2]");
    public static By complete_order = By.xpath("//button[@class='btn m-green m-large m-wide membership--selected_submit']");
    
    //Welcome to the HealthPRO Sign-Up Wizard
    public static By welcomeText_SignUpWizard =By.xpath("//h1[@class='thank_you--cover_title']");
    public static By btnGet_Started=By.xpath("//a[@class='thank_you--content_btn btn m-red']");
    
    //Set Your Primary Location
    public static By txtPrimary_Location=By.xpath("//h2[contains(text(),'Set Your Primary Location')]");
    public static By txt_accept_clients=By.xpath("//h2[contains(text(),'Where do you accept clients?')]");
    public static By my_Office_Options =By.xpath("//h3[contains(text(),'My Office/Studio')]");
    public static By locationName=By.name("name");
    public static By locationAddress=By.name("address_line");
    public static By btn_NextStep=By.xpath("//button[contains(text(),'Next Step')]");
    
    //Your Expertise
    public static By classForclients=By.xpath("//span[contains(@class,'m-classes')]");
    public static By searchServices=By.xpath("//input[@class='ui-autocomplete-input']");
    public static By SelectServices=By.xpath("//select[@name='service_type_id']");
    public static By title=By.name("title");
    public static By sessionDuration =By.name("duration");
    public static By newSessionDuration =By.xpath("(//select[@name='duration'])[2]");
    public static By sessionDiscounts=By.name("pretax_price");
    public static By newSessionDiscounts=By.xpath("(//input[@name='pretax_price'])[2]");
    public static By calendarFrom=By.name("from");
    
    //Your Story
    public static By phoneNumber=By.name("number");
    public static By verifySMSbtn=By.xpath("//button[@data-method='sms']");
    public static By otpInputField=By.name("verification_code");
    public static By verify_OTP_button=By.xpath("//button[@class='professional_setup_wizard--verify--code_btn btn m-red']");
    
    //Email Confirmation
    public static By click_HereForConfirmationMail=By.xpath("(//a[contains(text(),'Click Here')])[1]");
    public static By btn_OK=By.xpath("//button[contains(text(),'OK')]");
    
    //Welcome to your dashboard!    
    public static By txt_DashboardWelcomeMessage=By.xpath("//h2[@class='dashboard_welcome--title']");
    public static By btn_Dashboard_Get_Started=By.xpath("//button[contains(text(),'Get Started')]");
    
    
    
    
    
    
    
    
    
}
