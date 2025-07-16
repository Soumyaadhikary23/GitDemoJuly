package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponent.AbstractComponent;

public class ConformationPage extends AbstractComponent {
	WebDriver driver;
	
	public ConformationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
	
	
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	
	
	public String confirmMessage() {
		return confirmMessage.getText();
	}
	
}
