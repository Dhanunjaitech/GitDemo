package dhanunjaitech.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import dhanunjaitech.TestComponents.BaseTest;
import dhanunjaitech.pageobjects.CheckOutPage;
import dhanunjaitech.pageobjects.ConfirmationPage;
import dhanunjaitech.pageobjects.LandingPage;
import dhanunjaitech.pageobjects.cartPage;
import dhanunjaitech.pageobjects.productCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	
	public LandingPage landingpage;
	public productCatalog productcatlouge;
	public ConfirmationPage  conformationopage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException 
	{
		landingpage = LuanchApplication();
	}
	
	
	@Given("^Logined in with username (.+) and password (.+)$")
	public void logined_in_username_and_password(String username,String password)
	{
		 productcatlouge = landingpage.loginApplication(username,password);
	}
	
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException
	{
		 List<WebElement>products=	productcatlouge.getProductList();
		 productcatlouge.addToProductToCart(productName);
	}
	
	@Given("^Checkout (.+) and submit the order$")
	public void Checkout_and_the_order(String productName)
	{
		cartPage CartPage = productcatlouge.goToCartPage();
		 
		Boolean match  =  CartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = CartPage.goToCheckout();
		checkoutpage.selectCountry("india");
		conformationopage = checkoutpage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConformatioPage")
	public void message_is_displayed_on_ConformationPage(String string)
	{
		String conformationmsg  = conformationopage.getConfirmationMessage();
		 Assert.assertTrue(conformationmsg.equalsIgnoreCase(string));
		 driver.close();
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string,landingpage.getErrorMessage());
		driver.close();
		
	}
	

}
