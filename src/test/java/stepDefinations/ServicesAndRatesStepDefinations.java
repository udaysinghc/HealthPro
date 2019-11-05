package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.ServicesAndRatesPage;
import com.healthPro.pages.SignUpPage;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class ServicesAndRatesStepDefinations extends SetupClass{
	Actions ac=new Actions(driver);
	@And("^Click on 'Services & Rates' Side-Bar$")
	public void click_on_Services_Rates_Side_Bar() throws Throwable {
	   Thread.sleep(10000);
	   webelement=driver.findElement(ServicesAndRatesPage.services_RatesMenu);
	   webelement.click();
	}

	@Then("^Select 'Availability' Side-Bar Menu options$")
	public void select_Availability_Side_Bar_Menu_options() throws Throwable {
		webelement=driver.findElement(ServicesAndRatesPage.availabilityOptions);
		webelement.click();
	}
	
	@And("^Click on 'Add Location' button$")
	public void click_on_Add_Location_button() throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(ServicesAndRatesPage.addLocationbtn);
		ac.moveToElement(webelement).build().perform();
		webelement.click(); 
	}
	@And("^Click on 'New Interval' options$")
	public void click_on_New_Interval_options() throws Throwable {
		webelement=driver.findElement(ServicesAndRatesPage.newIntervalbtn);
		webelement.click();
	}

	@And("^Select availability form \"([^\"]*)\" To \"([^\"]*)\"$")
	public void select_availability_form_To(String arg1, String arg2) throws Throwable {
		webelement = driver.findElement(By.xpath("(//select[@name='from'])"));
		Select select=new Select(webelement);
		select.selectByVisibleText(arg1);
		Thread.sleep(500);
		
		webelement = driver.findElement(By.xpath("(//select[@name='until'])"));
		Select selectTo=new Select(webelement);
		selectTo.selectByVisibleText(arg2);
		Thread.sleep(500);
	}
	
	@And("^Select Day from 'New Interval' as \"([^\"]*)\"$")
	public void select_Day_from_New_Interval_as(String day) throws Throwable {
		webelement = driver.findElement(By.xpath("(//span[contains(text(),'"+day+"')])[2]"));
		webelement.click();		
		System.out.println("it's clicked on Day"); 
	}
	
	@And("^click on 'Save Location' button$")
	public void click_on_Save_Location_button() throws Throwable {
		
		webelement=driver.findElement(ServicesAndRatesPage.saveLocationbtn);
		webelement.click();
	   }
	
	@And("^Click on 'Sessions' Side-Bar Menu options$")
	public void click_on_Sessions_Side_Bar_Menu_options() throws Throwable {
	   Thread.sleep(3000);
		webelement=driver.findElement(ServicesAndRatesPage.sessionsOptions);
	    webelement.click();
	}

	@And("^Click on 'Add Session' button$")
	public void click_on_Add_Session_button() throws Throwable {
		Thread.sleep(2500);
		webelement=driver.findElement(ServicesAndRatesPage.addSessionsbtn);
		ac.moveToElement(webelement).build().perform();
		webelement.click(); 
	}

	@And("^Verify \"([^\"]*)\" div title text$")
	public void verify_div_title_text(String title) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(ServicesAndRatesPage.divPanelHeaderText);
		String resultObtain=webelement.getText();
		String expectedTitle=title;
		assertEquals(expectedTitle,resultObtain);
		System.out.println("div Title Text is verified");
	}
	
	@And("^Select \"([^\"]*)\" that you provide\\.$")
	public void select_that_you_provide(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("//span[contains(text(),'"+arg1+"')]"));
		webelement.click();
		System.out.println("it's selecting One Service");
	}

	@And("^Select \"([^\"]*)\" Where you provide above services$")
	public void select_Where_you_provide_above_services(String arg1) throws Throwable {
		webelement=driver.findElement(By.xpath("(//span[contains(text(),'"+arg1+"')])[1]"));
		webelement.click();
		System.out.println("it's location for Service");
	}
	
	@And("^Verify Name of \"([^\"]*)\" is saved or not$")
	public void verify_Name_of_is_saved_or_not(String location) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h3[contains(text(),'"+location+"')]"));
		String resultObtain=webelement.getText();
		String expectedTitle=location;
		assertEquals(expectedTitle,resultObtain);
		System.out.println("Name of Location is properly added");
	}

	@And("^Verify \"([^\"]*)\" is saved or not$")
	public void verify_is_saved_or_not(String address) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//p[contains(text(),'"+address+"')]"));
		String resultObtain=webelement.getText();
		resultObtain=resultObtain.replaceAll(".+-", "").trim();
		String expectedTitle=address;
		assertEquals(expectedTitle,resultObtain);
		System.out.println("address of Location is properly added");
	}
	
	@And("^Select availability form \"([^\"]*)\" To \"([^\"]*)\" from 'New Interval'$")
	public void select_availability_form_To_from_New_Interval(String arg1, String arg2) throws Throwable {
		webelement = driver.findElement(By.xpath("(//select[@name='from'])[2]"));
		ac.moveToElement(webelement).build().perform();
		Select select=new Select(webelement);
		select.selectByVisibleText(arg1);
		Thread.sleep(500);
		
		webelement = driver.findElement(By.xpath("(//select[@name='until'])[2]"));
		Select selectTo=new Select(webelement);
		selectTo.selectByVisibleText(arg2);
		Thread.sleep(500);
	}

	@And("^Select \"([^\"]*)\" location Type options$")
	public void select_location_Type_options(String type) throws Throwable {
		Thread.sleep(2500);
		webelement=TestUtil.presenceOfElementWait(By.xpath("//h3[contains(text(),'"+type+"')]"));
		webelement.click();
		Thread.sleep(1000);
	}
	
	@And("^Enter Meeting note & \"([^\"]*)\"$")
	public void enter_Meeting_note(String meetingDetails) throws Throwable {
		webelement = driver.findElement(ServicesAndRatesPage.meetingDetailsTxt);
		webelement.click();
		Thread.sleep(500);
		webelement.clear();
		webelement.sendKeys(meetingDetails);
		Thread.sleep(1000);
		webelement.sendKeys(Keys.ARROW_DOWN);
		System.out.println("it's Entered meeting Details");
		Thread.sleep(1000);
	}
	
	@And("^Verify \"([^\"]*)\" div is saved or not$")
	public void verify_div_is_saved_or_not(String Note) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(By.xpath("//div[contains(text(),'"+Note+"')]"));
		String resultObtain=webelement.getText();
		String expectedTitle=Note;
		assertEquals(expectedTitle,resultObtain);
		System.out.println("Meeting notes are properly added");
	}
	
	@And("^Click on 'Add New Session Rate' options$")
	public void click_on_Add_New_Session_Rate_options() throws Throwable {
		webelement=driver.findElement(ServicesAndRatesPage.addNewSessionRate);
		webelement.click();
	}

	@And("^Select 'New Session' duration as \"([^\"]*)\"$")
	public void select_New_Session_duration_as(String arg1) throws Throwable {
		webelement = driver.findElement(SignUpPage.newSessionDuration);
		Thread.sleep(500);
		Select select=new Select(webelement);
		select.selectByValue(arg1);
	}

	@And("^Enter 'New discounts' for New Session as \"([^\"]*)\"$")
	public void enter_New_discounts_for_New_Session_as(String discounts) throws Throwable {
		webelement = driver.findElement(SignUpPage.newSessionDiscounts);
		webelement.sendKeys(discounts);
		Thread.sleep(500);
	}

	@And("^click on 'Save Service' button$")
	public void click_on_Save_Service_button() throws Throwable {
		webelement=driver.findElement(ServicesAndRatesPage.saveServicebtn);
		webelement.click();
	}
	
	@And("^Verify \"([^\"]*)\" message appears$")
	public void verify_message_appears(String Note) throws Throwable {
		webelement=TestUtil.presenceOfElementWait(ServicesAndRatesPage.dailogMessage);
		Thread.sleep(1000);
		String resultObtain=webelement.getText();
		String expectedTitle=Note;
		assertEquals(expectedTitle,resultObtain);
		System.out.println("dailogMessage properly appears");
		Thread.sleep(500);
		
		webelement=driver.findElement(ServicesAndRatesPage.dailogBoxOkbtn);
		webelement.click();
	}
	@And("^Click on 'Classes' Side-Bar Menu options$")
	public void click_on_Classes_Side_Bar_Menu_options() throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(ServicesAndRatesPage.ClassesOptions);
		webelement.click();
	}

	@And("^Click on 'Add New Class' button$")
	public void click_on_Add_New_Class_button() throws Throwable {
		Thread.sleep(3000);
		webelement=driver.findElement(ServicesAndRatesPage.addNewClassbtn);
		webelement.click();
	}
	@And("^Click on 'Save Class' button$")
	public void click_on_Save_Class_button() throws Throwable {
		webelement=driver.findElement(ServicesAndRatesPage.saveClassbtn);
		webelement.click();
	}
	@And("^Select \"([^\"]*)\" Class Type$")
	public void select_Class_Type(String arg1) throws Throwable {
	    webelement=driver.findElement(By.xpath("//span[contains(text(),'"+arg1+"')]"));
	    webelement.click();
	    Thread.sleep(1000);
	}
	@And("^Select Single date from calendar$")
	public void select_Single_date_from_calendar() throws Throwable {
		 webelement=driver.findElement(ServicesAndRatesPage.singleDateFromCalenedar);
		    webelement.click();
		    Thread.sleep(1000);
		    webelement = driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[1]"));
			webelement.click();
	}
	@And("^Click on 'Packages' Side-Bar Menu options$")
	public void click_on_Packages_Side_Bar_Menu_options() throws Throwable {
		Thread.sleep(4000);
		webelement=driver.findElement(ServicesAndRatesPage.PackagesOptions);
		webelement.click();
	}

	@And("^Click on 'Add a Package' button$")
	public void click_on_Add_a_Package_button() throws Throwable {
		Thread.sleep(4000);
		webelement=driver.findElement(ServicesAndRatesPage.addNewPackagesbtn);
		webelement.click();
	}

	@And("^Enter \"([^\"]*)\" for Packages$")
	public void enter_for_Packages(String packagesTotalPrice) throws Throwable {
		webelement = driver.findElement(ServicesAndRatesPage.packagesTotalPrice);
		webelement.sendKeys(packagesTotalPrice);
		Thread.sleep(500);
	}
	@And("^Select \"([^\"]*)\" for this Packages$")
	public void select_for_this_Packages(String arg1) throws Throwable {
		webelement = driver.findElement(ServicesAndRatesPage.no_Of_Session);
		ac.moveToElement(webelement).build().perform();
		Thread.sleep(500);
		Select select=new Select(webelement);
		select.selectByValue(arg1);
	}

	@And("^Select \"([^\"]*)\" check box for which Packages is used$")
	public void select_check_box_for_which_Packages_is_used(String arg1) throws Throwable {
		webelement = driver.findElement(By.xpath("//span[@class='checkbox--i']//following::b[contains(text(),'"+arg1+"')]"));
		if(!webelement.isSelected()) 
		{
			webelement.click();
			System.out.println("it's selecting Services for packages");
		}
	}

	@Then("^Click on 'Save Package' button$")
	public void click_on_Save_Package_button() throws Throwable {
		webelement=driver.findElement(ServicesAndRatesPage.savePackagesbtn);
		webelement.click();
	}



}
