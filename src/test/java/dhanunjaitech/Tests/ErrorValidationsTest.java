 package dhanunjaitech.Tests;

import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import dhanunjaitech.TestComponents.BaseTest;
import dhanunjaitech.TestComponents.Retry;
import dhanunjaitech.pageobjects.LandingPage;
import dhanunjaitech.pageobjects.cartPage;
import dhanunjaitech.pageobjects.productCatalog;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups = {"EroorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation()throws IOException, InterruptedException
	{
		String Productname ="ZARA COAT 3";
				
		landingpage.loginApplication("dhanunjai@gmail.com","Dhanu@013");
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String Productname ="ZARA COAT 3";
		LandingPage landingpage = LuanchApplication();		
		productCatalog productcatlouge=	landingpage.loginApplication("dhanunjai@gmail.com","Dhanunjai@013");
		
	 List<WebElement>products=	productcatlouge.getProductList();
	 productcatlouge.addToProductToCart(Productname);
	cartPage CartPage = productcatlouge.goToCartPage(); 
	Boolean match  =  CartPage.VerifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);
	}
	 
	
	
	
	
		
		
		
		

	}


