package StepDefination;
import java.io.IOException;

	import org.testng.Assert;

	import PageObject.LandingPage;
	import TestComponent.BaseTest;
	import io.cucumber.java.en.*;

	public class StepDefinationErrorValidation extends BaseTest {

	    public LandingPage landingPage;

	    @Given("I landed on Ecommece site")
	    public void i_landed_on_ecommece_site() throws IOException {
	        landingPage = applicationLunch(); // initializes driver & opens site
	    }

	    @When("^Login with the username (.+) and password (.+)$")
	    public void login_with_the_username_and_password(String username, String password) {
	        landingPage.logingApplication(username, password); // attempt login
	    }

	    @Then("{expectedMessage} message displayed")
	    public void error_message_displayed(String expectedMessage) {
	        String actualMessage = landingPage.getErrorMessage();
	        Assert.assertEquals(actualMessage, expectedMessage);
	    }
	}



