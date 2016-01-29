package testng.selenium.com.ubique.contract;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class ProjectPage extends SeleniumWebDriverLoginTests {
	
	public WebDriver webDriver;

	public ProjectPage(WebDriver webdriver) {
		this.webDriver = webdriver;
	}
	
	
	public void storeProject() throws InterruptedException {
		
		webDriver.get(baseUrl+"home");
		
   	  	WebElement projectMenulink=webDriver.findElement(By.linkText("Contract"));
	    WebElement projectSubMenulink=webDriver.findElement(By.xpath(".//*[@id='headerPan']/div[4]/ul/li[4]/ul/li[1]/a"));
	   
	    Actions actions = new Actions(webDriver);
	    actions.moveToElement(projectMenulink);

	    
	    actions.moveToElement(projectSubMenulink);
	    actions.build().perform();
	    webDriver.get(baseUrl+"project/home"); 
	    
	    Thread.sleep(5000);
	    
	    //Auto-Complete for Company
 		webDriver.findElement(By.id("actionbean.project.companyId.AutoCompleter")).sendKeys("com");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.project.companyId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.project.companyId.AutoCompleter")).sendKeys(Keys.ENTER);
 		
	    
 		//Customer company name is not present
 		WebElement com=webDriver.findElement(By.id("actionbean.project.customerCompanyId.AutoCompleter"));
 		Thread.sleep(5000);
 		com.sendKeys("thi");
 		com.sendKeys(Keys.DOWN);
 		com.sendKeys(Keys.ENTER);
 		
 		//Project Name
 		WebElement projectName=webDriver.findElement(By.id("StoreForm-Project_actionbean_project_name"));
 		projectName.clear();
 		projectName.sendKeys("corpMIS");
	    
	    //Project Code
 		WebElement projectCode=webDriver.findElement(By.id("StoreForm-Project_actionbean_project_code"));
 		projectCode.clear();
 		projectCode.sendKeys("C123");
	    
	    
	    //Service Type
 		WebElement serviceType = webDriver.findElement(By.name("actionbean.project.serviceType"));
 		Select sellectServiceType = new Select(serviceType);
 		sellectServiceType.selectByVisibleText("Development");
	    
	    
	    //Project Type
 		WebElement projectType = webDriver.findElement(By.name("actionbean.project.type"));
 		Select selectProjectType = new Select(projectType);
 		selectProjectType.selectByVisibleText("Testing");
	    
 		 //Store Button
		 WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
		 JavascriptExecutor executor = (JavascriptExecutor)webDriver;
		 executor.executeScript("arguments[0].click();", element);
		 	
		 Thread.sleep(TIMEOUT);
			
		 Alert alert = webDriver.switchTo().alert();
		 alert.accept();
			 	
		 Thread.sleep(TIMEOUT);
	    
	    
}
	}


	
		
	

	
	
	
	
	
	
	