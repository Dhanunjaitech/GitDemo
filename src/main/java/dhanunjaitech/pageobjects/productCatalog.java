package dhanunjaitech.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dhanunjaitech.AbstractComponents.AbstractComponent;

public class productCatalog  extends AbstractComponent{
	
	WebDriver driver;
	 public productCatalog(WebDriver driver)
	 {
		 //initialization driver
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
	 
	@FindBy(css=".mb-3")
	List<WebElement> products ;
	@FindBy(css=".ng-animating")
     WebElement Spinner;
	
	By prodctsBy = By.cssSelector(".mb-3");
	By addtocart =By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(prodctsBy);
		return products;
	}
	
	public WebElement getProdudcByName(String Productname)
	{
		
		WebElement prod = getProductList().stream().filter(product->
			product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		return prod;
	}
	public void addToProductToCart( String Productname) throws InterruptedException
	
	{
		 WebElement prod = getProdudcByName(Productname);
		prod.findElement(addtocart).click();
		waitForElementToAppear(toastmessage);
		waitForElementDissaper(Spinner);
	}
	 
}
