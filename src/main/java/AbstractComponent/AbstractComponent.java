package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.CartPage;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartClick;

	
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
	
	public void invisibiltyElement(WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	

}
