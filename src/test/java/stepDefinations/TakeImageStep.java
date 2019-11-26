package stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.healthPro.base.SetupClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class TakeImageStep extends SetupClass{
	@After()
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");

		}
	}
}
