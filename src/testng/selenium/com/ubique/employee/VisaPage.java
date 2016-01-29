package testng.selenium.com.ubique.employee;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class VisaPage extends SeleniumWebDriverLoginTests{
	
	public WebDriver webDriver;
	
	Random random = new Random();

	public VisaPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeVisa() throws InterruptedException{
		

		//Visa Tab
		webDriver.findElement(By.xpath("//a[@title='Visa']")).click();
		
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
					// button
					Thread.sleep(TIMEOUT);
					withOutDataHitStoreButton();
		
		//Auto-Complete For Employee
		WebElement emp=webDriver.findElement(By.id("actionbean.visa.employee.id.AutoCompleter"));
		emp.sendKeys("first");
		Thread.sleep(5000);
		emp.sendKeys(Keys.DOWN);
		emp.sendKeys(Keys.ENTER);
		
		//Visa Type
	    WebElement v = webDriver.findElement(By.name("actionbean.visa.type"));
 		Select sellectVisaType = new Select(v);
 		sellectVisaType.selectByVisibleText("Visa1");
		
 		//Currency
 		WebElement cur = webDriver.findElement(By.id("StoreForm-Visa_actionbean_visa_country"));
 		Select sellectCurrency = new Select(cur);
 		sellectCurrency.selectByVisibleText("India");
 		
 		//Visa Number
 		WebElement num=webDriver.findElement(By.id("StoreForm-Visa_actionbean_visa_visaNo"));
 		num.clear();
 		num.sendKeys("98653210");
 		
 	// validating the field length for the company text box
 		String flengthVisaNumber = webDriver.findElement(
 				By.id("StoreForm-Visa_actionbean_visa_visaNo"))
 				.getAttribute("maxlength");
 		String dataVisaNumber = "data"+random;
 		if(dataVisaNumber.length()<Integer.parseInt(flengthVisaNumber)){
 			System.out.println("The entered data is less then field length(Visa Number)");
 		} else {
 			System.out.println("the entered data is more then field length(Visa Number)");
 		}
 		
 Thread.sleep(TIMEOUT);
 		
 		
 		//Valid From
	    webDriver.findElement(By.name("actionbean.visa.fromThruDate.fromDate")).click();
	
	    	//For Year
	 		WebElement year = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
	 		Select selectYear = new Select(year);
	 		selectYear.selectByValue("2004");
	  	 			 		
	 		Thread.sleep(5000);
														   
	 		//For Month
	 		WebElement month = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
	 		Select selectMonth = new Select(month);
	 		selectMonth.selectByValue("2");
	 		webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[3]/a")).click();
 	
	 		Thread.sleep(5000);
	
		//Valid To
		webDriver.findElement(By.name("actionbean.visa.fromThruDate.thruDate")).click();
		
			//For Year
		 	WebElement y = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
		 	Select selectY = new Select(y);
		 	selectY.selectByValue("2020");
		  	 			 		
			Thread.sleep(5000);
			                                                   
			//For Month
			WebElement m = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
			Select selectM = new Select(m);
			selectM.selectByValue("2");
			webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[3]/a")).click();
	 	
			Thread.sleep(5000);
			
		//Store Button
		WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
		JavascriptExecutor executor = (JavascriptExecutor)webDriver;
		executor.executeScript("arguments[0].click();", element);
		 		 	
		Thread.sleep(TIMEOUT);
			
		Alert alert = webDriver.switchTo().alert();
		alert.accept();
		 	
		Thread.sleep(TIMEOUT);
		Thread.sleep(TIMEOUT);
 		
	}
public void PageTitle(){
		
		String actualPageTitle = webDriver.getTitle();
		String expectedPageTitle = "Corp MIS - User - Home";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);{
			System.out.println("we are in the Visa page");
		}
	}
	

}
