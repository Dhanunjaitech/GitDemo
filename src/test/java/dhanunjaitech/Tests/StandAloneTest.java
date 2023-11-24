 package dhanunjaitech.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dhanunjaitech.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String userid="dhanunjai@gmail.com";
		String password="Dhanunjai@013";
		String Productname ="ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //sink issues
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingpage = new LandingPage(driver);
		//login into acc
		driver.findElement(By.id("userEmail")).sendKeys(userid);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	//add to cart the products
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
	WebElement prod = 	products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	//its will wait for the showing the cart conformation message
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//ng-animating
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	List <WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match =	cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(Productname));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	Actions a = new Actions (driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
	 driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	 driver.findElement(By.cssSelector(".action__submit")).click();
	 String conformationmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	 Assert.assertTrue(conformationmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	 driver.close();
	 
	 
	
	
	
	
		
		
		
		

	}

}
