package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//driver.findElement(By.id("userPassword"))
	//driver.findElement(By.id("login"))
	////div[@aria-label='Incorrect email or password.']
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public ProductCatalog logingApplication(String email,String pwd)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalog productCatalog=new ProductCatalog(driver);
		return productCatalog;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public String getErrorMessage() {
		visibilityWebElementAppear(errorMessage);
		return errorMessage.getText();
	}

}
