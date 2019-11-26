package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.AccountSettingsPage;
import com.healthPro.pages.BasicInfoPage;
import com.healthPro.pages.MyProfilePage;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AccountSettingsStepDefinations extends SetupClass{
	Actions ac=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	@And("^Click on 'Account Settings' Side-Bar$")
	public void click_on_Account_Settings_Side_Bar() throws Throwable {
	 Thread.sleep(3000);
	 js.executeScript("return document.documentElement.scrollTop = 0;");
	 Thread.sleep(2000);
		webelement=driver.findElement(AccountSettingsPage.accountSettingsSideBar);
		System.out.println("abds"+webelement);
//	  js.executeScript("arguments[0].scrollIntoView()", webelement); 
	  webelement.click();
	}

	@Then("^Select 'Payment Gateways' Side-Bar Menu options$")
	public void select_Payment_Gateways_Side_Bar_Menu_options() throws Throwable {
		webelement=driver.findElement(AccountSettingsPage.paymentGatwayMenu);
		webelement.click();
	}

	@And("^'Online Only' payment method$")
	public void online_Only_payment_method() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.onlineOnlyOptions);
		webelement.click();
	}
	@And("^'In Person & Online' payment method$")
	public void in_Person_Online_payment_method() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.inPersonNOnlineOptions);
		webelement.click();
	}

	@And("^Click on 'Log In with PayPal' button$")
	public void click_on_Log_In_with_PayPal_button() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.payPalbtn);
		webelement.click();
	}
	
	@Then("^Verify \"([^\"]*)\" panel header Title text$")
	public void verify_panel_header_Title_text(String title) throws Throwable {
		Thread.sleep(1500);
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.panelHeaderTitle);
		String resultObtain=webelement.getText();
		String expectedTitle=title;
		assertEquals(expectedTitle,resultObtain);
		System.out.println("Title Text is verified");
	}
	
	@And("^Verify 'Log in with PayPal' header text appears$")
	public void verify_Log_in_with_PayPal_header_text_appears() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.payPalHeaderText);
		String resultObtain=webelement.getText();
		String expectedTitle="Log in with PayPal";
		assertEquals(expectedTitle,resultObtain);
		System.out.println("PayPal Title Text is verified");
	}
	
	@Then("^login with 'PayPal' Account$")
	public void login_with_PayPal_Account() throws Throwable {
		webelement=driver.findElement(AccountSettingsPage.payPalEmail);
		webelement.sendKeys("dovidk@healthpro.com");
		Thread.sleep(1000);
		System.out.println("it's Entered Paypal emai ");
		webelement=driver.findElement(AccountSettingsPage.payPalNextBtn);
		webelement.click();
		System.out.println("it's clicked on Paypal Next btn ");
		Thread.sleep(2000);
		
		webelement=driver.findElement(AccountSettingsPage.payPalPassword);
		webelement.sendKeys("Healthpr0");
		System.out.println("it's Entered Paypal Password ");
		Thread.sleep(1000);
		webelement=driver.findElement(AccountSettingsPage.payPalLoginBtn);
		webelement.click();
		System.out.println("it's clicked on Paypal login btn ");
		Thread.sleep(5000);		
		
	}
	
	@And("^Verify 'Your PayPal account is connected' String Message$")
	public void verify_Your_PayPal_account_is_connected_String_Message() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.PayPalAccountConnected);
		String resultObtain=webelement.getText();
		String expectedTitle="Your PayPal account is connected";
		assertEquals(expectedTitle,resultObtain);
		System.out.println("Your PayPal account is connected Text is verified");
	}
	
	@And("^Click on 'Connect with Stripe' button$")
	public void click_on_Connect_with_Stripe_button() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.stripebtn);
		webelement.click();
	}

	@And("^Verify 'Stripe' header text appears$")
	public void verify_Stripe_header_text_appears() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.stripeHeaderText);
		String resultObtain=webelement.getText();
		System.err.println(resultObtain);
//		String expectedTitle="Strip";
//		assertEquals(expectedTitle,resultObtain);
		System.out.println("'Stripe' header text appears");
	}

	@And("^Click on Already have a Stripe account\\? 'Sign In' button$")
	public void click_on_Already_have_a_Stripe_account_Sign_In_button() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.stripesignInLink);
		webelement.click();
	}

	@Then("^login with 'Stripe' Account$")
	public void login_with_Stripe_Account() throws Throwable {
		webelement=driver.findElement(AccountSettingsPage.stripeEmail);
		webelement.sendKeys("testsqelabs@gmail.com");
		Thread.sleep(1000);
		
		webelement=driver.findElement(AccountSettingsPage.stripePassword);
		webelement.sendKeys("P@ssword1");
		Thread.sleep(1000);
		
		webelement=driver.findElement(AccountSettingsPage.stripeLoginBtn);
		webelement.click();
	}
	
	@And("^Click on 'Add Youtube Video' button$")
	public void click_on_Add_Youtube_Video_button() throws Throwable {
		webelement=driver.findElement(MyProfilePage.addVideobtn);
		webelement.click();
		Thread.sleep(500);
		log.info("it's clicked on 'Add Youtube Video' button");
	}

	@And("^Enter YouTube Video Url in textbox as \"([^\"]*)\"$")
	public void enter_YouTube_Video_Url_in_textbox_as(String arg1) throws Throwable {
		webelement=driver.findElement(MyProfilePage.addUrl);
		webelement.sendKeys(arg1);
		log.info("it's Entered YouTube Video Url in textbox");
	}

	@And("^Enter Video Title in textbox as \"([^\"]*)\"$")
	public void enter_Video_Title_in_textbox_as(String arg1) throws Throwable {
		webelement=driver.findElement(MyProfilePage.addVideoTitle);
		webelement.sendKeys(arg1);
		log.info("it's Entered YouTube Video Title in textbox");
	}

	@And("^Verify Video is uploaded or not$")
	public void verify_Video_is_uploaded_or_not() throws Throwable {
		webelement=driver.findElement(MyProfilePage.editVideo);
		webelement.click();
		Thread.sleep(500);
		webelement=driver.findElement(MyProfilePage.txtEditVideo);
		webelement.sendKeys("My Profile Video");
		Thread.sleep(500);
		webelement=driver.findElement(MyProfilePage.saveVideoTitleBtn);
		webelement.click();
	}
	
	@And("^Click on 'Submit your YouTube video' button$")
	public void click_on_Submit_your_YouTube_video_button() throws Throwable {
		webelement=driver.findElement(MyProfilePage.submitVideobtn);
		webelement.click();
		Thread.sleep(500);
		log.info("it's clicked on 'Submit your YouTube video' button");
	}
	@And("^Enter 'About Me' \"([^\"]*)\" in text field$")
	public void enter_About_Me_in_text_field(String arg1) throws Throwable {
		webelement=driver.findElement(BasicInfoPage.aboutMe);
		webelement.click();
		webelement.sendKeys(arg1);
	}

	@And("^Enter 'Professional Statement' \"([^\"]*)\" in text field$")
	public void enter_Professional_Statement_in_text_field(String arg1) throws Throwable {
		webelement=driver.findElement(BasicInfoPage.professionalStatement);
		webelement.click();
		webelement.sendKeys(arg1);
	}

	@And("^Select \"([^\"]*)\" Languages from dropdown list$")
	public void select_Languages_from_dropdown_list(String arg1) throws Throwable {
		webelement=driver.findElement(BasicInfoPage.languageSearch);
		webelement.click();
		webelement.sendKeys(arg1);
		webelement=driver.findElement(By.xpath("//li[contains(text(),'"+arg1+"')]"));
		webelement.click();
	}
	@And("^Logout Application$")
	public void logout_Application() throws Throwable {
		webelement=driver.findElement(BasicInfoPage.userMenu);
		webelement.click();
		webelement=driver.findElement(BasicInfoPage.logoutOptions);
		webelement.click();
	}
	@And("^Verify 'About Me' \"([^\"]*)\" added text field or not$")
	public void verify_About_Me_added_text_field_or_not(String arg1) throws Throwable {
		webelement=driver.findElement(BasicInfoPage.aboutMe);
		System.out.println(webelement.getText());
		System.out.println(webelement.getAttribute("innerHTML"));
		System.out.println(webelement.getAttribute("textContent"));
		
	}

	@And("^Verify 'Professional Statement' \"([^\"]*)\" added text field or not$")
	public void verify_Professional_Statement_added_text_field_or_not(String arg1) throws Throwable {
		webelement=driver.findElement(BasicInfoPage.professionalStatement);
		System.out.println(webelement.getText());
		System.out.println(webelement.getAttribute("innerHTML"));
		System.out.println(webelement.getAttribute("textContent"));
	}

	@And("^Verify \"([^\"]*)\" Languages is selected or not$")
	public void verify_Languages_is_selected_or_not(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("//span[contains(text(),'"+arg1+"')]"));
		log.info(arg1+" : Language is selected");
	}

}
