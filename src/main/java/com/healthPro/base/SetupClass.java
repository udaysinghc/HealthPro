package com.healthPro.base;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.healthPro.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupClass {
	
	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String browserName ;
	public static String otpPassword;
	public static String mailId ,clientsMailId;
	public static Logger log;
	public static WebElement webelement;
	
	@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("src\\main\\java\\com\\healthPro\\config\\config.properties"));
		AppURL = property.getProperty("App_url");
		String browserName = property.getProperty("browser");
		
		
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.out.println("BrowserTest===== Chrome :" + AppURL);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			log.info("open browser chrome");
		
		}
		
		else if (browserName.equals("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			System.out.println("BrowserTest===== FireFox :" + AppURL);
			driver = new FirefoxDriver();	
			
		}
		else {

			System.out.println("platform does not provide");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		}
	
	
	@AfterClass
	public static void after_Class() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);	
	}
}
