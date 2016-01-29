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

public class EducationPage extends SeleniumWebDriverLoginTests {
	
	public WebDriver webDriver;
	
	Random random = new Random();

	public EducationPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeEducation() throws InterruptedException{
		
		//Education Tab
	    webDriver.findElement(By.xpath("//a[@title='Education']")).click();
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
				// button
				Thread.sleep(TIMEOUT);
				withOutDataHitStoreButton();
		
		//Auto-Complete For Employee
		WebElement employee=webDriver.findElement(By.id("actionbean.education.employee.id.AutoCompleter"));
		employee.sendKeys("first");
		Thread.sleep(5000);
		employee.sendKeys(Keys.DOWN);
		employee.sendKeys(Keys.ENTER);
		
		//Education Type
	 	WebElement edu = webDriver.findElement(By.id("StoreForm-Education_actionbean_education_type"));
 		Select sellectEduType = new Select(edu);
 		sellectEduType.selectByVisibleText("Master Degree");
 		
 		//Qualification
 		WebElement qua=webDriver.findElement(By.id("StoreForm-Education_actionbean_education_name"));
 		qua.clear();
 		qua.sendKeys("Master Of Computer Education");
 		
 	// validating the field length for the company text box
	 		String flengthEducationQualification = webDriver.findElement(
	 				By.id("StoreForm-Education_actionbean_education_name"))
	 				.getAttribute("maxlength");
	 		String dataEducationQualification = "data"+random;
	 		if(dataEducationQualification.length()<Integer.parseInt(flengthEducationQualification)){
	 			System.out.println("The entered data is less then field length(Education Qualification)");
	 		} else {
	 			System.out.println("the entered data is more then field length(Education Qualification)");
	 		}
	 		
	 Thread.sleep(TIMEOUT);
 		
 		//Percentage Marks
 		WebElement mar=webDriver.findElement(By.id("StoreForm-Education_actionbean_education_percentage"));
 		mar.clear();
 		mar.sendKeys("78");
 		
 		//Board/University
 		WebElement uni=webDriver.findElement(By.id("StoreForm-Education_actionbean_education_boardUniversity"));
 		uni.clear();
 		uni.sendKeys("Jadavpur University");
 		
 		//From Date
	    webDriver.findElement(By.name("actionbean.education.fromThruDate.fromDate")).click();
	
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
	
	
		//To Date
		webDriver.findElement(By.name("actionbean.education.fromThruDate.thruDate")).click();
		
			//For Year
		 	WebElement y = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
		 	Select selectY = new Select(y);
		 	selectY.selectByValue("2006");
		  	 			 		
			Thread.sleep(5000);
			                                                   
			//For Month
			WebElement m = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
			Select selectM = new Select(m);
			selectM.selectByValue("2");
			webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[4]/a")).click();
	 	
			Thread.sleep(5000);
		
		//Notes
		WebElement not=webDriver.findElement(By.id("StoreForm-Education_actionbean_education_descriptions"));
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
			System.out.println("we are in the Education page");
		}
	}

}
