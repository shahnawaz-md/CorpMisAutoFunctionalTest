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

public class ContactPage extends SeleniumWebDriverLoginTests{
	
	public WebDriver webDriver;
	
	Random random = new Random();

	public ContactPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeContact() throws InterruptedException{
		
		//Contacts Tab
		webDriver.findElement(By.xpath("//a[@title='Contacts']")).click();
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
		// button
		Thread.sleep(TIMEOUT);
		withOutDataHitStoreButton();
		
		//Auto-Complete For Employee
		WebElement employee=webDriver.findElement(By.id("actionbean.employeeContact.employee.id.AutoCompleter"));
		employee.sendKeys("first");
		Thread.sleep(5000);
		employee.sendKeys(Keys.DOWN);
		employee.sendKeys(Keys.ENTER);
		
		
		//Address1
		WebElement add1=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_address1"));
		add1.clear();
		add1.sendKeys("Behala");
		
		// validating the field length for the company text box
				String flengthAddress1 = webDriver.findElement(
						By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_address1"))
						.getAttribute("maxlength");
				String dataAddress1 = "data"+random;
				if(dataAddress1.length()<Integer.parseInt(flengthAddress1)){
					System.out.println("The entered data is less then field length(Address1)");
				} else {
					System.out.println("the entered data is more then field length(Address1)");
				}
				
		Thread.sleep(TIMEOUT);
		
		//Address2
		WebElement add2=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_address2"));
		add2.clear();
		add2.sendKeys("Behala Behala");
		
		//Zip Code
		WebElement zip=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_postalCode"));
		zip.clear();
		String a = "700102";
		zip.sendKeys(a);
		
		// validating the field length for the company text box
		String flengthZIPCode = webDriver.findElement(
				By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_postalCode"))
				.getAttribute("maxlength");
		String dataZIPCode = a;//"data"+random;
		if(dataZIPCode.length()<Integer.parseInt(flengthZIPCode)){
			System.out.println("The entered data is less then field length(ZIP Code)");
		} else {
			System.out.println("the entered data is more then field length(ZIP Code)");
		}
		
Thread.sleep(TIMEOUT);
		
		
		//Auto-Complete For Location
	 	WebElement loc=webDriver.findElement(By.id("actionbean.employeeContact.presentContact.locationId.AutoCompleter"));
	 	loc.sendKeys("kol");
	 	Thread.sleep(3000);
	 	loc.sendKeys(Keys.DOWN);
	 	loc.sendKeys(Keys.ENTER);
	 	
	 	Thread.sleep(5000);
	 	
	 	//Mobile
	 	WebElement mob=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_mobile"));
	 	mob.clear();
	 	mob.sendKeys("9865320147");
	 	
	  	//Phone
	 	WebElement phone=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_phone"));
	 	phone.clear();
	 	phone.sendKeys("0332556896");
	 	
	 	//Email
	 	WebElement email=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_email"));
	 	email.clear();
	 	email.sendKeys("contact@test.com");
	 	
	 // validating the field length for the company text box
	 		String flengthEmail = webDriver.findElement(
	 				By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_email"))
	 				.getAttribute("maxlength");
	 		String dataEmail = "data"+random;
	 		if(dataEmail.length()<Integer.parseInt(flengthEmail)){
	 			System.out.println("The entered data is less then field length(Email)");
	 		} else {
	 			System.out.println("the entered data is more then field length(Email)");
	 		}
	 		
	 Thread.sleep(TIMEOUT);

	 	//URL
	 	WebElement url=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_presentContact_url"));
	 	url.clear();
	 	url.sendKeys("https://contact@test.com");
	 	
	 	//Permanent
	 	//Permanent Address1
	 	WebElement pAdd1=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_permanentContact_address1"));
	 	pAdd1.clear();
	 	pAdd1.sendKeys("Behala");
	 			
	 	//Permanent Address2
	 	WebElement pAdd2=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_permanentContact_address2"));
	 	pAdd2.clear();
	 	pAdd2.sendKeys("Behala Behala");
	 			
	 	//Permanent Zip Code
	 	WebElement pZip=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_permanentContact_postalCode"));
	 	pZip.clear();
	 	pZip.sendKeys("700056");
	 	
	 	//Auto-Complete For Location
	 	WebElement pLoc=webDriver.findElement(By.id("actionbean.employeeContact.permanentContact.locationId.AutoCompleter"));
	 	pLoc.sendKeys("kol");
	 	Thread.sleep(3000);
	 	pLoc.sendKeys(Keys.DOWN);
	 	pLoc.sendKeys(Keys.ENTER);
	 		 	
	 	Thread.sleep(5000);
	 	
	 	//Mobile
	 	WebElement pMob=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_permanentContact_mobile"));
	 	pMob.clear();
	 	pMob.sendKeys("9865320155");
	 		 	
	 	//Phone
	 	WebElement pPhone=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_permanentContact_phone"));
	 	pPhone.clear();
	 	pPhone.sendKeys("0332556866");
	 		 	
	 	//Email
	 	WebElement e1=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_permanentContact_email"));
	 	e1.clear();
	 	e1.sendKeys("contact1@test.com");

	 	//URL
	 	WebElement url1=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_permanentContact_url"));
	 	url1.clear();
	 	url1.sendKeys("https://contact1@test.com");
	 	
	 	
	 	//Office
	 	//Office Address1
	 	WebElement oAdd1=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_officeContact_address1"));
	 	oAdd1.clear();
	 	oAdd1.sendKeys("Behala");
	 			
	 	//Office Address2
	 	WebElement oAdd2=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_officeContact_address2"));
	 	oAdd2.clear();
	 	oAdd2.sendKeys("Behala Behala");
	 			
	 	//Office Zip Code
	 	WebElement oZip=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_officeContact_postalCode"));
	 	oZip.clear();
	 	oZip.sendKeys("700056");
	 	
	 	//Auto-Complete For Location
	 	WebElement oLoc=webDriver.findElement(By.id("actionbean.employeeContact.officeContact.locationId.AutoCompleter"));
	 	oLoc.sendKeys("kol");
	 	Thread.sleep(3000);
	 	oLoc.sendKeys(Keys.DOWN);
	 	oLoc.sendKeys(Keys.ENTER);
	 		 	
	 	Thread.sleep(5000);
	 	
	 	//Mobile
	 	WebElement oMob=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_officeContact_mobile"));
	 	oMob.clear();
	 	oMob.sendKeys("9865320157");
	 		 	
	 	//Phone
	 	WebElement oPhone=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_officeContact_phone"));
	 	oPhone.clear();
	 	oPhone.sendKeys("0332556867");
	 		 	
	 	//Email
	 	WebElement e2=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_officeContact_email"));
	 	e2.clear();
	 	e2.sendKeys("contact2@test.com");

	 	//URL
	 	WebElement url2=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_officeContact_url"));
	 	url2.clear();
	 	url2.sendKeys("https://contact2@test.com");
	 	
	 	//Emergency
	 	//Contact Person Name
	 	WebElement cp=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_emergencyContact_contactPersonName"));
	 	cp.clear();
	 	cp.sendKeys("Ajit");
	 	
	 	//Address
	 	WebElement add3=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_emergencyContact_address"));
	 	add3.clear();
	 	add3.sendKeys("Taratala");
	 	
	 	//Relationship
	 	WebElement rel = webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_emergencyContact_reletionship"));
 		Select sellectRelationship = new Select(rel);
 		sellectRelationship.selectByVisibleText("Brother");
 		
 		
 		//Mobile
	 	WebElement mob1=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_emergencyContact_mobile"));
	 	mob1.clear();
	 	mob1.sendKeys("9865320158");
	 		 	
	 	//Phone
	 	WebElement phone1=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_emergencyContact_phone"));
	 	phone1.clear();
	 	phone1.sendKeys("0332556868");
	 		 	
	 	//Email
	 	WebElement e3=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_emergencyContact_email"));
	 	e3.clear();
	 	e3.sendKeys("contact3@test.com");
	 	
 		//Notes
	 	WebElement not=webDriver.findElement(By.id("StoreForm-EmployeeContact_actionbean_employeeContact_emergencyContact_notes"));
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
			System.out.println("we are in the Contact Person page");
		}

	}
}
