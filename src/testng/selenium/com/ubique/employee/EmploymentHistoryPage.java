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

public class EmploymentHistoryPage extends SeleniumWebDriverLoginTests {
	
	private String EmployeeName="EmployeeName" + number;
	
	public WebDriver webDriver;
	
	Random random = new Random();
	
	public EmploymentHistoryPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}


	public void storeEmploymentHistory() throws InterruptedException{
		
				
	    //Employment History Tab
	    webDriver.findElement(By.xpath("//a[@title='History']")).click();
		Thread.sleep(5000);
	    
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
		// button
		Thread.sleep(TIMEOUT);
		withOutDataHitStoreButton();
		
		//Auto-Complete For Employee
		WebElement employee=webDriver.findElement(By.id("actionbean.employmentHistory.employee.id.AutoCompleter"));
		employee.sendKeys("first");
		Thread.sleep(5000);
		employee.sendKeys(Keys.DOWN);
		employee.sendKeys(Keys.ENTER);
		
		//Employer Name
 		WebElement emp=webDriver.findElement(By.id("StoreForm-EmploymentHistory_actionbean_employmentHistory_employerName"));
 		emp.clear();
 		emp.sendKeys(EmployeeName);
 		
 	// validating the field length for the company text box
 		String flengthEmployerName = webDriver.findElement(
 				By.id("StoreForm-EmploymentHistory_actionbean_employmentHistory_employerName"))
 				.getAttribute("maxlength");
 		String dataEmployerName = "data"+random;
 		if(dataEmployerName.length()<Integer.parseInt(flengthEmployerName)){
 			System.out.println("The entered data is less then field length(Employer Name)");
 		} else {
 			System.out.println("the entered data is more then field length(Employer Name)");
 		}
 		
 Thread.sleep(TIMEOUT);
 		
 		//Job Title
 		WebElement job=webDriver.findElement(By.id("StoreForm-EmploymentHistory_actionbean_employmentHistory_jobTitle"));
 		job.clear();
 		job.sendKeys(".Net Developer");
 		
 	// validating the field length for the company text box
 	 		String flengthJobTitle = webDriver.findElement(
 	 				By.id("StoreForm-EmploymentHistory_actionbean_employmentHistory_jobTitle"))
 	 				.getAttribute("maxlength");
 	 		String dataJobTitle = "data"+random;
 	 		if(dataJobTitle.length()<Integer.parseInt(flengthJobTitle)){
 	 			System.out.println("The entered data is less then field length(Education Qualification)");
 	 		} else {
 	 			System.out.println("the entered data is more then field length(Education Qualification)");
 	 		}
 	 		
 	 Thread.sleep(TIMEOUT);
 		
 		//From
	    webDriver.findElement(By.name("actionbean.employmentHistory.dateOfJoining")).click();
	
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
		webDriver.findElement(By.name("actionbean.employmentHistory.dateOfLeaving")).click();
		
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
		
		//Job Title
	 	WebElement exp=webDriver.findElement(By.id("StoreForm-EmploymentHistory_actionbean_employmentHistory_yearOfExperience"));
	 	exp.clear();
	 	exp.sendKeys("5");
		
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
			System.out.println("we are in the Employment History page");
		}
	}

	

}
