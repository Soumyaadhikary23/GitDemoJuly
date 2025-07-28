package StepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.ConformationPage;
import PageObject.LandingPage;
import PageObject.ProductCatalog;
import TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationIMPL extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public CheckOutPage checkout;
	public ConformationPage conformpage;
	
		
	@Given("I land on Ecomerce page")
	public void I_land_on_Ecomerce_page() throws IOException {
	    landingPage = applicationLunch(); // use correct variable
	}

	@Given("^Login with the username (.+) and password (.+)$")
	public void Login_with_the_username_and_password(String name, String password) {
	    productCatalog = landingPage.logingApplication(name, password); // also correct
	}

	
	 @When ("^I add the product (.+) to cart$")
	 public void I_add_the_product_to_cart(String productName) throws InterruptedException {
		 productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
	 }
	 
	 @When("^checkout (.+) and submit the order$")
	 public void checkout_and_submit_the_order(String productName) throws InterruptedException {
		 CartPage cartpage = productCatalog.goToCartPage();

			Boolean match = cartpage.verifyCartproduct(productName);
			Assert.assertTrue(match);
			checkout = cartpage.checkOut();

			checkout.selectcountry("India");
			conformpage = checkout.submitOrder();
	 }
	 
	 @Then("{string} message displayed on conformation page")
	 public void message_displayed_on_conformation_page(String string ) {
		 Assert.assertTrue(conformpage.confirmMessage().equalsIgnoreCase(string));
		 driver.close();
	 }
	 
	
	 
	 @Then("{string} message displayed")
	 public void error_message_displayed(String message) {
	     String actualMessage = landingPage.getErrorMessage();
	     Assert.assertEquals(actualMessage, message);
	     driver.close();
	 }


}
