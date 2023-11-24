 package dhanunjaitech.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import dhanunjaitech.TestComponents.BaseTest;
import dhanunjaitech.pageobjects.CheckOutPage;
import dhanunjaitech.pageobjects.ConfirmationPage;
import dhanunjaitech.pageobjects.LandingPage;
import dhanunjaitech.pageobjects.OrderPage;
import dhanunjaitech.pageobjects.cartPage;
import dhanunjaitech.pageobjects.productCatalog;

public class SubmitOrderTest extends BaseTest{
	String Productname ="ZARA COAT 3";
	
	
	@Test(dataProvider="getdata",groups="Purchase")
	public void submitOrder(HashMap<String,String> input)throws IOException, InterruptedException
	{
		
		LandingPage landingpage = LuanchApplication();		
		productCatalog productcatlouge=	landingpage.loginApplication(input.get("email"),input.get("password"));
		
	 List<WebElement>products=	productcatlouge.getProductList();
	 productcatlouge.addToProductToCart(input.get("product"));
	cartPage CartPage = productcatlouge.goToCartPage();
	 
	Boolean match  =  CartPage.VerifyProductDisplay(input.get("product"));
	Assert.assertTrue(match);
	CheckOutPage checkoutpage = CartPage.goToCheckout();
	checkoutpage.selectCountry("india");
	ConfirmationPage  conformationopage = checkoutpage.submitOrder();
	String conformationmsg  = conformationopage.getConfirmationMessage();
	 AssertJUnit.assertTrue(conformationmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	 
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		//"ZARA COAT 3"
		productCatalog productcatlouge=	landingpage.loginApplication("dhanunjai@gmail.com","Dhanunjai@013");
	OrderPage orderPage = productcatlouge.goToOrdersPage();
	Assert.assertTrue(orderPage.VerifyOrderDisplay(Productname));
	}
	
	
	
	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email","dhanunjai@gmail.com");
		map.put("password","Dhanunjai@013");
		map.put("product","ZARA COAT 3"); 
		
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email","dhanunjai123@gmail.com");
		map1.put("password","Dhanunjai@013");
		map1.put("product","ADIDAS ORIGINAL");
		
		 return  new Object[][]{{map}, {map1}};
		//"shetty@gmail.com,"Iamking@000","ADIDAS ORIGINAL"
		 
		 /*1stmethod
		   @DataProvider
	public Object[][] getdata()
	{
	return  new Object[][]{"dhanunjai@gmail.com","Dhanunjai@013","ZARA COAT 3"}, {"dhanunjai123@gmail.com","Dhanunjai@013","ADIDAS ORIGINAL"}};
	{
		  */
		 
		 
	}
	
	
	
	
		
		
		
		

	}


