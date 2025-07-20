package SeleniumWeb;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.ConformationPage;
import PageObject.LandingPage;
import PageObject.ProductCatalog;
import TestComponent.BaseTest;

public class SubmitOrder extends BaseTest {
	
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void sumbmitOrder(HashMap<String,String>input ) throws IOException, InterruptedException {

	
		
		ProductCatalog productCatalog = landingPage.logingApplication(input.get("email"), input.get("password"));

		productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("productName"));
		CartPage cartpage = productCatalog.goToCartPage();

		Boolean match = cartpage.verifyCartproduct(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkout = cartpage.checkOut();

		checkout.selectcountry("India");
		ConformationPage conformpage = checkout.submitOrder();
		Assert.assertTrue(conformpage.confirmMessage().equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "sumbmitOrder" })
	public void orderHistoryTest() throws InterruptedException {
	

		ProductCatalog productCatalog = landingPage.logingApplication("soumyaadhikary2018@gmail.com", "Soumya123@");
		PageObject.OrderHistory orderHistory = productCatalog.gotoOrderHistoryPage();
		Assert.assertTrue(orderHistory.verifyOrderproduct(productName));
		

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		
		/*
		 * HashMap<String,String> map= new HashMap<String,String>(); map.put("email",
		 * "soumyaadhikary2018@gmail.com"); map.put("password", "Soumya123@");
		 * map.put("productName", "ZARA COAT 3");
		 * 
		 * HashMap<String,String> map1= new HashMap<String,String>(); map1.put("email",
		 * "soumyaadhikary23@gmail.com"); map1.put("password", "Soumya123@");
		 * map1.put("productName", "ADIDAS ORIGINAL");
		 */
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)} };
	}
	
	

}
