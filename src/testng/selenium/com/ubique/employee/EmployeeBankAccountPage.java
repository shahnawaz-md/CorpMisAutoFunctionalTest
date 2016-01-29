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

public class EmployeeBankAccountPage extends SeleniumWebDriverLoginTests{
	
	public WebDriver webDriver;
	
	Random random = new Random();

	public EmployeeBankAccountPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeEmployeeBankAccount() throws InterruptedException{
		
		//Bank Account Tab
		webDriver.findElement(By.xpath("//a[@title='Bank AC']")).click();
		
		Thread.sleep(5000);
		
		PageTitle();
		
		
		// Adding delay to wait for certain amount of time then hitting the save
			// button
			Thread.sleep(TIMEOUT);
			withOutDataHitStoreButton();
		
		//Employee
		WebElement emp=webDriver.findElement(By.id("actionbean.employeeBankAccount.employee.id.AutoCompleter"));
		emp.sendKeys("first");
		Thread.sleep(5000);
		emp.sendKeys(Keys.DOWN);
		emp.sendKeys(Keys.ENTER);
		
		//Account Type
		WebElement acc = webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_type"));
		Select sellectAccountType = new Select(acc);
		sellectAccountType.selectByVisibleText("Saving Account");
		
		//Bank Name
		WebElement bName=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_bankName"));
		bName.clear();
		bName.sendKeys("Bank Name");
		
		// validating the field length for the company text box
		String flengthBankName = webDriver.findElement(
				By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_bankName"))
				.getAttribute("maxlength");
		String dataBankName = "data"+random;
		if(dataBankName.length()<Integer.parseInt(flengthBankName)){
			System.out.println("The entered data is less then field length(Bank Name)");
		} else {
			System.out.println("the entered data is more then field length(Bank Name)");
		}
		
Thread.sleep(TIMEOUT);
		
		
		//Account Name
		WebElement accName=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_accName"));
		accName.clear();
		accName.sendKeys("Account Name");
				
		//Account Number
		WebElement accNum=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_accNo"));
		accNum.clear();
		accNum.sendKeys("5623897410");
		
		//Account Code
		WebElement accCode=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_accCode"));
		accCode.clear();
		accCode.sendKeys("568923");
		
		//IBAN
		WebElement iban=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_accIBAN"));
		iban.clear();
		iban.sendKeys("123456");
		
		//IFSC
		WebElement ifsc=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_accIFSC"));
		ifsc.clear();
		ifsc.sendKeys("12345656");
		
		//IFSC
		WebElement sw=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_swiftCode"));
		sw.clear();
		sw.sendKeys("1234");
		
		//Currency
		WebElement cur = webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_currencyId"));
		Select sellectCurrency = new Select(cur);
		sellectCurrency.selectByVisibleText("INR ( Indian Rupee )");
		
		//Account Ext
		WebElement accExt=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_accExtRef"));
		accExt.clear();
		accExt.sendKeys("235689");
		
		//Address1
		WebElement add1=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_address1"));
		add1.clear();
		add1.sendKeys("Behala");
		
		//Address2
		WebElement add2=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_address2"));
		add2.clear();
		add2.sendKeys("Behala");
		
		//Address3
		WebElement add3=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_address3"));
		add3.clear();
		add3.sendKeys("Behala");
		
		//LandMark
		WebElement landMark=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_landmark"));
		landMark.clear();
		landMark.sendKeys("Behala");
		
		//Zipcode
		WebElement zip=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_postalCode"));
		zip.clear();
		zip.sendKeys("700056");
		
		//Auto-Complete For Location
	 	WebElement loc=webDriver.findElement(By.id("actionbean.employeeBankAccount.bankAccount.locationId.AutoCompleter"));
	 	loc.sendKeys("kol");
	 	Thread.sleep(3000);
	 	loc.sendKeys(Keys.DOWN);
	 	loc.sendKeys(Keys.ENTER);
	 	
	 	Thread.sleep(5000);
	 	
	 	//Contact Person Name
	 	WebElement name=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_contactPersonName"));
	 	name.clear();
	 	name.sendKeys("Rakesh");
	 	
	 	//Contact Person Type
	 	WebElement cp = webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_contactPersonType"));
	 	Select sellectType = new Select(cp);
	 	sellectType.selectByVisibleText("Others");
	 	
	 	//Phone
	 	WebElement phone=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_phone"));
	 	phone.clear();
	 	phone.sendKeys("0332556896");
	 	
	 	//Mobile
	 	WebElement mob=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_mobile"));
	 	mob.clear();
	 	mob.sendKeys("9865320147");
	 	
	 	//Email
	 	WebElement e=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_email"));
	 	e.clear();
	 	e.sendKeys("contact@test.com");
	 	
	 	//URL
	 	WebElement url=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_url"));
	 	url.clear();
	 	url.sendKeys("https://contact@test.com");
	 	
	 	//Notes
	 	WebElement not=webDriver.findElement(By.id("StoreForm-EmployeeBankAccount_actionbean_employeeBankAccount_bankAccount_note"));
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
			System.out.println("we are in the Bank Account page");
		}
	}

}
