package testng.selenium.com.ubique.contract;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class ContractItemPage extends SeleniumWebDriverLoginTests{
	
	private WebDriver webDriver;

	public ContractItemPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeContractItem() throws InterruptedException{
		
     webDriver.get(baseUrl+"home");
		
   	  	WebElement projectMenulink=webDriver.findElement(By.linkText("Contract"));
	    WebElement projectSubMenulink=webDriver.findElement(By.xpath("(//a[contains(text(),'Contract')])[3]"));
	   
	    Actions actions = new Actions(webDriver);
	    actions.moveToElement(projectMenulink);

	    
	    actions.moveToElement(projectSubMenulink);
	    actions.build().perform();
	    webDriver.get(baseUrl+"contract/home?actionbean.tindex=1");
	    
		//Contract Item Tab
		webDriver.findElement(By.xpath("//a[@title='Contract Item']")).click();
				
		Thread.sleep(5000);
		
		   
		  //Auto-Complete for Contract Name
	 		webDriver.findElement(By.id("actionbean.contractItem.contract.id.AutoCompleter")).sendKeys("Name");
	 		Thread.sleep(5000);
	 		webDriver.findElement(By.id("actionbean.contractItem.contract.id.AutoCompleter")).sendKeys(Keys.DOWN);
	 		webDriver.findElement(By.id("actionbean.contractItem.contract.id.AutoCompleter")).sendKeys(Keys.ENTER); 
		    
	 	 //Rate type
	 		 WebElement rateType = webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_contractItem_rateType"));
	   		Select selectRateType = new Select(rateType);
	   		selectRateType.selectByVisibleText("Monthly");
	   		
	   		
	   	//Note:-From date is as it is
	   		
	   	//To date
	   		
	 		webDriver.findElement(By.name("actionbean.contractItem.fromThruDate.thruDate")).click();
		 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();	  	 			 		
		 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a")).click();
	   		Thread.sleep(2000);
	   		
	   		
		 //Auto-Complete for Company Name
		 	webDriver.findElement(By.id("actionbean.contractItem.refEId.AutoCompleter")).sendKeys("abh");
		 	Thread.sleep(5000);
		 	webDriver.findElement(By.id("actionbean.contractItem.refEId.AutoCompleter")).sendKeys(Keys.DOWN);
		 	webDriver.findElement(By.id("actionbean.contractItem.refEId.AutoCompleter")).sendKeys(Keys.ENTER);
		 	
		 	
		 //Add Rate Group
		  webDriver.findElement(By.id("addAssociatedEntitiesContractItemRateLink-ContractItemRateGroup")).click();
		 //addRateGroup.click();
		 webDriver.switchTo().alert().accept();
		 //JavascriptExecutor executor = (JavascriptExecutor)webDriver;
		Thread.sleep(5000);
	   		
		//Thru date
		webDriver.findElement(By.name("actionbean.entity.rateGroups[0].fromThruDate.thruDate")).click();
	 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();	  	 			 		
	 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a")).click();
   		Thread.sleep(2000);
		
   		//Fixed rate
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_0__rate")).clear();
   		
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_0__rate")).sendKeys("100");
   		
   		//Overtime rate
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_1__rate")).clear();
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_1__rate")).sendKeys("100");
   		
   		//Overtime saturday
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_2__rate")).clear();
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_2__rate")).sendKeys("500");
   		
   		//Rate UOM
   		WebElement rateUOM = webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_2__rateUom"));
		Select sellectRateUOM = new Select(rateUOM);
		sellectRateUOM.selectByVisibleText("Daily");
   		
   		//Overtime sunday
		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_3__rate")).clear();
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_3__rate")).sendKeys("700");
   		
    	//Rate UOM
   		WebElement rateUOM1 = webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_3__rateUom"));
		Select sellectRateUOM1 = new Select(rateUOM1);
		sellectRateUOM1.selectByVisibleText("Daily");
   		
   		//Overtime holiday
		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_4__rate")).clear();
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_4__rate")).sendKeys("800");
   		
   	   //Rate UOM
   		WebElement rateUOM2 = webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_4__rateUom"));
		Select sellectRateUOM2 = new Select(rateUOM2);
		sellectRateUOM2.selectByVisibleText("Daily");
   		
   		
   		//On call
		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_5__rate")).clear();
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_5__rate")).sendKeys("900");
   		
   	   //Rate UOM
   		WebElement rateUOM3 = webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_5__rateUom"));
		Select sellectRateUOM3 = new Select(rateUOM3);
		sellectRateUOM3.selectByVisibleText("Daily");
   		
   		
   		//Stand By
		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_6__rate")).clear();
   		webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_6__rate")).sendKeys("1000");
   		
   	   //Rate UOM
   		WebElement rateUOM4 = webDriver.findElement(By.id("StoreForm-ContractItem_actionbean_entity_rateGroups_0__rates_6__rateUom"));
		Select sellectRateUOM4 = new Select(rateUOM4);
		sellectRateUOM4.selectByVisibleText("Daily");
   		
   		Thread.sleep(5000);
   		
		 //Store Button
		 	WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
			JavascriptExecutor executor1 = (JavascriptExecutor)webDriver;
			executor1.executeScript("arguments[0].click();", element);
			 	
			 Thread.sleep(TIMEOUT);
				
			 Alert alert = webDriver.switchTo().alert();
			 alert.accept();
				 	
			 Thread.sleep(TIMEOUT);
		 	
		}
}