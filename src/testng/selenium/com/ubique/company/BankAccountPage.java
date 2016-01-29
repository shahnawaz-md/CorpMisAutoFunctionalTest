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

public class BankAccountPage extends SeleniumWebDriverLoginTests {
	
	public WebDriver webDriver;
	
	Random random = new Random();

	public BankAccountPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeBankAccount() throws InterruptedException {
					    
		//Click on Bank Account Tab
		webDriver.findElement(By.xpath("//a[@title='Bank Account']")).click();
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
		// button
		Thread.sleep(TIMEOUT);
		withOutDataHitStoreButton();
		
		//Auto-Complete for Company
		WebElement company=webDriver.findElement(By.id("actionbean.companyBankAccount.company.id.AutoCompleter"));
		company.sendKeys("com");
		Thread.sleep(5000);
		company.sendKeys(Keys.DOWN);
		company.sendKeys(Keys.ENTER);
				
		//Auto-Complete for Office
		WebElement office=webDriver.findElement(By.id("actionbean.companyBankAccount.officeId.AutoCompleter"));
		office.sendKeys("off");
		Thread.sleep(5000);
		office.sendKeys(Keys.DOWN);
		office.sendKeys(Keys.ENTER);
		
		//Bank Name
		WebElement bankName=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_bankName"));
		bankName.clear();
		bankName.sendKeys("Company Bank Name");
	
		
		//Account Type Drop Down
		WebElement accountType = webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_type"));
 		Select sellectAccountType = new Select(accountType);
 		sellectAccountType.selectByVisibleText("Saving Account");
 		
	 	Thread.sleep(5000);
	 	
	 	//Account Name
		WebElement accountName=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_accName"));
		accountName.clear();
		accountName.sendKeys("Company Account Name");
		
		
		//Account Number
		WebElement accountNumber=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_accNo"));
		accountNumber.clear();
		accountNumber.sendKeys("2356897410");
		
		
		//Account Code
		WebElement accountCode=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_accCode"));
		accountCode.clear();
		accountCode.sendKeys("2356");
		
 	
		//IBAN
		WebElement accountIBAN=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_accIBAN"));
		accountIBAN.clear();
		accountIBAN.sendKeys("BEkk BBBC CCCC CCKK");
		
 	
		//IFSC Code
		WebElement accountIFSC=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_accIFSC"));
		accountIFSC.clear();
		accountIFSC.sendKeys("TESTN0001522");
		
		//Swift Code
		WebElement swiftCode=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_swiftCode"));
		swiftCode.clear();
		swiftCode.sendKeys("TEST123");
		
		//Currency
	    WebElement currency = webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_currencyId"));
	 	Select selectCurrency = new Select(currency);
	 	selectCurrency.selectByVisibleText("INR ( Indian Rupee )");
		
	 	Thread.sleep(5000);
	 	
	 	//Address1
	 	WebElement address1=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_address1"));
	 	address1.clear();
	 	address1.sendKeys("Address1");
	 			
	 	//Address2
	 	WebElement address2=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_address2"));
	 	address2.clear();
	 	address2.sendKeys("Address2");
	 	
	 	//Address3
	 	WebElement address3=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_address3"));
	 	address3.clear();
	 	address3.sendKeys("Address3");
	 	
	 	//Zip Code
	 	WebElement zipCode=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_postalCode"));
	 	zipCode.clear();
	 	zipCode.sendKeys("700000");
	 	
	 	//Landmark
	 	WebElement landMark=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_landmark"));
	 	landMark.clear();
	 	landMark.sendKeys("Kalikapur");
	 	
	 	//Auto-Complete For Location
	 	WebElement location=webDriver.findElement(By.id("actionbean.companyBankAccount.bankAccount.locationId.AutoCompleter"));
	 	location.sendKeys("kol");
	 	Thread.sleep(3000);
	 	location.sendKeys(Keys.DOWN);
	 	location.sendKeys(Keys.ENTER);
	 	
	 	Thread.sleep(5000);
	 	
	 	//Contact Person Name
	 	WebElement contactPersonName=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_contactPersonName"));
	 	contactPersonName.clear();
	 	contactPersonName.sendKeys("Contact Person Name");
	 	
	 	//Contact Person Type
	    WebElement contactPersonType = webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_contactPersonType"));
	 	Select selectContactPersonType = new Select(contactPersonType);
	 	selectContactPersonType.selectByVisibleText("Relationship Manager");
	 	
	 	//Phone Number
	 	WebElement phoneNumber=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_phone"));
	 	phoneNumber.clear();
	 	phoneNumber.sendKeys("03324494569");
	 			
	 	//Mobile Number
	 	WebElement mobileNumber=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_mobile"));
	 	mobileNumber.clear();
	 	mobileNumber.sendKeys("9865321047");
	 	
	 	//Email
	 	WebElement email=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_email"));
	 	email.clear();
	 	email.sendKeys("test@test.com");
	 	
	 	//URL
	 	WebElement url=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_url"));
	 	url.clear();
	 	url.sendKeys("https://testtest.com");
	 	
	 	//Notes
	 	WebElement note=webDriver.findElement(By.id("StoreForm-CompanyBankAccount_actionbean_companyBankAccount_bankAccount_note"));
	 	note.clear();
	 	note.sendKeys("Test Test Test Test");
	 	
	 	//Store Button
	 	WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
	 	JavascriptExecutor executor = (JavascriptExecutor)webDriver;
	 	executor.executeScript("arguments[0].click();", element);
	 	
	 	/*String storeButton=webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span")).getText();
	 	webDriver.findElement(By.linkText(storeButton)).click();
	 	*/	 	
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
			System.out.println("we are in the Bank Account page");
		}
	
	}
}