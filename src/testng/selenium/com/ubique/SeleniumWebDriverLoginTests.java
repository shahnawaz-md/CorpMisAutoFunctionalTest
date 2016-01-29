package testng.selenium.com.ubique;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeleniumWebDriverLoginTests extends SeleniumWebDriverTests{


	
	protected String userName="admin";	
	protected String password="password";  


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass (alwaysRun=true)
	public void setUp() throws Exception {
		startTime=java.lang.System.currentTimeMillis();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shahnawaz\\Desktop\\chromedriver.exe");
		 webDriver = new ChromeDriver(); 
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		webDriver.get(baseUrl);	
		webDriver.manage().window().maximize();
		
		login();
	}

	
	public void login(){
		webDriver.get(baseUrl+"login");

		webDriver.findElement(By.id("loginId")).clear();
		webDriver.findElement(By.id("loginId")).sendKeys(userName);
		webDriver.findElement(By.id("password")).clear();
		webDriver.findElement(By.id("password")).sendKeys(password);
		webDriver.findElement(By.id("loginSubmit")).click();

	}
	

	public void logout(){
		webDriver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

	/**
	 * @throws java.lang.Exception
	 */
	public void withOutDataHitStoreButton() {
		// Hitting the store button with out any data
		// Store Button
		WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
	 	JavascriptExecutor executor = (JavascriptExecutor)webDriver;
	 	executor.executeScript("arguments[0].click();", element);
	 	
		// To validate if the field is blank then there should be an alert
		// display on screen
		if (webDriver.getPageSource().contains("This field is required.")) {
			System.out.println("Error messages are showing on screen ");
		} else {
			System.out.println("There is no error message");
		}
	}	
	@AfterClass (alwaysRun=true)
	public void tearDown() throws Exception {
		logout();
		webDriver.close();
		webDriver.quit();
		
		System.out.println("Test ["+this.currentTestMethod+"] finished[Execution Time:"+(java.lang.System.currentTimeMillis()-startTime) +"ms].\n");
		testModels.clear();
	}

	
	
	
}

