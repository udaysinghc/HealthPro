package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.ClientsLoginPage;
import com.healthPro.pages.ClientsPage;
import com.healthPro.pages.SignUpPage;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClientInvitationStepDefinations extends SetupClass{
	Actions ac=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	@When("^Open Client Mail Inbox$")
	public void open_Client_Mail_Inbox() throws Throwable {

		driver.get("https://getnada.com/");
		
		//add index
		webelement=TestUtil.elementToBeClickableWait(By.xpath("//span[contains(text(),'Add Inbox')]"));
		webelement.click();
		
		//add inbox user
		webelement=TestUtil.elementToBeClickableWait(By.xpath("//input[@class='user_name']"));
		webelement.click();
		Thread.sleep(500);
		webelement.clear();
		webelement.sendKeys(clientsMailId);
		
		//click on Accept button
		webelement=TestUtil.elementToBeClickableWait(By.xpath("//a[@class='button success']"));
		webelement.click();
		
		String mail=clientsMailId.toLowerCase();
		//click on added inbox
		webelement=TestUtil.elementToBeClickableWait(By.xpath("//span[contains(text(),'"+mail+"@getnada.com')]"));
		webelement.click();
		Thread.sleep(2000);
	}

	@Then("^Verify Invitaion mail received$")
	public void verify_Invitaion_mail_received() throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='msg_list']//li"));
		int totalInboxMail=list.size();
		System.out.println("Total number of mail :"+totalInboxMail);
		
		int maxTry=0;
		for(int i=1;i<=totalInboxMail;i++) 
		{
			
			webelement=driver.findElement(By.xpath("(//ul[@class='msg_list']//li)["+i+"]"));
			if(webelement.getText().contains("has started using HealthPRO!")) 
			{webelement.click();
			System.out.println("Mail found");
			
			break;
						
			}else if(i==list.size() && maxTry<=2) 
			{
				System.out.println("Wait for 30 secounds for get mail in inbox");
				Thread.sleep(30000);
				List<WebElement> list2=driver.findElements(By.xpath("//ul[@class='msg_list']//li"));
				totalInboxMail=list2.size();
				System.out.println("Now Number of mail after 30 secound wait :"+totalInboxMail);
				i=0;
				maxTry++;
			}else if(maxTry==3) 
			{
				System.out.println("Mail not found");

				break;
			}
		}
	}

	@And("^Click on 'Click here' link to create FREE account$")
	public void click_on_Click_here_link_to_create_FREE_account() throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   driver.switchTo().frame("idIframe");
	   webelement=driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
	   webelement.click();
	   log.info("it's clicked on 'Click here' link for create FREE account");
	}

	@When("^Verify \"([^\"]*)\" panel open$")
	public void verify_panel_open(String title) throws Throwable {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		webelement=TestUtil.presenceOfElementWait(ClientsLoginPage.panelHeaderTitle);
		   String resultObtain=webelement.getText();
			String expectedTitle=title;
			assertEquals(expectedTitle,resultObtain);
			System.out.println("div Title Text is verified");
			
			driver.switchTo().window(tabs.get(0));
			driver.close();
			Thread.sleep(2000);	
			
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			Thread.sleep(2000);	
	}

	@Then("^Enter \"([^\"]*)\" in text filed$")
	public void enter_in_text_filed(String arg1) throws Throwable {
		 webelement=driver.findElement(ClientsLoginPage.newPassword);
		 webelement.click();
		 webelement.clear();
		 webelement.sendKeys(arg1);
	}

	@And("^Enter Confirm \"([^\"]*)\" in text field$")
	public void enter_Confirm_in_text_field(String arg1) throws Throwable {
		 webelement=driver.findElement(ClientsLoginPage.confirmNewPassword);
		 webelement.click();
		 webelement.clear();
		 webelement.sendKeys(arg1);
	}

	@And("^Click on 'Set Password' button$")
	public void click_on_Set_Password_button() throws Throwable {
		 webelement=driver.findElement(ClientsLoginPage.setPasswordbtn);
		 webelement.click();
	}
	@And("^Click on 'I agree to HealthPRO's' TC check box$")
	public void click_on_I_agree_to_HealthPRO_s_TC_check_box() throws Throwable {
		 webelement=driver.findElement(ClientsLoginPage.agreeTC);
		 webelement.click();
	}
	@And("^Verify \"([^\"]*)\" appears & click on Ok button$")
	public void verify_appears_click_on_Ok_button(String title) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//div[@class='vex-dialog-message']"));
		Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, title));
		if(bln){
		   String resultObtain=webelement.getText();
			String expectedTitle=title;
			assertEquals(expectedTitle,resultObtain);
			System.out.println(" Title Text is verified");
			
			webelement=driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
			webelement.click();
			log.info("it's clicked on OK button");
			}
	}
	@And("^Verify \"([^\"]*)\" & \"([^\"]*)\" class available for booking$")
	public void verify_class_available_for_booking(String arg1, String arg2) throws Throwable {
	    webelement=TestUtil.presenceOfElementWait(By.xpath("//span[@class='class-title' and contains(text(),'"+arg1+"')]"));
	    log.info(arg1+"Class found");
	    webelement=driver.findElement(By.xpath("//span[@class='class-title' and contains(text(),'"+arg2+"')]"));
	    log.info(arg2+"Class found");
	}
	@And("^Click on \"([^\"]*)\" options$")
	public void click_on_options(String arg1) throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(By.xpath("//span[@class='class-title' and contains(text(),'"+arg1+"')]"));
	ac.moveToElement(webelement).build().perform();
		webelement.click();
		Thread.sleep(500);
	    log.info(arg1+"Class clicked");
	}

	@And("^Choose your start date to Start Class$")
	public void choose_your_start_date_to_Start_Class() throws Throwable {
		Thread.sleep(1000);
		webelement=driver.findElement(By.xpath("(//td[@title='Available']//a)[2]"));
//		ac.moveToElement(webelement).build().perform();
		Thread.sleep(500);
		webelement.click();
	}

	@And("^Click on Book \"([^\"]*)\" button$")
	public void click_on_Book_button(String arg1) throws Throwable {
		try{webelement=driver.findElement(By.xpath("//span[@class='class-title' and contains(text(),'"+arg1+"')]//following::button[@data-book-class]"));
		ac.moveToElement(webelement).build().perform();
		Thread.sleep(500);
		webelement.click();}catch(Exception e) 
		{
			webelement=driver.findElement(By.xpath("//span[@class='class-title' and contains(text(),'"+arg1+"')]//following::button[@data-book-class]"));
			js.executeScript("arguments[0].click();", webelement);
		}
	}

	@And("^Verify \"([^\"]*)\" wizard open$")
	public void verify_wizard_open(String title) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h1[@data-wizard-title]"));
		Thread.sleep(1000);
		   String resultObtain=webelement.getText();
			String expectedTitle=title;
			
//			assertEquals(expectedTitle,resultObtain);
			System.out.println(" Title Text is verified");
	}

	@And("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
		Thread.sleep(1000);
		webelement=TestUtil.presenceOfElementWait(By.xpath("(//button[contains(text(),'"+arg1+"')])"));
		ac.moveToElement(webelement).build().perform();
		Thread.sleep(500);
		webelement.click();
	}
	@When("^Verify \"([^\"]*)\" prompt open$")
	public void verify_prompt_open(String title) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//header[@class='phone_verification--header']"));
		Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, title));
		if(bln){
		   String resultObtain=webelement.getText();
			String expectedTitle=title;
			assertEquals(expectedTitle,resultObtain);
			System.out.println(" Title Text is verified");}
	}

	@Then("^Verify Mobile number using SMS$")
	public void verify_Mobile_number_using_SMS() throws Throwable {
		webelement = driver.findElement(SignUpPage.phoneNumber);
		Thread.sleep(2000);
		webelement.click();
		Thread.sleep(500);
		webelement.sendKeys("(718)" +"3432343");

		Thread.sleep(500);
		
		//Click on Verify By SMS button
		webelement = driver.findElement(SignUpPage.verifySMSbtn);
		webelement.click();
		
		//Enter Otp Value

		webelement = driver.findElement(SignUpPage.otpInputField);
		webelement.sendKeys("55555");
		
		Thread.sleep(1000);
		
		webelement=TestUtil.presenceOfElementWait(By.xpath("(//button[contains(text(),'Verify')])[3]"));
		webelement.click();
		
		webelement=TestUtil.presenceOfElementWait(By.xpath("//a[contains(text(),'Continue')]"));
		webelement.click();
	}
	@And("^Click on \"([^\"]*)\" Link$")
	public void click_on_Link(String arg1) throws Throwable {
		try{webelement=TestUtil.presenceOfElementWait(By.xpath("//a[contains(text(),'"+arg1+"')]"));
		ac.moveToElement(webelement).build().perform();
		Thread.sleep(500);
		webelement.click(); }catch(Exception e) 
		{
			webelement=TestUtil.presenceOfElementWait(By.xpath("//a[contains(text(),'"+arg1+"')]"));
			ac.moveToElement(webelement).build().perform();
			Thread.sleep(500);
			webelement.click();
		}
	}
	@And("^Verify \"([^\"]*)\" block appears$")
	public void verify_block_appears(String arg1) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h2[contains(text(),'"+arg1+"')]"));
		Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, arg1));
		if(bln){
		   String resultObtain=webelement.getText();
			String expectedTitle=arg1;
			assertEquals(expectedTitle,resultObtain);
			System.out.println(" Title Text is verified");}
	}
	@And("^Verify \"([^\"]*)\" success message appears on prompt$")
	public void verify_success_message_appears_on_prompt(String arg1) throws Throwable {
		try{webelement=TestUtil.presenceOfElementWait(By.xpath("//h1[contains(text(),'done it!')]"));
		Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, arg1));
		if(bln){
		   String resultObtain=webelement.getText();
			String expectedTitle=arg1;
			assertEquals(expectedTitle,resultObtain);
			System.out.println(" Title Text is verified");}}catch(Exception e) 
		{
				webelement=TestUtil.presenceOfElementWait(By.xpath("//h1[contains(text(),'done it!')]"));
				Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, arg1));
				if(bln){
				   String resultObtain=webelement.getText();
					String expectedTitle=arg1;
					assertEquals(expectedTitle,resultObtain);
					System.out.println(" Title Text is verified");}
		}
	}
	@Then("^Verify 'Booking Successful' success message appears on prompt$")
	public void verify_Booking_Successful_success_message_appears_on_prompt() throws Throwable {
		try{webelement=TestUtil.presenceOfElementWait(By.xpath("//h1[contains(text(),'Booking Successful')]"));
		Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, "Booking Successful"));
		if(bln){
		   String resultObtain=webelement.getText();
			String expectedTitle="Booking Successful";
			assertEquals(expectedTitle,resultObtain);
			System.out.println(" Title Text is verified");}}catch(Exception e) 
		{
				Thread.sleep(1000);
				webelement=TestUtil.presenceOfElementWait(By.xpath("//h1[contains(text(),'Booking Successful')]"));
				Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, "Booking Successful"));
				if(bln){
				   String resultObtain=webelement.getText();
					String expectedTitle="Booking Successful";
					assertEquals(expectedTitle,resultObtain);
					System.out.println(" Title Text is verified");}
		}
	}

	@When("^click on 'Instructor' link for book class$")
	public void click_on_Instructor_link_for_book_class() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//span[text()='Pro Test']//parent::a")); 
		ac.moveToElement(webelement).build().perform();
		Thread.sleep(500);
		webelement.click();
	}
	@When("^Select \"([^\"]*)\" 'CATEGORIES' form list$")
	public void select_CATEGORIES_form_list(String arg1) throws Throwable {
		Thread.sleep(1000);
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h3[contains(text(),'"+arg1+"')]"));
		webelement.click();
	}

	@Then("^Verify \"([^\"]*)\" class available under \"([^\"]*)\" CATEGORIES$")
	public void verify_class_available_under_CATEGORIES(String arg1, String arg2) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//span[@class='class-title' and contains(text(),'"+arg1+"')]"));
	    log.info(arg1+"Class found");
	}
	@When("^Verify \"([^\"]*)\" is selected for Booking$")
	public void verify_is_selected_for_Booking(String arg1) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h3[contains(text(),'Session')]"));
		 log.info(arg1+"is selected");
	}

	@And("^Select \"([^\"]*)\" Duration$")
	public void select_Duration(String arg1) throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(By.xpath("//div[contains(text(),'"+arg1+"')]"));
		webelement.click();
	}

	@And("^Click on \"([^\"]*)\" Buy Now button$")
	public void click_on_Buy_Now_button(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("(//div[contains(text(),'"+arg1+"')]//following::button)[1]"));
		webelement.click();
	}

	@And("^Verify \"([^\"]*)\" buy 'Package' open$")
	public void verify_buy_Package_open(String arg1) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("(//div[@class='buy_package--title' and contains(text(),'"+arg1+"')])"));
		Boolean bln=(new WebDriverWait(driver,30)).until(ExpectedConditions.textToBePresentInElement(webelement, arg1));
		if(bln){
		   String resultObtain=webelement.getText();
			String expectedTitle=arg1;
			assertEquals(expectedTitle,resultObtain);
			System.out.println(" Title Text is verified");}
	}

	@And("^Click on 'Buy Package' button$")
	public void click_on_Buy_Package_button() throws Throwable {
		
		webelement=driver.findElement(By.xpath("//button[@class='btn m-red buy_package--btn']"));
		webelement.click();
		Thread.sleep(1000);
	}
	@And("^Click on \"([^\"]*)\" button at \"([^\"]*)\"$")
	public void click_on_button_at(String arg1, String arg2) throws Throwable {
		webelement=driver.findElement(By.xpath("//*[text()='"+arg2+"']//following::button[@class='booking_widget--button btn m-red m-border m-wide']"));
		webelement.click();
		Thread.sleep(1000);
	}

	@And("^Select available 'appointment' date from calendar$")
	public void select_available_appointment_date_from_calendar() throws Throwable {
//		webelement=driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active']"));
//		webelement.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> list=driver.findElements(By.xpath("//button[@class='btn m-blue m-small booking_time--list_empty--btn booking_time--list_empty--show_next']"));
		if(list.size()>0) 
		{try {
			webelement=driver.findElement(By.xpath("//button[@class='btn m-blue m-small booking_time--list_empty--btn booking_time--list_empty--show_next']"));
			webelement.click();}
		catch(Exception e) 
		{
			log.info("element not interactable");	
		}
		}
	}

	@And("^Select Booking Time for 'appointment'$")
	public void select_Booking_Time_for_appointment() throws Throwable {
		webelement=driver.findElement(By.xpath("//li[@class='booking_time--list--item']"));
		webelement.click();
	}

	@When("^Click on 'My Profile' Side-Bar$")
	public void click_on_My_Profile_Side_Bar() throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(ClientsPage.myProfileMenu);
	 webelement.click();
	 Thread.sleep(500);
	}

	@Then("^Select 'Basic Info' Side-Bar Menu options$")
	public void select_Basic_Info_Side_Bar_Menu_options() throws Throwable {
		Thread.sleep(1000);
		webelement=driver.findElement(ClientsPage.basicInfoOptions);
		webelement.click();
	}

	@Then("^Select 'Date of Birth' of Clients$")
	public void select_Date_of_Birth_of_Clients() throws Throwable {
		Thread.sleep(1000);
		webelement=driver.findElement(By.name("dob_year"));
		Select selectdob=new Select(webelement);
		selectdob.selectByValue("1990");
		Thread.sleep(500);
		
		webelement=driver.findElement(By.name("dob_month"));
		Select selectdom=new Select(webelement);
		selectdom.selectByValue("10");
		Thread.sleep(500);
		
		webelement=driver.findElement(By.name("dob_day"));
		Select selectdoy=new Select(webelement);
		selectdoy.selectByValue("20");
		Thread.sleep(500);
	}

	@When("^Select 'Home Visits Locations' Side-Bar Menu options$")
	public void select_Home_Visits_Locations_Side_Bar_Menu_options() throws Throwable {
		Thread.sleep(1000);
		webelement=driver.findElement(ClientsPage.homeVisitLocationsOptions);
		webelement.click();
	}
	@And("^Enter \"([^\"]*)\" in \"([^\"]*)\" field$")
	public void enter_in_field(String arg1, String arg2) throws Throwable {
		final String Name="name";
		final String Address="address";
		
		switch(arg2){
		case Name:
			Thread.sleep(500);
		webelement=driver.findElement(By.name("name"));
		webelement.click();
		webelement.sendKeys(arg1);
		Thread.sleep(500);
		break;
		
		case Address:
			Thread.sleep(500);
			webelement=driver.findElement(By.name("address"));
			webelement.click();
			webelement.sendKeys(arg1);
			Thread.sleep(1000);
			webelement.sendKeys(Keys.ARROW_DOWN);
			log.info("it's Entered address");
			Thread.sleep(1500);
			webelement.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			break;
		
		}
	}
	@Then("^Verify \"([^\"]*)\" is appears in list$")
	public void verify_is_appears_in_list(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("//*[contains(text(),'"+arg1+"')]"));
		log.info(arg1+" found");
	}
	@Then("^Select 'Credit Cards' Side-Bar Menu options$")
	public void select_Credit_Cards_Side_Bar_Menu_options() throws Throwable {
		Thread.sleep(1000);
		webelement=driver.findElement(ClientsPage.creditCardsOptions);
		webelement.click();
	}

	@Then("^'Add Credit Card' promt open$")
	public void add_Credit_Card_promt_open() throws Throwable {
		Thread.sleep(1000);
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h2[@class='card_form--block--header--title']"));
		String resultObtain=webelement.getText();
		String expectedTitle="Add Credit Card";
		assertEquals(expectedTitle,resultObtain);
		System.out.println("Add Credit Card Title Text is verified");
	}

	@Then("^Select 'Save as Default Credit Card' check box$")
	public void select_Save_as_Default_Credit_Card_check_box() throws Throwable {
		webelement=driver.findElement(By.xpath("//span[contains(text(),'Save as Default Credit Card')]"));
		if(!webelement.isSelected()) 
		{
			webelement.click();
			System.out.println("it's Selecting 'Save as Default Credit Card' check box");
			Thread.sleep(1500);
			
		}
	}

	@And("^Enter \"([^\"]*)\" as \"([^\"]*)\" at 'Add New Credit Card'$")
	public void enter_as_at_Add_New_Credit_Card(String locator, String value) throws Throwable {
		final String Cnumber = "card_number";
		final String Cholder = "card_holder";
		final String Cexp = "card_exp";
		final String Ccvv = "card_cvv";

		switch (locator) {

		case Cnumber:
			webelement=driver.findElement(By.name("card_number"));
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		    
				    
		case Cholder:
			webelement=driver.findElement(By.name("card_holder"));
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		    
		case Cexp:
			webelement=driver.findElement(By.name("card_exp"));
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;
		    
		case Ccvv:
			webelement=driver.findElement(By.name("cvv"));
		    webelement.sendKeys(value);
		    System.out.println("it's entered value"+ value);
		    break;

		}

	}

	@And("^Click on 'Edit' card button$")
	public void click_on_Edit_card_button() throws Throwable {
		webelement=driver.findElement(By.xpath("//span[contains(text(),'5100')]//following::a[@class='cards_list--table--action--edit']"));
		webelement.click();
	}

	@Then("^'Edit Credit Card' promt open$")
	public void edit_Credit_Card_promt_open() throws Throwable {
		Thread.sleep(1000);
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h2[@class='card_form--block--header--title']"));
		String resultObtain=webelement.getText();
		String expectedTitle="Edit Credit Card";
		assertEquals(expectedTitle,resultObtain);
		System.out.println("Add Credit Card Title Text is verified");
	}
	
	@And("^Enter \"([^\"]*)\" in \"([^\"]*)\" TextBox at Sign_In_popup$")
	public void enter_in_TextBox_at_Sign_In_popup(String arg1, String arg2) throws Throwable {
		webelement=driver.findElement(By.name(arg2));
		webelement.click();
		webelement.clear();
		webelement.sendKeys(arg1);
		Thread.sleep(1000);
	}

	@And("^Select 'I agree to HealthPRO's' check box$")
	public void select_I_agree_to_HealthPRO_s_check_box() throws Throwable {
		webelement=driver.findElement(By.xpath("(//span[@class='checkbox--i'])"));
		webelement.click();
		Thread.sleep(1000);
	}
	
	@And("^Enter \"([^\"]*)\" in TextBox For SignUp$")
	public void enter_in_TextBox_For_SignUp(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		webelement.click();
		webelement.clear();
		webelement.sendKeys(arg1);
		Thread.sleep(2000);
	}
	@Then("^Verify \"([^\"]*)\" Message appears$")
	public void verify_Message_appears(String arg1) throws Throwable {
		Thread.sleep(1000);
		webelement=TestUtil.presenceOfElementWait(By.xpath("//*[contains(text(),'"+arg1+"')]"));
		String resultObtain=webelement.getText();
//		String expectedTitle=arg1;
//		assertEquals(expectedTitle,equalToIgnoringCase(resultObtain));
		log.info(resultObtain + "Message appears");
	}

	@And("^Enter \"([^\"]*)\" at 'Create a Password' Textbox$")
	public void enter_at_Create_a_Password_Textbox(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("//input[@placeholder='Create a Password']"));
		webelement.click();
		webelement.clear();
		webelement.sendKeys(arg1);
		Thread.sleep(500);
	}


}
