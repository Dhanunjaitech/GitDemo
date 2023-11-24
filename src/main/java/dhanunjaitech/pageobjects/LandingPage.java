package dhanunjaitech.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dhanunjaitech.AbstractComponents.AbstractComponent;

public class LandingPage extends  AbstractComponent{
	
	WebDriver driver;
	 public LandingPage(WebDriver driver)
	 {
		 super(driver);
		 //initialization driver
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
	//WebElement usermail =  driver.findElement(By.id("userEmail"));
	//pageFactory
	@FindBy(id="userEmail")
	WebElement usermail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	@FindBy(css="[type='submit']")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public productCatalog loginApplication(String email,String password) 
	{
		usermail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		productCatalog productcatlouge = new productCatalog(driver);
		return productcatlouge;
		
	}
	public String  getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	
}
