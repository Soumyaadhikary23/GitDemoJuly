package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElement(By.xpath("//input[@placeholder='Select Country']"
	//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]
	//driver.findElement(By.cssSelector(".action__submit"))
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By countryList=By.cssSelector(".ta-results");
	
	
	public  void selectcountry(String CountryName) {
		
		Actions a=new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		visibilityElementAppear(countryList);
		selectCountry.click();
		
		
	}
	
	public ConformationPage submitOrder() throws InterruptedException
	{	Thread.sleep(2000);
		scrolluptoEnd();
		submit.click();
		ConformationPage conformPage=new ConformationPage(driver);
		return conformPage;
		
	}
	
}
