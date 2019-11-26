package stepDefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.SignUpPage;
import com.healthPro.util.NadaMail4Confirmation;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;

public class CreateProSignUpAccount extends SetupClass{
	Actions ac=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@And("^Sign up 'Client PRO' with \"([^\"]*)\" user on Heathpro plus$")
	public void sign_up_Client_PRO_with_user_on_Heathpro_plus(String arg1) throws Throwable {
	    
		
		
		//Clicked on 'Sign Up / Log In' Link 
		webelement = driver.findElement(SignUpPage.singIN);
		webelement.click();
		log.info("it's clicked on  'Sign Up / Log In' Link");
		
		//I verify the "Log Into Your HealthPRO Account" popup
		
		webelement = driver.findElement(SignUpPage.login_popup);
		String text = webelement.getText();
		log.info(text);
		String expected = "Log Into Your HealthPRO Account";
		assertEquals(expected, text);
		log.info("it's verify ' Log In' Popup ");
		
		//Clicked on "Sign Up as a HealthPRO Professional" Button
		
		webelement = driver.findElement(SignUpPage.signup_proff);
		ac.moveToElement(webelement).build().perform();
		String HealthPROtext = webelement.getText();
		log.info(text);
		String expectedHealthPRO = "Sign Up as a HealthPRO Professional";
		assertEquals(expectedHealthPRO, HealthPROtext);
		log.info("it's verify 'Sign Up as a HealthPRO Professional' button message ");
		webelement.click();
		
		// I verify the active pricing page
		webelement = TestUtil.presenceOfElementWait(SignUpPage.Pricing_active_verify);
		log.info("Pricing option on Top Bar is Active/Highlighted");
		
		//I verify the "HealthPro Buy Section" popup 
		
		webelement = TestUtil.presenceOfElementWait(SignUpPage.healthpro_buy_div);
		log.info("HealthPro Buy Section is present");
		
		//Click on "Buy Now as healthPro Plus" Button
		webelement = TestUtil.presenceOfElementWait(SignUpPage.buynow_HealthProPlus);
		log.info("HealthPro Plus Buy Section is present");
		ac.moveToElement(webelement).build().perform();
		webelement.click();
		
		//I verify the "Membership section" popup
		webelement = TestUtil.presenceOfElementWait(SignUpPage.membership_popup);
		log.info("Membership section is present");
		
		//Enter "first_name" as "<First Name>"
		
		webelement=driver.findElement(SignUpPage.first_name);
	    webelement.sendKeys("Pro");
	    log.info("it's entered value :Pro ");
	    
	    // Enter "last_name" as "<Last Name>"
	    webelement=driver.findElement(SignUpPage.last_name);
	    webelement.sendKeys("Test");
	    log.info("it's entered value :Test ");
	    
	    // Enter "email" as "<Email>"
	    String mailsubstring = StringUtils.substringBefore(arg1, "@");
	    mailId=mailsubstring;
//		String mail="protest"+x+"@getnada.com";
//		log.info("Mail enter for sign up : "+mail);
		webelement=driver.findElement(SignUpPage.email);
	    webelement.sendKeys(arg1);
	    log.info("it's entered value"+ arg1);
	    
	    //Enter "password" as "<Password>"
	    
	    webelement=driver.findElement(SignUpPage.password);
	    webelement.sendKeys("Test2019");
	    log.info("it's entered value : Test2019 ");
	    
	    //Enter "card_number" as "<card Number>"
	    
		webelement=driver.findElement(SignUpPage.card_number);
	    webelement.sendKeys("4111111111111111");
	    log.info("it's entered value : 4111111111111111");
	    
	    //	And Enter "card_name" as "<NameOnCard>"
	    
	    webelement=driver.findElement(SignUpPage.card_name);
	    webelement.sendKeys("ProTest");
	    log.info("it's entered value : ProTest");
	    
	    // And Enter "card_exp" as "<Expire Date>"
	    
	    webelement=driver.findElement(SignUpPage.card_exp);
	    webelement.sendKeys("02/22");
	    log.info("it's entered value : 02/22");
	    
	    //	And Enter "card_cvv" as "<card cvv>"
	    
	    webelement=driver.findElement(SignUpPage.card_cvv);
	    webelement.sendKeys("123");
	    log.info("it's entered value : 123");
	    
	    //Select I agree to HealthPRO's check box
	    
	    webelement=driver.findElement(SignUpPage.I_agree);
		if(!webelement.isSelected()) 
		{
			webelement.click();
			log.info("it's Selecting I agree to HealthPRO's check box");
			Thread.sleep(1500);
			
		}
		
		//Click on 'Complete Order' Button
		
		webelement = driver.findElement(SignUpPage.complete_order);
		webelement.click();
		log.info("Clicked on 'Complete Order' Button");
		Thread.sleep(1000);
		
		//Verify Welcome Message at Sign-Up Wizard Page
		
		webelement = TestUtil.presenceOfElementWait(SignUpPage.welcomeText_SignUpWizard);
		String welcomMessage=webelement.getText();
		String ExpectedMessage="Thank you for your business!";
		String ExpectedMessage2=ExpectedMessage.toUpperCase();
		assertEquals(ExpectedMessage2,welcomMessage);
		log.info("Welcome message matched");
		
		//Click on 'Get Started' Button
		
		webelement = driver.findElement(SignUpPage.btnGet_Started);
		webelement.click();
		log.info("Clicked on 'Get Started' Button");
		
		//Set your location Form open
		webelement = TestUtil.presenceOfElementWait(SignUpPage.txtPrimary_Location);
		String welcomMessageAtSetLocation=webelement.getText();
		String ExpectedMessageAtSetLocation="Set Your Primary Location";
		assertEquals(ExpectedMessageAtSetLocation,welcomMessageAtSetLocation);
		log.info("Set Your Primary Location message matched");
		
		//Verify 'Where do you accept clients?' adding location appears 
		webelement = TestUtil.presenceOfElementWait(SignUpPage.txt_accept_clients);
		String welcomMessageaccept=webelement.getText();
		String ExpectedMessageaccept="Where do you accept clients?";
		String ExpectedMessage2accept=ExpectedMessageaccept.toUpperCase();
		assertEquals(ExpectedMessage2accept,welcomMessageaccept);
		log.info("Where do you accept clients? message matched");
		
	    //Click on 'My Office/Studio' options
		webelement = driver.findElement(SignUpPage.my_Office_Options);
		webelement.click();
		log.info("Clicked on 'My Office/Studio' options");
		
		//Enter name of location as "<location>"
		webelement = driver.findElement(SignUpPage.locationName);
		webelement.click();
		webelement.sendKeys("Home");
		log.info("it's Entered name of location as Home");
		
		//And Enter address as "<address>"
		
		webelement = driver.findElement(SignUpPage.locationAddress);
		webelement.click();
		webelement.sendKeys("56 Franklin Street, Petersburg, VA 23803, United States");
		Thread.sleep(1000);
		webelement.sendKeys(Keys.ARROW_DOWN);
		log.info("it's Entered address");
		Thread.sleep(1000);
		
		//Select Day as "<Day>"
		webelement = driver.findElement(By.xpath("//span[contains(text(),'Mon')]"));
		webelement.click();		
		log.info("it's clicked on Mon Day"); 
		Thread.sleep(500);
		webelement = driver.findElement(By.xpath("//span[contains(text(),'Wed')]"));
		webelement.click();		
		log.info("it's clicked on Mon Day");
	    
// 1		//Then Click on 'Next Step' button
		webelement = driver.findElement(SignUpPage.btn_NextStep);
		webelement.click();		
		log.info("it's clicked on Next Step' button"); 
		Thread.sleep(500);
		
		//Wait for title text :
		webelement = TestUtil.presenceOfElementWait(By.xpath("//h2[@class='professional_setup_wizard--header--title' and contains(text(),'Your Expertise')]"));
		System.err.println(webelement.getText());
		//Boolean bln = (new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, "Your Expertise"));
		
		//Select 'classes' options that can yours clients book 
		Thread.sleep(2000);
		webelement = driver.findElement(SignUpPage.classForclients);
		webelement.click();
		Thread.sleep(1000);
		
		//Search & Select your services as "<services>"
		webelement = driver.findElement(SignUpPage.searchServices);
		webelement.sendKeys("Yoga");
		Thread.sleep(500);
		webelement = driver.findElement(By.xpath("//li[@class='ui-menu-item m-parent']//a"));
		webelement.click();
		
		//Select your services as "<services2>"
		
		webelement = driver.findElement(SignUpPage.SelectServices);
		Select select=new Select(webelement);
		select.selectByVisibleText("Bhakti Yoga");
		Thread.sleep(500);
		
		//Enter "title" of your "<class>"
		
		webelement = driver.findElement(SignUpPage.title);
		webelement.sendKeys("YogaGuru");
		
		//Select Session duration as "<duration>"
		
		webelement = driver.findElement(SignUpPage.sessionDuration);
		Select selectSession=new Select(webelement);
		selectSession.selectByValue("10");
		
		//Enter discounts for Session as "<discounts>"
		webelement = driver.findElement(SignUpPage.sessionDiscounts);
		webelement.sendKeys("20");
		Thread.sleep(500);
		
		//And Select 'today's' date from calendar
		webelement = driver.findElement(SignUpPage.calendarFrom);
		webelement.click();
		Thread.sleep(1000);
		webelement = driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[1]"));
		webelement.click();
		
// 2	//Then Click on 'Next Step' button
				webelement = driver.findElement(SignUpPage.btn_NextStep);
				webelement.click();		
				log.info("it's clicked on Next Step' button"); 
				Thread.sleep(500);
				
		//Enter Phone Number for Otp verification as "<Number>"
		
		webelement = driver.findElement(SignUpPage.phoneNumber);
		Thread.sleep(2000);
		webelement.click();
		Thread.sleep(500);
		webelement.sendKeys("(718)" + "343" + "2343");
//		js.executeScript("arguments[0].value='1812345678';", webelement);
//		webelement.sendKeys("8123456789");
//		webelement.sendKeys(Keys.chord("8123456789"));
		Thread.sleep(500);
		
		//Click on Verify By SMS button
		webelement = driver.findElement(SignUpPage.verifySMSbtn);
		webelement.click();
		
		//Enter Otp Value
//		NadaMail4Otp.getMail(mailId);
//		log.info(otpPassword);
		webelement = driver.findElement(SignUpPage.otpInputField);
		webelement.sendKeys("55555");
		
		//Click on Verify OTP button
		webelement = driver.findElement(SignUpPage.verify_OTP_button);
		webelement.click();
		Thread.sleep(1500);
		
// 3	//Then Click on 'Next Step' button
		webelement = driver.findElement(SignUpPage.btn_NextStep);
		webelement.click();		
		log.info("it's clicked on Next Step' button"); 
		Thread.sleep(500);
		
		//Click on 'Click Here' if you didn't receive an email link
		Thread.sleep(5000);
		webelement=TestUtil.elementToBeClickableWait(SignUpPage.click_HereForConfirmationMail);	
		webelement.click();
		Thread.sleep(1000);
		
		//mail Sent Success 'Alert' prompt open
		
		webelement=TestUtil.elementToBeClickableWait(SignUpPage.btn_OK);	
		webelement.click();
		Thread.sleep(500);
		
		//Wait for Confirmation mail & click on 'Verify my email' button
		boolean mailConfirmed=NadaMail4Confirmation.verifyMyEmail();
		assertTrue(mailConfirmed);
		log.info("Mail confirmed");
		
		//Verify 'Welcome to your dashboard!' prompt appears
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		webelement = TestUtil.presenceOfElementWait(SignUpPage.txt_DashboardWelcomeMessage);
		String resutlObtain=webelement.getText();
		String expectedResults="Welcome to your dashboard!";
		assertEquals(expectedResults,resutlObtain);
		log.info("welcome--title message matched");
		
		//Click on 'Get Started' button
		webelement = TestUtil.presenceOfElementWait(SignUpPage.btn_Dashboard_Get_Started);
		webelement.click();
		
		//Click on 'Next & Not Now' button on Demo
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
		
		//Close window
		
		driver.switchTo().window(tabs.get(1));
		driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window(tabs.get(0));
		driver.close();
		Thread.sleep(2000);	
		
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(2000);	
		
	}

}
