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

public class InsurancePage extends SeleniumWebDriverLoginTests{
	
	private String insuranceNo="I" + number;
	
	public WebDriver webdriver;
	
	Random random = new Random();

	public InsurancePage(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public void storeInsurance() throws InterruptedException{
		
		//Insurance Tab
		webDriver.findElement(By.xpath("//a[@title='Insurance']")).click();
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
		// button
		Thread.sleep(TIMEOUT);
		withOutDataHitStoreButton();
		
		//Auto-Complete For Employee
		WebElement emp=webDriver.findElement(By.id("actionbean.insurance.employee.id.AutoCompleter"));
		emp.sendKeys("first");
		Thread.sleep(5000);
		emp.sendKeys(Keys.DOWN);
		emp.sendKeys(Keys.ENTER);
		
		//Insurance Type
		WebElement insurance = webDriver.findElement(By.name("actionbean.insurance.type"));
 		Select sellectInsuranceType = new Select(insurance);
 		sellectInsuranceType.selectByVisibleText("Medical Insurance");
 		
 		//Insurance Name
 		WebElement name=webdriver.findElement(By.id("StoreForm-Insurance_actionbean_insurance_name"));
 		name.clear();
 		name.sendKeys("Medical Insurance");
 		
 		//Insurance Number
 		WebElement no=webdriver.findElement(By.id("StoreForm-Insurance_actionbean_insurance_insuranceNo"));
 		no.clear();
 		no.sendKeys(insuranceNo);
 		
 	// validating the field length for the company text box
 	 		String flengthInsuranceNumber = webDriver.findElement(
 	 				By.id("StoreForm-Insurance_actionbean_insurance_insuranceNo"))
 	 				.getAttribute("maxlength");
 	 		String dataInsuranceNumber = "data"+random;
 	 		if(dataInsuranceNumber.length()<Integer.parseInt(flengthInsuranceNumber)){
 	 			System.out.println("The entered data is less then field length(Insurance Number)");
 	 		} else {
 	 			System.out.println("the entered data is more then field length(Insurance Number)");
 	 		}
 	 		
 	 Thread.sleep(TIMEOUT);
 		
 		//Insurance Amount
 		WebElement amount=webdriver.findElement(By.id("StoreForm-Insurance_actionbean_insurance_amount"));
 		amount.clear();
 		amount.sendKeys("100000");
 		
 		//Valid From
 		webDriver.findElement(By.name("actionbean.insurance.fromThruDate.fromDate")).click();
	 	
   			//For Year
  	 		WebElement year = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
  	 		Select selectYear = new Select(year);
  	 		selectYear.selectByValue("2014");
		  	 			 		
  	 		Thread.sleep(5000);
 		
  	 		//For Month
  	 		WebElement month = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
  	 		Select selectMonth = new Select(month);
  	 		selectMonth.selectByValue("3");
  	 		webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
	 	
  	 		Thread.sleep(5000);
		
  	 	//Valid To
  	 	webDriver.findElement(By.name("actionbean.insurance.fromThruDate.thruDate")).click();
  		 	
   			//For Year
  	 		WebElement y = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
  	 		Select selectY = new Select(y);
  	 		selectY.selectByValue("2020");
		  	 			 		
  	 		Thread.sleep(5000);
 		
  	 		//For Month
  	 		WebElement m = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
  	 		Select selectM = new Select(m);
  	 		selectM.selectByValue("3");
  	 		webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
	 	
  	 		Thread.sleep(5000);
  	 		
  	 	//Notes
  		WebElement not=webDriver.findElement(By.id("StoreForm-Insurance_actionbean_insurance_info"));
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
			System.out.println("we are in the Insurance page");
		}
	}

}
