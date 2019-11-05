package stepDefinations;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.ClientsPage;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClientsStepDefination extends SetupClass{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@And("^Click on 'Clients' Side-Bar$")
	public void click_on_Clients_Side_Bar() throws Throwable {
//		Thread.sleep(3000);
//		 js.executeScript("return document.documentElement.scrollTop = 0;");
		 Thread.sleep(2000);
		webelement=driver.findElement(ClientsPage.clientsMenu);
	 webelement.click();
	 Thread.sleep(500);
	}

	@Then("^Select 'My Clients' Side-Bar Menu options$")
	public void select_My_Clients_Side_Bar_Menu_options() throws Throwable {
		Thread.sleep(1000);
		webelement=driver.findElement(ClientsPage.myClientsOptions);
		webelement.click();
	}

	@And("^Click on 'Invite Your Clients' button$")
	public void click_on_Invite_Your_Clients_button() throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(ClientsPage.inviteClientbtn);
		webelement.click();
	}

	@And("^Click on 'Fill in Form' button$")
	public void click_on_Fill_in_Form_button() throws Throwable {
		webelement=driver.findElement(ClientsPage.fillInFormbtn);
		webelement.click();
	}

	@And("^Enter Clients \"([^\"]*)\" in text box as \"([^\"]*)\"$")
	public void enter_Clients_in_text_box_as(String locator, String value) throws Throwable {
	   webelement=driver.findElement(By.xpath("//input[@data-field='"+locator+"']"));	
				webelement.sendKeys(value);
				Thread.sleep(500);
	}

	@And("^Enter Clients \"([^\"]*)\" in text box \"([^\"]*)\"$")
	public void enter_Clients_in_text_box(String locator, String arg2) throws Throwable {
		
		Random rand=new Random();
		int x=rand.nextInt(10000);
		 clientsMailId="ClientsTest"+x;
			String mail="ClientsTest"+x+"@getnada.com";
			System.out.println("Mail enter for sign up : "+mail);
			webelement=driver.findElement(By.xpath("//input[@data-field='"+locator+"']"));	
		    webelement.sendKeys(mail);
		    System.out.println("it's entered value"+ mail);
		Thread.sleep(500);
	}
	
	@And("^Click on 'Suitability' Side-Bar Menu options$")
	public void click_on_Suitability_Side_Bar_Menu_options() throws Throwable {
		webelement=driver.findElement(ClientsPage.suitabilityOptions);
		webelement.click();
	}

	@And("^click on \"([^\"]*)\" item panel to open it$")
	public void click_on_item_panel_to_open_it(String arg1) throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(By.xpath("//b[text()='"+arg1+"']//parent::label"));
		webelement.click();
		Thread.sleep(500);
	}

	@And("^Select \"([^\"]*)\" from listed item$")
	public void select_from_listed_item(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("//span[@class='checkbox--label' and contains(text(),'"+arg1+"')]"));
		webelement.click();
		Thread.sleep(500);
	}

	@And("^Click on 'Save Changes' button$")
	public void click_on_Save_Changes_button() throws Throwable {
		webelement=driver.findElement(ClientsPage.saveChangesbtn);
		webelement.click();
	}
	@Then("^Verify \"([^\"]*)\" is properly selcted from listed item or not$")
	public void verify_is_properly_selcted_from_listed_item_or_not(String arg1) throws Throwable {
	  webelement=TestUtil.presenceOfElementWait(By.xpath("//span[@data-id and contains(text(),'"+arg1+"')]"));
	  System.out.println(arg1+"Element is present");
	  log.info(arg1+"Element is present");
	}
	
	@And("^Click on 'Upload and Send Emails' button$")
	public void click_on_Upload_and_Send_Emails_button() throws Throwable {
		webelement=driver.findElement(ClientsPage.uploadNSendMailbtn);
		webelement.click();
		Thread.sleep(500);
	}

	@And("^Click on 'View Reports' link$")
	public void click_on_View_Reports_link() throws Throwable {
		webelement=driver.findElement(ClientsPage.viewReportsbtn);
		webelement.click();
		Thread.sleep(500);
	}

	@And("^Verify email sent to correct user$")
	public void verify_email_sent_to_correct_user() throws Throwable {
	webelement=driver.findElement(By.xpath("//li[text()='"+clientsMailId+"@getnada.com"+"']"));
	Thread.sleep(500);
	}

	@When("^Click on 'Done' button$")
	public void click_on_Done_button() throws Throwable {
		webelement=driver.findElement(ClientsPage.donebtn);
		webelement.click();
		Thread.sleep(500);
	}

	@Then("^Verify user is listed under 'Pending Invitations' section$")
	public void verify_user_is_listed_under_Pending_Invitations_section() throws Throwable {
		 webelement=TestUtil.presenceOfElementWait(By.xpath("//td[normalize-space()='"+clientsMailId+"@getnada.com"+"']"));
		  System.out.println("Element is present");
		  log.info("Element is present");
	}

}
