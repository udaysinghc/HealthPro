package stepDefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.SignUpPage;
import com.healthPro.util.NadaMail4Confirmation;
import com.healthPro.util.NadaMail4Otp;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignupStepDefinations extends SetupClass {

	Actions ac=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^Open the application url\\.$")
	public void open_the_application_url() throws Throwable {
		try {
			driver.get(AppURL);
			log.info("It's opening the website URL");
			Thread.sleep(3000);
		} catch (TimeoutException e) {
			Thread.sleep(10000);
			driver.get(AppURL);
			log.info("It's opening the website URL");
			Thread.sleep(5000);
		}
	}

	@And("^Click on 'Sign Up / Log In' Link$")
	public void click_on_Sign_Up_Log_In_Link() throws Throwable {
		webelement = driver.findElement(SignUpPage.singIN);
		webelement.click();
		log.info("it's clicked on  'Sign Up / Log In' Link");
	}

	@Then("^I verify the \"([^\"]*)\" popup$")
	public void i_verify_the_popup(String popup) throws Throwable {

		final String loginpopup = "Log Into Your HealthPRO Account";
		final String health_div = "HealthPro Buy Section";
		final String membership_div = "Membership section";

		switch (popup) {

		case loginpopup:

			webelement = driver.findElement(SignUpPage.login_popup);
			String text = webelement.getText();
			log.info(text);
			String expected = "Log Into Your HealthPRO Account";
			assertEquals(expected, text);
			log.info("it's verify ' Log In' Popup ");
			break;

		case health_div:

			webelement = TestUtil.presenceOfElementWait(SignUpPage.healthpro_buy_div);
			log.info("HealthPro Buy Section is present");
			break;

		case membership_div:
			webelement = TestUtil.presenceOfElementWait(SignUpPage.membership_popup);
			log.info("Membership section is present");
			break;

		}

	}

	@When("^Click on \"([^\"]*)\" Button$")
	public void click_on_Button(String button) throws Throwable {

		final String signup_proff = "Sign Up as a HealthPRO Professional";
		final String buynow_healthpro = "Buy Now as healthPro";
		final String buynow_healthpro_Plus = "Buy Now as healthPro Plus";
		
		switch (button) {

		case signup_proff:

			webelement = driver.findElement(SignUpPage.signup_proff);
			ac.moveToElement(webelement).build().perform();
			String text = webelement.getText();
			log.info(text);
			String expected = "Sign Up as a HealthPRO Professional";
			assertEquals(expected, text);
			log.info("it's verify 'Sign Up as a HealthPRO Professional' button message ");
			webelement.click();
			break;

		case buynow_healthpro:

			webelement = TestUtil.presenceOfElementWait(SignUpPage.buynow_health);
			log.info("HealthPro Buy Section is present");
			ac.moveToElement(webelement).build().perform();
			webelement.click();
			break;

		case buynow_healthpro_Plus:
			webelement = TestUtil.presenceOfElementWait(SignUpPage.buynow_HealthProPlus);
			log.info("HealthPro Plus Buy Section is present");
			ac.moveToElement(webelement).build().perform();
			webelement.click();
			break;
		
		}
	}

	@Then("^I verify the active pricing page$")
	public void i_verify_the_active_pricing_page() throws Throwable {
		webelement = TestUtil.presenceOfElementWait(SignUpPage.Pricing_active_verify);
		System.out.println("Pricing option on Top Bar is Active/Highlighted");

	}
	
	@Then("^Verify Required field Validation message should appears$")
	public void verify_Required_field_Validation_message_should_appears() throws Throwable {
		List<WebElement> list=driver.findElements(By.xpath("//span[contains(text(),'Please enter')]"));
		System.out.println(list.size());
		System.out.println("Testing Required field Validation message");
		
	}
	
	@Given("^Enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enter_as(String locator, String value) throws Throwable {
	   
		final String Fn="first_name";
		final String Ln="last_name";
		final String Em="email";
		final String Pwd="password";
		final String Cnumber="card_number";
		final String CName="card_name";
		final String Cholder="card_holder";
		final String Cexp="card_exp";
		final String Ccvv="card_cvv";
		
		switch (locator){
		
		case Fn:
//			webelement=driver.findElement(By.xpath("(//input[@name='"+locator+"'])[2]"));
			webelement=driver.findElement(SignUpPage.first_name);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		
		case Ln:
			webelement=driver.findElement(SignUpPage.last_name);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		
		case Em:
			Random rand=new Random();
			int x=rand.nextInt(100);
			mailId="Test"+x;
			String mail="Test"+x+"@getnada.com";
			System.out.println("Mail enter for sign up : "+mail);
			webelement=driver.findElement(SignUpPage.email);
		    webelement.sendKeys(mail);
		    System.out.println("it's entered value"+ mail);
		    break;
		
		case Pwd:
			webelement=driver.findElement(SignUpPage.password);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		
		case Cnumber:
			webelement=driver.findElement(SignUpPage.card_number);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		    
		case CName:
			webelement=driver.findElement(SignUpPage.card_name);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		    
		case Cholder:
			webelement=driver.findElement(SignUpPage.card_Holder);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		    
		case Cexp:
			webelement=driver.findElement(SignUpPage.card_exp);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		    
		case Ccvv:
			webelement=driver.findElement(SignUpPage.card_cvv);
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		}
		    
		
	}

	
	@And("^Select I agree to HealthPRO's check box$")
	public void select_I_agree_to_HealthPRO_s_check_box() throws Throwable {
		webelement=driver.findElement(SignUpPage.I_agree);
		if(!webelement.isSelected()) 
		{
			webelement.click();
			System.out.println("it's Selecting I agree to HealthPRO's check box");
			Thread.sleep(1500);
			
		}
		
		
	}
	
	@And("^Click on 'Complete Order' Button$")
	public void click_on_Complete_Order_Button() throws Throwable {
		webelement = driver.findElement(SignUpPage.complete_order);
		webelement.click();
		System.out.println("Clicked on 'Complete Order' Button");
	}
	
	@And("^Verify Welcome Message at Sign-Up Wizard Page$")
	public void verify_Welcome_Message_at_Sign_Up_Wizard_Page() throws Throwable {
		webelement = TestUtil.presenceOfElementWait(SignUpPage.welcomeText_SignUpWizard);
		String welcomMessage=webelement.getText();
		String ExpectedMessage="Thank you for your business!";
		String ExpectedMessage2=ExpectedMessage.toUpperCase();
		assertEquals(ExpectedMessage2,welcomMessage);
		System.out.println("Welcome message matched");
	}

	@Then("^Click on 'Get Started' Button$")
	public void click_on_Get_Started_Button() throws Throwable {
		webelement = driver.findElement(SignUpPage.btnGet_Started);
		webelement.click();
		System.out.println("Clicked on 'Get Started' Button");
	}
	
	@And("^Set your location Form open$")
	public void set_your_location_Form_open() throws Throwable {
		webelement = TestUtil.presenceOfElementWait(SignUpPage.txtPrimary_Location);
		String welcomMessage=webelement.getText();
		String ExpectedMessage="Set Your Primary Location";
		assertEquals(ExpectedMessage,welcomMessage);
		System.out.println("Set Your Primary Location message matched");
	}

	@And("^Verify 'Where do you accept clients\\?' adding location appears$")
	public void verify_Where_do_you_accept_clients_adding_location_appears() throws Throwable {
		webelement = TestUtil.presenceOfElementWait(SignUpPage.txt_accept_clients);
		String welcomMessage=webelement.getText();
		String ExpectedMessage="Where do you accept clients?";
		String ExpectedMessage2=ExpectedMessage.toUpperCase();
		assertEquals(ExpectedMessage2,welcomMessage);
		System.out.println("Where do you accept clients? message matched");
	}
	
	@And("^Click on 'My Office/Studio' options$")
	public void click_on_My_Office_Studio_options() throws Throwable {
		webelement = driver.findElement(SignUpPage.my_Office_Options);
		webelement.click();
		System.out.println("Clicked on 'My Office/Studio' options");
	}
	
	@And("^Enter name of location as \"([^\"]*)\"$")
	public void enter_name_of_location_as(String location) throws Throwable {
		
		Thread.sleep(2000);
		webelement = driver.findElement(SignUpPage.locationName);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(location);
		System.out.println("it's Entered name of location");
	}

	@And("^Enter address as \"([^\"]*)\"$")
	public void enter_address_as(String address_line) throws Throwable {
		webelement = driver.findElement(SignUpPage.locationAddress);
		webelement.click();
		Thread.sleep(500);
		webelement.clear();
		webelement.sendKeys(address_line);
		Thread.sleep(1000);
		webelement.sendKeys(Keys.ARROW_DOWN);
		System.out.println("it's Entered address");
		Thread.sleep(1000);
	}
	
	@And("^Select Day as \"([^\"]*)\"$")
	public void select_Day_as(String day) throws Throwable {
		webelement = driver.findElement(By.xpath("//span[contains(text(),'"+day+"')]"));
		webelement.click();		
		System.out.println("it's clicked on Day"); 
	}

	@Then("^Click on 'Next Step' button$")
	public void click_on_Next_Step_button() throws Throwable {
		webelement = driver.findElement(SignUpPage.btn_NextStep);
		webelement.click();		
		System.out.println("it's clicked on Next Step' button"); 
		Thread.sleep(500);
	}

	@And("^Search & Select your services as \"([^\"]*)\"$")
	public void search_Select_your_services_as(String services) throws Throwable {
		webelement = driver.findElement(SignUpPage.searchServices);
		webelement.sendKeys(services);
		Thread.sleep(500);
		
		webelement = driver.findElement(By.xpath("(//li[@class='ui-menu-item m-parent']//a)[1]"));
		ac.moveToElement(webelement).build().perform();
		webelement.click();
	}

	@And("^Select Session duration as \"([^\"]*)\"$")
	public void select_Session_duration_as(String arg1) throws Throwable {
		webelement = driver.findElement(SignUpPage.sessionDuration);
		ac.moveToElement(webelement).build().perform();
		Thread.sleep(500);
		Select select=new Select(webelement);
		select.selectByValue(arg1);
	}

	@And("^Enter discounts for Session as \"([^\"]*)\"$")
	public void enter_discounts_for_Session_as(String discounts) throws Throwable {
		webelement = driver.findElement(SignUpPage.sessionDiscounts);
		webelement.sendKeys(discounts);
		Thread.sleep(500);
	}
	
	@And("^Select your services as \"([^\"]*)\"$")
	public void select_your_services_as(String arg1) throws Throwable {
		webelement = driver.findElement(SignUpPage.SelectServices);
		webelement.click();
		Thread.sleep(500);
		Select select=new Select(webelement);
		select.selectByVisibleText(arg1);
		Thread.sleep(500);
	}
	
	@And("^Enter Phone Number for Otp verification as \"([^\"]*)\"$")
	public void enter_Phone_Number_for_Otp_verification_as(String number) throws Throwable {
		webelement = driver.findElement(SignUpPage.phoneNumber);
		webelement.sendKeys(number);
		Thread.sleep(500);
	}

	@And("^Click on Verify By SMS button$")
	public void click_on_Verify_By_SMS_button() throws Throwable {
		webelement = driver.findElement(SignUpPage.verifySMSbtn);
		webelement.click();
	}

	@And("^Enter Otp Value$")
	public void enter_Otp_Value() throws Throwable {
		NadaMail4Otp.getMail(mailId);
		System.out.println(otpPassword);
		webelement = driver.findElement(SignUpPage.otpInputField);
		webelement.sendKeys(otpPassword);
		
	}
	
	@And("^Click on Verify OTP button$")
	public void click_on_Verify_OTP_button() throws Throwable {
		webelement = driver.findElement(SignUpPage.verify_OTP_button);
		webelement.click();
		Thread.sleep(1500);
	}
	
	@And("^Click on 'Click Here' if you didn't receive an email link$")
	public void click_on_Click_Here_if_you_didn_t_receive_an_email_link() throws Throwable {
		Thread.sleep(5000);
		webelement=TestUtil.elementToBeClickableWait(SignUpPage.click_HereForConfirmationMail);	
		webelement.click();
		Thread.sleep(1000);
	}
	
	@But("^Email Sent Success 'Alert' prompt open$")
	public void email_Sent_Success_Alert_prompt_open() throws Throwable {

		webelement=TestUtil.elementToBeClickableWait(SignUpPage.btn_OK);	
		webelement.click();
		
	}

	@And("^Wait for Confirmation mail & click on 'Verify my email' button$")
	public void wait_for_Confirmation_mail_click_on_Verify_my_email_button() throws Throwable {
		boolean mailConfirmed=NadaMail4Confirmation.verifyMyEmail();
		assertTrue(mailConfirmed);
		System.out.println("Mail confirmed");
	}

	@Then("^Verify 'Welcome to your dashboard!' prompt appears$")
	public void verify_Welcome_to_your_dashboard_prompt_appears() throws Throwable {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		webelement = TestUtil.presenceOfElementWait(SignUpPage.txt_DashboardWelcomeMessage);
		String resutlObtain=webelement.getText();
		String expectedResults="Welcome to your dashboard!";
		assertEquals(expectedResults,resutlObtain);
		System.out.println("welcome--title message matched");
	}
	
	@And("^Click on 'Get Started' button$")
	public void click_on_Get_Started_button() throws Throwable {
		webelement = TestUtil.presenceOfElementWait(SignUpPage.btn_Dashboard_Get_Started);
		webelement.click();
	}
	
	@And("^Select 'classes' options that can yours clients book$")
	public void select_classes_options_that_can_yours_clients_book() throws Throwable {
		Thread.sleep(4000);
		webelement = TestUtil.presenceOfElementWait(SignUpPage.classForclients);
		webelement.click();
		Thread.sleep(1000);
	}
	
	@And("^Enter \"([^\"]*)\" of your \"([^\"]*)\"$")
	public void enter_of_your(String arg1, String arg2) throws Throwable {
		webelement = driver.findElement(SignUpPage.title);
		webelement.sendKeys(arg2);
	}

	@And("^Select 'today's' date from calendar$")
	public void select_today_s_date_from_calendar() throws Throwable {
		webelement = driver.findElement(SignUpPage.calendarFrom);
		webelement.click();
		Thread.sleep(1000);
		webelement = driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[1]"));
		webelement.click();
	}
	
	@And("^Click on 'Next & Not Now' button on Demo$")
	public void click_on_Next_Not_Now_button_on_Demo() throws Throwable {
		webelement = driver.findElement(By.xpath("(//a[@class='shepherd-button '])[1]"));
		ac.moveToElement(webelement).build().perform();
		webelement.click();
		Thread.sleep(500);
		
		webelement = driver.findElement(By.xpath("(//a[@class='shepherd-button '])[2]"));
		ac.moveToElement(webelement).build().perform();
		webelement.click();
		Thread.sleep(500);
		
		webelement = driver.findElement(By.xpath("(//a[@class='shepherd-button '])[3]"));
		ac.moveToElement(webelement).build().perform();
		webelement.click();
		Thread.sleep(500);
		
		webelement = driver.findElement(By.xpath("(//a[@class='shepherd-button m-link'])[4]"));
		ac.moveToElement(webelement).build().perform();
		webelement.click();
		Thread.sleep(500);
	}

}
