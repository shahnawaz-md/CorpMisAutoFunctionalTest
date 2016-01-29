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

public class PersonalInfoPage extends SeleniumWebDriverLoginTests {
	
	private String employeeFatherName="FatherName" + number;
	private String employeeMotherName="MotherName" + number;
	private String employeeSpouseName="SpouseName" + number;
	
	public WebDriver webDriver;


	
	public PersonalInfoPage(WebDriver webdriver) {
		this.webDriver = webdriver;
		
	}
	
	public void storePersonalInfo() throws InterruptedException {
				
		//Personal Info Tab
		webDriver.findElement(By.xpath("//a[@title='Personal']")).click();
		Thread.sleep(5000);
		
		PageTitle();
				
		
		//Auto-Complete For Employee
		WebElement employee=webDriver.findElement(By.id("actionbean.employeePersonalInfo.employee.id.AutoCompleter"));
		employee.sendKeys("first");
		Thread.sleep(5000);
		employee.sendKeys(Keys.DOWN);
		employee.sendKeys(Keys.ENTER);
		
		
		//Father's Name
		WebElement fName= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_fatherName"));
		fName.clear();
		fName.sendKeys(employeeFatherName);
		
		//Mother's Name
		WebElement mName= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_motherName"));
		mName.clear();
		mName.sendKeys(employeeMotherName);
		
		//Guardian's Name
		WebElement gName= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_guardianName"));
		gName.clear();
		gName.sendKeys(employeeFatherName);
		
		//Drop Down For Marital Status
	 	WebElement maritalStaus = webDriver.findElement(By.name("actionbean.employeePersonalInfo.maritalStatus"));
		Select sellectMaritalStatus = new Select(maritalStaus);
		sellectMaritalStatus.selectByVisibleText("Married");
		
		//Spouse Name
		WebElement sName= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_spouseName"));
		sName.clear();
		sName.sendKeys(employeeSpouseName);
		
		//No. Of Children
		WebElement noOfChild= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_noOfChildren"));
		noOfChild.clear();
		noOfChild.sendKeys("1");
		
		//Children Details
		WebElement childDetails= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_childrenDetails"));
		childDetails.clear();
		childDetails.sendKeys("So Sweet");
		
		//No. Of Dependents
		WebElement noOfDep= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_noOfDependents"));
		noOfDep.clear();
		noOfDep.sendKeys("1");
		
		//Dependent Details
		WebElement depDetails= webDriver.findElement(By.id("StoreForm-EmployeePersonalInfo_actionbean_employeePersonalInfo_dependentDetails"));
		depDetails.clear();
		depDetails.sendKeys("So Sweet");
		
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
			System.out.println("we are in the Personal Info page");
		}
	
	}
}