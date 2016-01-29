package testng.selenium.com.ubique.employee;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class EmployeePage extends SeleniumWebDriverLoginTests {
	
	private String employeeFirstName="FirstName" + number;
	private String employeeLastName="LastName" + number;
	private String employeeCode="EmpCode" + number;
	
	public WebDriver webDriver;
	
	Random random = new Random();

	public EmployeePage(WebDriver webdriver) {
		this.webDriver = webdriver;
	}
	
	
	public void storeEmployee() throws InterruptedException {
		
		webDriver.get(baseUrl+"home");
		
   	  	WebElement employeeMenulink=webDriver.findElement(By.linkText("Employee"));
	    WebElement employeeSubMenulink=webDriver.findElement(By.xpath("(//a[contains(text(),'Employee')])[3]"));
	   
	    Actions actions = new Actions(webDriver);
	    actions.moveToElement(employeeMenulink);

	    
	    actions.moveToElement(employeeSubMenulink);
	    actions.build().perform();
	    webDriver.get(baseUrl+"employee/home?actionbean.tindex=1");
	    
	 // Adding delay to wait for certain amount of time then hitting the save
			// button
			Thread.sleep(TIMEOUT);
			withOutDataHitStoreButton();
    
	    
	    //Employee Title
	    WebElement title = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_title"));
 		Select sellectTitle = new Select(title);
 		sellectTitle.selectByVisibleText("Mr.");
 		
 		//Employee First Name
 		WebElement firstName=webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_firstName"));
 		firstName.clear();
 		firstName.sendKeys(employeeFirstName);
 		
 	// validating the field length for the company text box
		String flengthEmployeeFirstName = webDriver.findElement(
				By.id("StoreForm-Employee_actionbean_employee_firstName"))
				.getAttribute("maxlength");
		String dataEmployeeFirstName = "data"+random;
		if(dataEmployeeFirstName.length()<Integer.parseInt(flengthEmployeeFirstName)){
			System.out.println("The entered data is less then field length(Employee first Name)");
		} else {
			System.out.println("the entered data is more then field length(Employee First Name)");
		}
		
Thread.sleep(TIMEOUT);
 		
 		
 		//Employee Last Name
 		WebElement lastName=webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_lastName"));
 		lastName.clear();
 		lastName.sendKeys(employeeLastName);
	    
 		Thread.sleep(5000);
 		
 	// validating the field length for the company text box
 			String flengthEmployeeLastName = webDriver.findElement(
 					By.id("StoreForm-Employee_actionbean_employee_firstName"))
 					.getAttribute("maxlength");
 			String dataEmployeeLastName = "data"+random;
 			if(dataEmployeeLastName.length()<Integer.parseInt(flengthEmployeeLastName)){
 				System.out.println("The entered data is less then field length(Employee Last Name)");
 			} else {
 				System.out.println("the entered data is more then field length(Employee Last Name)");
 			}
 			
 	Thread.sleep(TIMEOUT);
 		
 		
 		//Employee Code
 		WebElement code=webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_code"));
 		code.clear();
 		code.sendKeys(employeeCode);
 		
 		
 		//Employee Type
	    WebElement employeeType = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_type"));
 		Select sellectEmployeeType = new Select(employeeType);
 		sellectEmployeeType.selectByVisibleText("Permanent");
 		
 		//Employee Status
	    WebElement employeeStatus = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_status"));
 		Select sellectEmployeeStatus = new Select(employeeStatus);
 		sellectEmployeeStatus.selectByVisibleText("Active");
 		
 		//Band
	    WebElement band = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_bandId"));
 		Select sellectBand = new Select(band);
 		sellectBand.selectByValue("1");
 		
 		//Job Title
 		WebElement jobTitle=webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_jobTitle"));
 		jobTitle.clear();
 		jobTitle.sendKeys(".Net Developer");
 		
 		//SID Name
	    WebElement sid = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_sidName"));
 		Select sellectSID = new Select(sid);
 		sellectSID.selectByValue("91");
 		
 		//SID Name
 		WebElement sidNo=webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_sidNo"));
 		sidNo.clear();
 		sidNo.sendKeys("123456");
 		
	
 		//Auto-Complete for Company
 		webDriver.findElement(By.id("actionbean.employee.companyId.AutoCompleter")).sendKeys("com");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.employee.companyId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.employee.companyId.AutoCompleter")).sendKeys(Keys.ENTER);
 				
 		//Auto-Complete for Office
 		webDriver.findElement(By.id("actionbean.employee.officeId.AutoCompleter")).sendKeys("com");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.employee.officeId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.employee.officeId.AutoCompleter")).sendKeys(Keys.ENTER);
 			 	
 		//Department
	    WebElement dep = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_departmentId"));
 		Select sellectDep = new Select(dep);
 		sellectDep.selectByValue("974");
 		
 		//Auto-Complete for Closed By
 		webDriver.findElement(By.id("actionbean.employee.employeeId.AutoCompleter")).sendKeys("abh");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.employee.employeeId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.employee.employeeId.AutoCompleter")).sendKeys(Keys.ENTER);
 		
 		Thread.sleep(5000);
 		
 		//Date Of Birth
 		webDriver.findElement(By.name("actionbean.employee.dateOfBirth")).click();
	 	
	   		//For Year
	  	 	WebElement year = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
		 	Select selectYear = new Select(year);
		 	selectYear.selectByValue("2004");
			  	 			 		
	 		Thread.sleep(5000);
	 		
	 		//For Month
	 		WebElement month = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
		 	Select selectMonth = new Select(month);
		 	selectMonth.selectByValue("3");
		 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		 	
	 		Thread.sleep(5000);
	 	
	 	//Gender
		WebElement gen = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_gender"));
	 	Select sellectGender = new Select(gen);
	 	sellectGender.selectByValue("101");
	 		
	 	//Nationality
		WebElement nat = webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_nationality"));
	 	Select sellectNet = new Select(nat);
	 	sellectNet.selectByValue("336");
	 		
	 	//Current CTC
	 	/*WebElement ctc=webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_ctc"));
	 	ctc.clear();
	 	ctc.sendKeys("360000");*/
	 		
	 	//Notice Period
	 	WebElement np=webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_probationPeriod"));
	 	np.clear();
	 	np.sendKeys("3");
	 		
	 	//Date Of Joining
		webDriver.findElement(By.name("actionbean.employee.dateOfJoining")).click();
		 	
		   		//For Year
		  	 	WebElement year1 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
			 	Select selectYear1 = new Select(year1);
			 	selectYear1.selectByValue("2004");
				
		 		Thread.sleep(5000);
		 		
		 		//For Month
		 		WebElement month1 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
			 	Select selectMonth1 = new Select(month1);
			 	selectMonth1.selectByValue("3");
			 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
			 	
		 		Thread.sleep(5000);
		 		
		 //Notes
		 webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_comments")).click();
		 webDriver.findElement(By.id("StoreForm-Employee_actionbean_employee_comments")).sendKeys("Notes Notes Notes Notes");
		 	
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

}
