package dhanunjaitech.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import dhanunjaitech.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage ;

	// properties  class can read the Global class
	
	public WebDriver intializeDriver() throws IOException
	
	{
		

		// properties  class can read the Global class
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\gandr\\eclipse-workspace\\SeleniumFrameWorkDesign\\src\\main\\java\\dhanunjaitech\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName =		System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
//	prop.getProperty("browser");
	if (browserName.contains("chrome"))
	{
	ChromeOptions options = new ChromeOptions();
	WebDriverManager.chromedriver().setup();
	
	if(browserName.contains("headless"))
	{
		options.addArguments("headless");
	}
		 driver = new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1440,900));  //browserName.help to run in full screen
	
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		//firefox
		
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver","edge.exe");
		driver = new EdgeDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(18));  //sink issues
	driver.manage().window().maximize();
	return driver;
	}
	
	public String getScreenshot( String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot  ts = (TakesScreenshot)driver;
		File source  = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+ testCaseName +".png";
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage LuanchApplication() throws IOException
	{
		driver = intializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod(alwaysRun = true)
	public void teardown()
	{
		 driver.close();
	}
	

}
