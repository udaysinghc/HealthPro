package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.AccountSettingsPage;
import com.healthPro.pages.PaymentInfoPage;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class PaymentInfoStepDefinations extends SetupClass{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	@And("^Click on 'Payment Info' Side-Bar$")
	public void click_on_Payment_Info_Side_Bar() throws Throwable {
		 Thread.sleep(3000);
		 js.executeScript("return document.documentElement.scrollTop = 0;");
		 Thread.sleep(2000);
		
		webelement=driver.findElement(PaymentInfoPage.paymentInfoSideBar);
	 webelement.click();
	 Thread.sleep(500);
	}

	@Then("^Select 'Account Plan' Side-Bar Menu options$")
	public void select_Account_Plan_Side_Bar_Menu_options() throws Throwable {
		 webelement=driver.findElement(PaymentInfoPage.accountPlanMenu);
		 webelement.click();
		 Thread.sleep(1000);
	}

	@And("^Click on 'Change Plan' button$")
	public void click_on_Change_Plan_button() throws Throwable {
		webelement=driver.findElement(PaymentInfoPage.upgradePlan);
		webelement.click();
		Thread.sleep(2000);
	}
	
	@And("^Click on 'Change to Monthly' plan button$")
	public void click_on_Change_to_Monthly_plan_button() throws Throwable {
		webelement=driver.findElement(PaymentInfoPage.chnageToMonthlyPlanbtn);
		webelement.click();
	}
	
	@And("^Click on 'Change' button$")
	public void click_on_Change_button() throws Throwable {
		webelement=driver.findElement(PaymentInfoPage.changebtn);
		webelement.click();
	}
	
	@And("^Click on 'Next' button$")
	public void click_on_Next_button() throws Throwable {
		Thread.sleep(2000);
		webelement=TestUtil.presenceOfElementWait(PaymentInfoPage.nextbtn);
		webelement.click();
	}
	
	@And("^Verify \"([^\"]*)\" popup header Title text$")
	public void verify_popup_header_Title_text(String title) throws Throwable {
		Thread.sleep(3000);
		try {
		webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.popupHeaderTitle);
		String resultObtain=webelement.getText();
		String expectedTitle=title;
		assertEquals(expectedTitle,resultObtain);
		System.out.println("popup Title Text is verified");}catch(Exception e) 
		{Thread.sleep(1000);
			webelement=TestUtil.presenceOfElementWait(AccountSettingsPage.popupHeaderTitle);
			String resultObtain=webelement.getText();
			String expectedTitle=title;
			assertEquals(expectedTitle,resultObtain);
			System.out.println("popup Title Text is verified");
		}
	}
	
	@And("^Enter Billing Name as \"([^\"]*)\"$")
	public void enter_Billing_Name_as(String arg1) throws Throwable {
		webelement=driver.findElement(PaymentInfoPage.billingName);
		webelement.sendKeys(arg1);
	}

	@And("^Enter Billing address as \"([^\"]*)\"$")
	public void enter_Billing_address_as(String arg1) throws Throwable {
		webelement=driver.findElement(PaymentInfoPage.billingAddress);
		webelement.sendKeys(arg1);
	}
	
	@Then("^Click on 'Update Billing Info' button$")
	public void click_on_Update_Billing_Info_button() throws Throwable {
		webelement=driver.findElement(PaymentInfoPage.updateBillingBtn);
		webelement.click();
	}
	
	@And("^Click on 'OK' button$")
	public void click_on_OK_button() throws Throwable {
	   webelement=TestUtil.presenceOfElementWait(PaymentInfoPage.okbtn);
	   webelement.click();
	}
	
	@And("^Verify plan 'Change to Monthly'$")
	public void verify_plan_Change_to_Monthly() throws Throwable {
		webelement=driver.findElement(By.xpath("(//b[@class='m-gray'])[2]"));
		String resultObtain=webelement.getText();
		System.out.println(resultObtain);
		assertThat(resultObtain, containsString("month"));
		System.out.println(" plan 'Changes to Monthly'");
	}
}
