package testng.selenium.com.ubique.company;

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

public class ContactPersonPage extends SeleniumWebDriverLoginTests {

	
	public WebDriver webDriver;
	
	Random random = new Random();
	
	public ContactPersonPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	
	public void storeContactPerson() throws InterruptedException {
		
		//Click on Contact Person Tab
		webDriver.findElement(By.xpath("//a[@title='Contact Person']")).click();
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
					// button
					Thread.sleep(TIMEOUT);
					withOutDataHitStoreButton();
					
	  
		//Auto-Complete for Company
		webDriver.findElement(By.id("actionbean.contactPerson.company.id.AutoCompleter")).sendKeys("com");
		Thread.sleep(5000);
	 	webDriver.findElement(By.id("actionbean.contactPerson.company.id.AutoCompleter")).sendKeys(Keys.DOWN);
	 	webDriver.findElement(By.id("actionbean.contactPerson.company.id.AutoCompleter")).sendKeys(Keys.ENTER);
		
	 	//Auto-Complete for Office
	 	webDriver.findElement(By.id("actionbean.contactPerson.officeId.AutoCompleter")).sendKeys("off");
	 	Thread.sleep(5000);
	 	webDriver.findElement(By.id("actionbean.contactPerson.officeId.AutoCompleter")).sendKeys(Keys.DOWN);
	 	webDriver.findElement(By.id("actionbean.contactPerson.officeId.AutoCompleter")).sendKeys(Keys.ENTER);
	 	
	 	//Contact Person Name
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_name")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_name")).clear();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_name")).sendKeys("Company Test Contact Person1");
	 	
	 // validating the field length for the company text box
	 		String flengthContactPersonName = webDriver.findElement(
	 				By.id("StoreForm-ContactPerson_actionbean_contactPerson_name"))
	 				.getAttribute("maxlength");
	 		String dataContactPersonName = "data"+random;
	 		if(dataContactPersonName.length()<Integer.parseInt(flengthContactPersonName)){
	 			System.out.println("The entered data is less then field length(Contact Person Name)");
	 		} else {
	 			System.out.println("the entered data is more then field length(Contact Person Name)");
	 		}
	 		
	 		Thread.sleep(TIMEOUT);
	 	
	 	
	 	//Contact Person Type Drop Down
	 	WebElement contactPersonType = webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_type"));
 		Select sellectContactPersonType = new Select(contactPersonType);
 		sellectContactPersonType.selectByVisibleText("Account Officer");
 		
	 	Thread.sleep(5000);
	 	
	 	//Job Title
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_jobTitle")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_jobTitle")).sendKeys("Accountant");
	 	
	 	//Department
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_department")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_department")).sendKeys("Account");
	 	
	 	//Phone Number
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_phone")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_phone")).sendKeys("03325568974");
	 	
	 	//Fax Number
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_fax")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_fax")).sendKeys("03325568975");
	 	
	 	//Mobile Number
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_mobile")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_mobile")).sendKeys("9001234568");
	 	
	 	//Email
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_email")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_email")).sendKeys("contactperson@test.com");

	 	//Notes
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_info")).click();
	 	webDriver.findElement(By.id("StoreForm-ContactPerson_actionbean_contactPerson_info")).sendKeys("notes notes notes notes");
	 	
	 	//Store Button
	 	WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
	 	JavascriptExecutor executor = (JavascriptExecutor)webDriver;
	 	executor.executeScript("arguments[0].click();", element);
	 	
	 	/*String storeButton=webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span")).getText();
	 	webDriver.findElement(By.linkText(storeButton)).click();*/
	 		 	
	 	Thread.sleep(TIMEOUT);
		
	 	Alert alert = webDriver.switchTo().alert();
	 	alert.accept();
	 	
	 	Thread.sleep(TIMEOUT);
	 	Thread.sleep(TIMEOUT);
	}
	public void PageTitle(){
		
		String actualPageTitle = webDriver.getTitle();
		String expectedPageTitle = "Corp MIS - Company - Home";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);{
			System.out.println("we are in the Contact Person page");
		}
	
       
	
	}
}