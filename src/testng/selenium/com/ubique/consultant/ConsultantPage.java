package testng.selenium.com.ubique.consultant;

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

public class ConsultantPage extends SeleniumWebDriverLoginTests {

	public WebDriver webDriver;
	public ConsultantPage(WebDriver webdriver) {
		this.webDriver = webdriver;
		
	}
	
	public void storeConsultant() throws InterruptedException {
		webDriver.get(baseUrl+"home");
		
   	  	WebElement consultantMenulink=webDriver.findElement(By.linkText("Consultant"));
	    WebElement consultantSubMenulink=webDriver.findElement(By.xpath("(//a[contains(text(),'Consultant')])[3]"));
	   
	    Actions actions = new Actions(webDriver);
	    actions.moveToElement(consultantMenulink);

	    
	    actions.moveToElement(consultantSubMenulink);
	    actions.build().perform();
	    webDriver.get(baseUrl+"consultant/home?actionbean.tindex=1");
		
	    //Consultant Title
	    WebElement title = webDriver.findElement(By.name("actionbean.consultant.title"));
 		Select sellectTitle = new Select(title);
 		sellectTitle.selectByVisibleText("Mr.");
 		
 	 	//Consultant First Name
 		WebElement firstName=webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_firstName"));
 		firstName.clear();
 		firstName.sendKeys("Ramanuj");
 		
 		//Consultant Last Name
 		WebElement lastName=webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_lastName"));
 		lastName.clear();
 		lastName.sendKeys("Sen");
	    
 		Thread.sleep(5000);
 		
 		//Consultant Code
 		WebElement code=webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_code"));
 		code.clear();
 		code.sendKeys("Sen");
 		
 		//Consultant status
 		/*WebElement consultantStatus = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_status"));
 		Select sellectConsultantStatus = new Select(consultantStatus);
 		sellectConsultantStatus.selectByVisibleText("Active");*/
 		
 		
  		//Auto-Complete for Company
 		webDriver.findElement(By.id("actionbean.consultant.companyIdInt.AutoCompleter")).sendKeys("com");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.consultant.companyIdInt.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.consultant.companyIdInt.AutoCompleter")).sendKeys(Keys.ENTER);
 		
 		//Deployment type
 		WebElement consultantDepType = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_deploymentType"));
 		Select sellectConsultantDepType = new Select(consultantDepType);
 		sellectConsultantDepType.selectByVisibleText("Client Resource");
 		
 		
 		//Auto-Complete for Closed By
 		webDriver.findElement(By.id("actionbean.consultant.closedBy.AutoCompleter")).sendKeys("abh");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.consultant.closedBy.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.consultant.closedBy.AutoCompleter")).sendKeys(Keys.ENTER);
 		
 		//Date Of Birth
 		webDriver.findElement(By.name("actionbean.consultant.dateOfBirth")).click();
	 	
	   		//For Year
	  	 	WebElement year = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
		 	Select selectYear = new Select(year);
		 	selectYear.selectByValue("2004");
			  	 			 		
	 		Thread.sleep(5000);
	 		
	 		//For Month
	 		WebElement month = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
		 	Select selectMonth = new Select(month);
		 	selectMonth.selectByValue("3");
		 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[3]/a")).click();
		 	
	 		Thread.sleep(5000);
 		
 		
	 	//Gender
		WebElement gen = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_gender"));
		Select sellectGender = new Select(gen);
		sellectGender.selectByValue("101");
 		
 		
		 // Marital status
		 	WebElement mar = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_maritalStatus"));
		 	Select sellectMaritalStatus = new Select(mar);
		 	sellectMaritalStatus.selectByValue("942");
		 	
		 //Designation
		   WebElement designation = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_jobTitle"));
	 	   designation.clear();
	 	   designation.sendKeys("Developer");
 		
 		 //Primary Skill Set
	 	   WebElement primarySkillSet = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_primarySkillSet"));
	 	   primarySkillSet.clear();
	 	   primarySkillSet.sendKeys("coding");
 		
 		//Total Experience
	 	  WebElement totalExperience = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_totalExperience"));
	 	  totalExperience.clear();
	 	  totalExperience.sendKeys("6");
	 	
	 	//Currency
	 	 WebElement currency = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_ctcCurrency"));
		 Select selectCurrency = new Select(currency);
		 selectCurrency.selectByValue("1"); 
		
		 //Current CTC
		 WebElement currentCtc = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_ctc"));
		 currentCtc.clear();
		 currentCtc.sendKeys("100000");
		 
		 //Nationality
		 WebElement nat = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_nationality"));
		 Select sellectNet = new Select(nat);
		 sellectNet.selectByValue("336");
		 
		 Thread.sleep(3000);
		 
		 //VISA Status
		 WebElement visa = webDriver.findElement(By.id("StoreForm-Consultant_actionbean_consultant_visaStatus"));
		 Select sellectVisa = new Select(visa);
		 sellectVisa.selectByValue("1013");
		 
		//Store Button
		WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
		JavascriptExecutor executor = (JavascriptExecutor)webDriver;
		executor.executeScript("arguments[0].click();", element);
	 		 	
		Thread.sleep(TIMEOUT);
		
		Alert alert = webDriver.switchTo().alert();
		alert.accept();
			
		String strng = webDriver.findElement(By.xpath(".//*[@id='actionMsg']/ul/li")).getText();
		Assert.assertEquals("STORE Operation executed successfully.", strng);
	 	
		Thread.sleep(3000);
		
	}
}