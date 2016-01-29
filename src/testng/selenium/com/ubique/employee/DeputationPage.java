package testng.selenium.com.ubique.employee;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import org.testng.Assert;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class DeputationPage extends SeleniumWebDriverLoginTests{
	
	private WebDriver webDriver;

	public DeputationPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeDeputation() throws InterruptedException{
		
				
	    //Deputation Tab
	    webDriver.findElement(By.xpath("//a[@title='Deputation']")).click();
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
		// button
		Thread.sleep(TIMEOUT);
		withOutDataHitStoreButton();
		
		//Auto-Complete For Employee
		WebElement employee=webDriver.findElement(By.id("actionbean.deputation.employee.id.AutoCompleter"));
		employee.sendKeys("first");
		Thread.sleep(5000);
		employee.sendKeys(Keys.DOWN);
		employee.sendKeys(Keys.ENTER);
		
		//Auto-Complete for Company
 		webDriver.findElement(By.id("actionbean.deputation.companyId.AutoCompleter")).sendKeys("com");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.deputation.companyId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.deputation.companyId.AutoCompleter")).sendKeys(Keys.ENTER);
 				
 		//Auto-Complete for Office
 		webDriver.findElement(By.id("actionbean.deputation.officeId.AutoCompleter")).sendKeys("com");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.deputation.officeId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.deputation.officeId.AutoCompleter")).sendKeys(Keys.ENTER);
 		
 		//From
	    webDriver.findElement(By.name("actionbean.deputation.fromThruDate.fromDate")).click();
	
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
	
	
		//To
		webDriver.findElement(By.name("actionbean.deputation.fromThruDate.thruDate")).click();
		
			//For Year
		 	WebElement y = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
		 	Select selectY = new Select(y);
		 	selectY.selectByValue("2006");
		  	 			 		
			Thread.sleep(5000);
			                                                   
			//For Month
			WebElement m = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
			Select selectM = new Select(m);
			selectM.selectByValue("2");
			webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[5]/a")).click();
	 	
			Thread.sleep(5000);
			
		//Notes
		WebElement not=webDriver.findElement(By.id("StoreForm-Deputation_actionbean_deputation_notes"));
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
	}
public void PageTitle(){
		
		String actualPageTitle = webDriver.getTitle();
		String expectedPageTitle = "Corp MIS - User - Home";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);{
			System.out.println("we are in the Deputation page");
		}
	}


}
