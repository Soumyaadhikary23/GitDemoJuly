package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.CartPage;
import PageObject.OrderHistory;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartClick;
	
	@FindBy(css="button[routerlink*='/dashboard/myorders']")
	WebElement orderHistoryClick;

	
	public void visibilityElementAppear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void visibilityWebElementAppear(WebElement findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public CartPage goToCartPage() {
		cartClick.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
		
	}
	
	public void invisibiltyElement(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
	}
	
	
	public void scrolluptoEnd() throws InterruptedException {
		long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

		while (true) {
		    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    // Wait for new content to load
		    Thread.sleep(2000);

		    long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		    if (newHeight == lastHeight) {
		        break; // Reached the bottom
		    }
		    lastHeight = newHeight;
		}
	}
	
	public OrderHistory gotoOrderHistoryPage() throws InterruptedException {
		
		orderHistoryClick.click();
		OrderHistory orderHistory= new OrderHistory(driver);
		return orderHistory;
		
	}
	

}
