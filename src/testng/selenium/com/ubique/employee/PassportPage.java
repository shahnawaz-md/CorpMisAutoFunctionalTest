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


public class PassportPage extends SeleniumWebDriverLoginTests{
	
	private String passportNo="P" + number;
	
	public WebDriver webDriver;
	
	Random random = new Random();

	public PassportPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storePassport() throws InterruptedException{
		
	    //Passport Tab
	    webDriver.findElement(By.xpath("//a[@title='Passport']")).click();
	
	    Thread.sleep(5000);
	    
	    PageTitle();
	    
	 // Adding delay to wait for certain amount of time then hitting the save
	 			// button
	 			Thread.sleep(TIMEOUT);
	 			withOutDataHitStoreButton();
	
	    //Employee
	    WebElement emp=webDriver.findElement(By.id("actionbean.passport.employee.id.AutoCompleter"));
	    emp.clear();
	    emp.sendKeys("first");
	    Thread.sleep(5000);
	    emp.sendKeys(Keys.DOWN);
	    emp.sendKeys(Keys.ENTER);
	
	    //Passport Number
	    WebElement passNo=webDriver.findElement(By.id("StoreForm-Passport_actionbean_passport_passportNumber"));
	    passNo.clear();
	    passNo.sendKeys(passportNo);
	    
	 // validating the field length for the company text box
	 		String flengthPassportNumber = webDriver.findElement(
	 				By.id("StoreForm-Passport_actionbean_passport_passportNumber"))
	 				.getAttribute("maxlength");
	 		String dataPassportNumber = "data"+random;
	 		if(dataPassportNumber.length()<Integer.parseInt(flengthPassportNumber)){
	 			System.out.println("The entered data is less then field length(Passport Number)");
	 		} else {
	 			System.out.println("the entered data is more then field length(Passport Number)");
	 		}
	 		
	 Thread.sleep(TIMEOUT);
	    
	
	    //Place Of Issue
	    WebElement place=webDriver.findElement(By.id("StoreForm-Passport_actionbean_passport_placeOfIssue"));
	    place.clear();
	    place.sendKeys("kolkata");
	
	    //Date Of Issue
	    webDriver.findElement(By.name("actionbean.passport.dateOfIssue")).click();
	
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
	
	
		//Date Of Expiry
		webDriver.findElement(By.name("actionbean.passport.dateOfExpiry")).click();
		
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
			
		//Notes
		WebElement not=webDriver.findElement(By.id("StoreForm-Passport_actionbean_passport_notes"));
		not.clear();
		not.sendKeys("Test Test Test Test");
	
		//Store Button
		WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
		JavascriptExecutor executor = (JavascriptExecutor)webDriver;
		executor.executeScript("arguments[0].click();", element);
 		 	
		Thread.sleep(TIMEOUT);
	
		Alert alert = webDriver.switchTo().alert();
		alert.accept();
		
		String strng = webDriver.findElement(By.xpath(".//*[@id='actionMsg']/ul/li")).getText();
		Assert.assertEquals("STORE Operation executed successfully.", strng);
 	
		Thread.sleep(TIMEOUT);
		Thread.sleep(TIMEOUT);
				
	}
public void PageTitle(){
		
		String actualPageTitle = webDriver.getTitle();
		String expectedPageTitle = "Corp MIS - User - Home";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);{
			System.out.println("we are in the Passport page");
		}
	}
	

}
