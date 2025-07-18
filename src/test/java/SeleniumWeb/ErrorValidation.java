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

import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.ConformationPage;
import PageObject.LandingPage;
import PageObject.ProductCatalog;
import TestComponent.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test
	public void sumbmitOrder() throws IOException {

		

		landingPage.logingApplication("soumyaadhikary2018@gmail.com", "Soumya23@");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}

}
