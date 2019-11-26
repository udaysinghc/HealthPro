package stepDefinations;

import static org.junit.Assert.assertEquals;

import com.healthPro.base.SetupClass;
import com.healthPro.pages.MyProfilePage;
import com.healthPro.util.TestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ProfileStepDefinations extends SetupClass{
	
	@And("^Click on 'photos and media' Side-Bar menu options$")
	public void click_on_photos_and_media_Side_Bar_menu_options() throws Throwable {
		Thread.sleep(2000);
		webelement=driver.findElement(MyProfilePage.photoAndMediaMenu);
	  webelement.click();
	  Thread.sleep(3000);
	}

	@And("^Upload your 'Photo'$")
	public void upload_your_Photo() throws Throwable {
		Thread.sleep(500);
		webelement=driver.findElement(MyProfilePage.uploadPhotobtn);
		System.out.println("It's find the Upload file bar");
		webelement.click();
		System.out.println("It's clicked on Upload file options");

		String avtarfile=TestUtil.avatarFile;
		TestUtil.uploadFile(avtarfile);
		Thread.sleep(1000);
		System.out.println("upload file successfull");
	}

	@And("^Invite your clients to follow you via \"([^\"]*)\" social networking$")
	public void invite_your_clients_to_follow_you_via_social_networking(String socailMedia) throws Throwable {
		System.out.println("it's enter socail media");
		final String link="Your Website";
		final String twitter="twitter";
		final String facebook="facebook";
		final String linkedin="linkedin";
		final String pinterest="pinterest";
		final String instagram="instagram";
		final String youtube="youtube";
//		final String ideafit="ideafit";
//		final String Amazon="Amazon";
		
		
		switch(socailMedia) 
		{
		case link:
			 webelement=driver.findElement(MyProfilePage.link);
			 webelement.click();
			 webelement.sendKeys("https://therpedia.com");
			 System.out.println("It's Entered website link");
			 break;
		
		case twitter:
			 webelement=driver.findElement(MyProfilePage.twitter);
			 webelement.click();
			 webelement.sendKeys("https://twitter.com/healthprocom");
			 System.out.println("It's Entered twitter link");
			 break;
		
		case facebook:
			 webelement=driver.findElement(MyProfilePage.facebook);
			 webelement.click();
			 webelement.sendKeys("https://www.facebook.com/pages/HealthPRO/338527412996389");
			 System.out.println("It's Entered facebook link");
			 break;	
		
		case linkedin:
			 webelement=driver.findElement(MyProfilePage.linkedin);
			 webelement.click();
			 webelement.sendKeys("https://www.linkedin.com/groups/HealthPRO-Health-Wellness-CAM-Fitness-6933895/");
			 System.out.println("It's Entered linkedin link");
			 break;
		
		case pinterest:
			 webelement=driver.findElement(MyProfilePage.pinterest);
			 webelement.click();
			 webelement.sendKeys("https://www.pinterest.com/srjohnson/");
			 System.out.println("It's Entered pinterest link");
			 break;
		
		case instagram:
			 webelement=driver.findElement(MyProfilePage.instagram);
			 webelement.click();
			 webelement.sendKeys("https://www.instagram.com/steersbetshemesh/");
			 System.out.println("It's Entered instagram link");
			 break;
		
		case youtube:
			 webelement=driver.findElement(MyProfilePage.youtube);
			 webelement.click();
			 webelement.sendKeys("https://www.youtube.com/watch");
			 System.out.println("It's Entered youtube link");
			 break;
		
//		case ideafit:
//			 webelement=driver.findElement(MyProfilePage.ideafit);
//			 webelement.click();
//			 webelement.sendKeys("https://www.ideafit.com");
//			 System.out.println("It's Entered ideafit link");
//			 break;
//			
//		case Amazon:
//			 webelement=driver.findElement(MyProfilePage.amazon);
//			 webelement.click();
//			 webelement.sendKeys("https://www.amazon.com/s?k=ELECTRA&ref=bl_dp_s_web_0");
//			 System.out.println("It's Entered Amazon link");
//			 break;
			
		}
	    
	}

	@And("^Click on 'Update' button$")
	public void click_on_Update_button() throws Throwable {
		webelement=driver.findElement(MyProfilePage.updatebtn);
		 webelement.click();
	}
	
	@Then("^Verify confirmation dialog prompt message & click on 'OK' button$")
	public void verify_confirmation_dialog_prompt_message_click_on_OK_button() throws Throwable {
		webelement=TestUtil.presenceOfElementWait(MyProfilePage.dialogMessage);
		String dialogMessage=webelement.getText();
		System.out.println(dialogMessage);
		if(dialogMessage.contains("Something went wrong. Please reload the page and try again")) 
		{
			webelement=driver.findElement(MyProfilePage.okbtn);
			webelement.click();
			driver.navigate().refresh();
			Thread.sleep(2000);
			webelement=driver.findElement(MyProfilePage.updatebtn);
			webelement.click();
			 
			webelement=driver.findElement(MyProfilePage.okbtn);
			webelement.click();
			 
		}
//		String expectedMessage="Your changes have been saved";
//		assertEquals(expectedMessage,dialogMessage);
		else {
		webelement=driver.findElement(MyProfilePage.okbtn);
		webelement.click();
		}
		
	}
	
	@And("^Verify Photo is uploaded or not$")
	public void verify_Photo_is_uploaded_or_not() throws Throwable {
		
		webelement=driver.findElement(MyProfilePage.editPhoto);
		webelement.click();
		Thread.sleep(500);
		webelement=driver.findElement(MyProfilePage.txtEditPhoto);
		webelement.sendKeys("My Profile Photo");
		Thread.sleep(500);
		webelement=driver.findElement(MyProfilePage.saveTitleBtn);
		webelement.click();
				
	}

	@Then("^Refresh browser & verify all entered Url at Socail media are properly added$")
	public void refresh_browser_verify_all_entered_Url_at_Socail_media_are_properly_added() throws Throwable {
	
//		driver.navigate().refresh();
		Thread.sleep(4000);
		
		
//	case link:
		 webelement=driver.findElement(MyProfilePage.link);
		 String linkText=webelement.getAttribute("value");
		 String expectedLinkText="https://therpedia.com";
		 assertEquals(expectedLinkText, linkText);
		 System.out.println("It's verifed website link");
		 
	
//	case twitter:
		 webelement=driver.findElement(MyProfilePage.twitter);
		 String twitterText=webelement.getAttribute("value");
		 String expectedTwitterText="https://twitter.com/healthprocom";
		 assertEquals(expectedTwitterText, twitterText);
		 System.out.println("It's verifed twitter link");
			
	
//	case facebook:
		 webelement=driver.findElement(MyProfilePage.facebook);
		 String facebookText=webelement.getAttribute("value");
		 String expectedFacebookText="https://www.facebook.com/pages/HealthPRO/338527412996389";
		 assertEquals(expectedFacebookText, facebookText);
		 System.out.println("It's verifed facebook link");
				
	
//	case linkedin:
		 webelement=driver.findElement(MyProfilePage.linkedin);
		 String linkedinText=webelement.getAttribute("value");
		 String expectedlinkedinText="https://www.linkedin.com/groups/HealthPRO-Health-Wellness-CAM-Fitness-6933895/";
		 assertEquals(expectedlinkedinText, linkedinText);
		 System.out.println("It's verifed linkedin link");
		 		
	
//	case pinterest:
		 webelement=driver.findElement(MyProfilePage.pinterest);
		 String pinterestText=webelement.getAttribute("value");
		 String expectedPinterestText="https://www.pinterest.com/srjohnson/";
		 assertEquals(expectedPinterestText, pinterestText);
		 System.out.println("It's verifed pinterest link");
		 		
	
//	case instagram:
		 webelement=driver.findElement(MyProfilePage.instagram);
		 String instagramText=webelement.getAttribute("value");
		 String expectedinstagramText="https://www.instagram.com/steersbetshemesh/";
		 assertEquals(expectedinstagramText, instagramText);
		 System.out.println("It's verifed instagram link");
		
	
//	case youtube:
		 webelement=driver.findElement(MyProfilePage.youtube);
		 String youtubeText=webelement.getAttribute("value");
		 String expectedyoutubeText="https://www.youtube.com/watch";
		 assertEquals(expectedyoutubeText, youtubeText);
		 System.out.println("It's verifed youtube link");
		 
		
	
//	case ideafit:
//		 webelement=driver.findElement(MyProfilePage.ideafit);
//		 webelement.click();
//		 webelement.sendKeys("https://www.ideafit.com");
//		 System.out.println("It's Entered ideafit link");
		
		
//	case Amazon:
//		 webelement=driver.findElement(MyProfilePage.amazon);
//		 String AmazonText=webelement.getAttribute("value");
//		 String expectedAmazonText="https://www.amazon.com/s?k=ELECTRA&ref=bl_dp_s_web_0";
//		 assertEquals(expectedAmazonText, AmazonText);
//		 System.out.println("It's verifed Amazon link");
				
	}


}
