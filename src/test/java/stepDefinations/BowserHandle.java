package stepDefinations;

import com.healthPro.base.SetupClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class BowserHandle extends SetupClass{
	@Given("^Launch the browser$")
	public void Launch_the_browser() throws Throwable {
		before_Class();
	}

	@And("^close the broswer$")
	public void close_the_broswer() throws Throwable {
		after_Class();
	}
}
