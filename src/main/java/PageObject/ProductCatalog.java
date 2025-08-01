package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	//driver.findElement(By.cssSelector(".ng-animating"))
	
	@FindBy(css=".mb-3")
	List<WebElement> productList;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By products=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toast=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		visibilityElementAppear(products);
		return productList;
		
	}
	
	public WebElement getProductByName(String productName) {
	
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		visibilityElementAppear(toast);
		invisibiltyElement(spinner);
		
	}
	
}
