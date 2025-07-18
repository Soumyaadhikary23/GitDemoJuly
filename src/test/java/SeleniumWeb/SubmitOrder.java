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

public class SubmitOrder extends BaseTest {

	@Test
	public void sumbmitOrder() throws IOException {

		String productName = "ZARA COAT 3";

		ProductCatalog productCatalog = landingPage.logingApplication("soumyaadhikary2018@gmail.com", "Soumya123@");

		productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartpage = productCatalog.goToCartPage();

		Boolean match = cartpage.verifyCartproduct(productName);
		Assert.assertTrue(match);
		CheckOutPage checkout = cartpage.checkOut();

		checkout.selectcountry("India");
		ConformationPage conformpage = checkout.submitOrder();

		Assert.assertTrue(conformpage.confirmMessage().equalsIgnoreCase("Thankyou for the order."));
	}

}
