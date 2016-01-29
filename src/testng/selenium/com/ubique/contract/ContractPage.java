package testng.selenium.com.ubique.contract;

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

public class ContractPage extends SeleniumWebDriverLoginTests {
	
	private String contractName="Name" + number;
	private String contractCode="Code" + number;
	
	private WebDriver webDriver;

	public ContractPage(WebDriver webdriver) {
		this.webDriver = webdriver;
	}
	
	
	public void storeContract() throws InterruptedException {
		
		webDriver.get(baseUrl+"home");
		
   	  	WebElement projectMenulink=webDriver.findElement(By.linkText("Contract"));
	    WebElement projectSubMenulink=webDriver.findElement(By.xpath("(//a[contains(text(),'Contract')])[3]"));
	   
	    Actions actions = new Actions(webDriver);
	    actions.moveToElement(projectMenulink);

	    
	    actions.moveToElement(projectSubMenulink);
	    actions.build().perform();
	    webDriver.get(baseUrl+"contract/home?actionbean.tindex=1"); 
	    
	    Thread.sleep(5000);
	    
	    
	    //Auto-Complete for Project Name
 		webDriver.findElement(By.id("actionbean.contract.projectId.AutoCompleter")).sendKeys("cor");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.contract.projectId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.contract.projectId.AutoCompleter")).sendKeys(Keys.ENTER); 
	    
	    
	    //Group
 		WebElement group = webDriver.findElement(By.id("StoreForm-Contract_actionbean_contract_groupId"));
  		Select selectGroup = new Select(group);
  		selectGroup.selectByVisibleText("OneTime Invoice");
	    
	    //Contract Name
  		WebElement name=webDriver.findElement(By.id("StoreForm-Contract_actionbean_contract_name"));
  		name.clear();
  		name.sendKeys(contractName);
  		
  		//Code
  		WebElement code=webDriver.findElement(By.id("StoreForm-Contract_actionbean_contract_code"));
  		code.clear();
  		code.sendKeys(contractCode);
  		
  		//PoNum
  		WebElement poNum=webDriver.findElement(By.id("StoreForm-Contract_actionbean_contract_contractPoNum"));
  		poNum.clear();
  		poNum.sendKeys("1234");
  		
  		//Currency
  		 WebElement currency = webDriver.findElement(By.id("StoreForm-Contract_actionbean_contract_currencyId"));
   		Select sellectCurrency = new Select(currency);
   		sellectCurrency.selectByValue("1");
  		Thread.sleep(5000);
  		
  		
  		//From Date
  		webDriver.findElement(By.name("actionbean.contract.fromThruDate.fromDate")).click();
  			 	
  		  		//For Year
  		  	 	WebElement year1 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
  			 	Select selectYear1 = new Select(year1);
  			 	selectYear1.selectByValue("2014");
  					
  		 		Thread.sleep(5000);
  		 		
  		 		//For Month
  		 		WebElement month1 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
  			 	Select selectMonth1 = new Select(month1);
  			 	selectMonth1.selectByValue("7");
  			 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[2]/a")).click();
  				 	
  		 		Thread.sleep(5000);
  		
  		//To Date
  		webDriver.findElement(By.name("actionbean.contract.fromThruDate.thruDate")).click();
  		  			 	
  		   		//For Year
  		  	 	WebElement year2 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
  			 	Select selectYear2 = new Select(year2);
  			 	selectYear2.selectByValue("2015");
  		  					
  		 		Thread.sleep(5000);
  		  			 		
  		 		//For Month
  		 		WebElement month2 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
  			 	Select selectMonth2 = new Select(month2);
  			 	selectMonth2.selectByValue("7");
  			 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[2]/a")).click();
  		  				 	
  				Thread.sleep(5000);
  		
  		//Contract Date
  		webDriver.findElement(By.name("actionbean.contract.contractDate")).click();
  		  			 	
  		  		//For Year
  		  	 	WebElement year3 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
  			 	Select selectYear3 = new Select(year3);
  			 	selectYear3.selectByValue("2014");
  		  					
  		 		Thread.sleep(5000);
  		  		 		
  		 		//For Month
  		 		WebElement month3 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
  			 	Select selectMonth3 = new Select(month3);
  			 	selectMonth3.selectByValue("7");
  			 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[2]/a")).click();
  		  				 	
  		 		Thread.sleep(5000);
  		
  		 //Signed Date
  		 webDriver.findElement(By.name("actionbean.contract.signedDate")).click();
  		  		  			 	
  		 	//For Year
  		 	WebElement year4 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
  		 	Select selectYear4 = new Select(year4);
  			selectYear4.selectByValue("2014");
  		  		  					
  			Thread.sleep(5000);
  		  		  		 		
  		  	//For Month
  		 	WebElement month4 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
  		 	Select selectMonth4 = new Select(month4);
  		 	selectMonth4.selectByValue("7");
  		 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[2]/a")).click();
  		  		  				 	
  		  	Thread.sleep(5000);
  	
  		 		
  		//Renewal Period
  		WebElement per = webDriver.findElement(By.id("StoreForm-Contract_actionbean_contract_renewalIntervalId"));
	 	Select selectRePeriod = new Select(per);
	 	selectRePeriod.selectByValue("478");
  		
	 	//Renewal Date
  	  	webDriver.findElement(By.name("actionbean.contract.renewalDate")).click();
  	  		  		  			 	
  	  		 	//For Year
  	  		 	WebElement year5 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
  	  		 	Select selectYear5 = new Select(year5);
  	  			selectYear5.selectByValue("2015");
  	  		  		  					
  	  			Thread.sleep(5000);
  	  		  		  		 		
  	  		  	//For Month
  	  		 	WebElement month5 = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
  	  		 	Select selectMonth5 = new Select(month5);
  	  		 	selectMonth5.selectByValue("7");
  	  		 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a")).click();
  	  		  		  				 	
  	  		  	Thread.sleep(5000);
  	  		  	
	 	//Auto-Complete for Employee
 		webDriver.findElement(By.id("actionbean.contract.items[0].refEId.AutoCompleter")).sendKeys("abh");
 		Thread.sleep(5000);
 		webDriver.findElement(By.id("actionbean.contract.items[0].refEId.AutoCompleter")).sendKeys(Keys.DOWN);
 		webDriver.findElement(By.id("actionbean.contract.items[0].refEId.AutoCompleter")).sendKeys(Keys.ENTER); 
  		
  		//Detail
 		WebElement detail=webDriver.findElement(By.id("StoreForm-Contract_actionbean_contract_detailText"));
 		detail.clear();
 		detail.sendKeys("Tester");
  		
 		 		
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
}























