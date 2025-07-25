package SeleniumWeb;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.ConformationPage;
import PageObject.LandingPage;
import PageObject.ProductCatalog;
import TestComponent.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"ErrorValidation"},retryAnalyzer=TestComponent.Retry.class)
	public void loginErrorValidation() throws IOException {

		

		landingPage.logingApplication("soumyaadhikary2018@gmail.com", "Soumya23@");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
	
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";

		ProductCatalog productCatalog = landingPage.logingApplication("soumyaadhikary23@gmail.com", "Soumya123@");

		productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartpage = productCatalog.goToCartPage();

		Boolean match = cartpage.verifyCartproduct(productName);
		Assert.assertTrue(match);
		
	}

}
