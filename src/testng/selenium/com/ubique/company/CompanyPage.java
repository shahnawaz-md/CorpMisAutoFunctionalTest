package testng.selenium.com.ubique.company;


import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class CompanyPage extends SeleniumWebDriverLoginTests {
	
	private String autoCompanyName="CompanyName" + number;
	private String autoCompanyCode="CompanyCode" + number;
	
	public WebDriver webDriver;
	
	Random random = new Random();
	
	
	public CompanyPage(WebDriver webDriver) {
                this.webDriver= webDriver;
	}
	
	/*@FindBy (id="StoreForm-Company_actionbean_company_category")
	WebElement categoryType;*/
	
	//@Test(priority = 1)
	public void storeCompany() throws InterruptedException {
		webDriver.get(baseUrl+"home");
	
	   	    
		WebElement companyMenulink=webDriver.findElement(By.linkText("Company"));
	    WebElement companySubMenulink=webDriver.findElement(By.xpath(".//*[@id='headerPan']/div[4]/ul/li[1]/ul/li[2]/a"));
	   
	    Actions actions = new Actions(webDriver);
	    actions.moveToElement(companyMenulink);

	    
	    actions.moveToElement(companySubMenulink);
	    actions.build().perform();
	    webDriver.get(baseUrl+"company/home?actionbean.tindex=1");
	    
	    // Selecting the value form the Drop Down List of Category Type
	 	/*WebElement categoryWebElement = webDriver.findElement(By.id("StoreForm-Company_actionbean_company_category"));
	 	Select sellectCatagory = new Select(categoryWebElement);
	 	sellectCatagory.selectByVisibleText("External");*/
	 	
 	    Thread.sleep(TIMEOUT);
 	    
 	    
 	// Adding delay to wait for certain amount of time then hitting the save
 			// button
 			Thread.sleep(TIMEOUT);
 			withOutDataHitStoreButton();
 		
 			
 	    // Selecting the value form the Drop Down List of Company Type
 		WebElement typeWebElement = webDriver.findElement(By.id("StoreForm-Company_actionbean_company_type"));
 		Select sellectType = new Select(typeWebElement);
 		sellectType.selectByVisibleText("Internal");
 		
 		//Thread.sleep(TIMEOUT);
 	    // Selecting the value form the Drop Down List of Company Group
 		/*WebElement groupWebElement = webDriver.findElement(By.id("StoreForm-Company_actionbean_company_groupId"));
 		Select sellectGroup = new Select(groupWebElement);		  
 		sellectGroup.selectByVisibleText("Supplier");*/
 	    
 		Thread.sleep(TIMEOUT);
 		
 		//Company Name
 		webDriver.findElement(By.id("StoreForm-Company_actionbean_company_name")).clear();
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_name")).sendKeys(autoCompanyName);
	    

		// validating the field length for the company text box
				String flengthCompanyName = webDriver.findElement(
						By.id("StoreForm-Company_actionbean_company_name"))
						.getAttribute("maxlength");
				String dataCompanyName = "data"+random;
				if(dataCompanyName.length()<Integer.parseInt(flengthCompanyName)){
					System.out.println("The entered data is less then field length(Company Name)");
				} else {
					System.out.println("the entered data is more then field length(Company Name)");
				}
				
		Thread.sleep(TIMEOUT);
	  
	    //Company Code
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_code")).clear();
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_code")).sendKeys(autoCompanyCode);
	  
	    //validation for authentic company code
	    
	   String companyCode = "123456789";
			   webDriver.findElement(By.id("StoreForm-Company_actionbean_company_code")).sendKeys(companyCode);
			   
			   Thread.sleep(TIMEOUT);
			  // String ActualerrorMessage = "Please fix this field. Already exists.";
			   if(webDriver.getPageSource().contains("Please fix this field. Already exists.")){
				   System.out.println("The message is displaying on screen");
			   }else{
				   System.out.println("There is no message");
			   }
	  
	 // validating the field length for the company text box
		String flengthCompanyCode = webDriver.findElement(
				By.id("StoreForm-Company_actionbean_company_name"))
				.getAttribute("maxlength");
		String dataCompanyCode = "data"+random;
		if(dataCompanyCode.length()<Integer.parseInt(flengthCompanyCode)){
			System.out.println("The entered data is less then field length(Company Code)");
		} else {
			System.out.println("the entered data is more then field length(Company Code)");
		}
		
Thread.sleep(TIMEOUT);



	    
	    //Number Of Employee
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_numOfEmployees")).clear();
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_numOfEmployees")).sendKeys("1000");
	    //Tax Ref Number
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_taxRefNo")).clear();
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_taxRefNo")).sendKeys("125689");
	    
	    //Annual Turnover
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_annualTurnover")).clear();
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_annualTurnover")).sendKeys("1 Crore");
	    
	    //Company Web URL
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_webUrl")).clear();
	    webDriver.findElement(By.id("StoreForm-Company_actionbean_company_webUrl")).sendKeys("http://www.ubiquetest1.com");

	 	//Selecting the value form the Drop Down List of Currency
	    WebElement currencyWebElement = webDriver.findElement(By.id("StoreForm-Company_actionbean_company_currencyId"));
	 	Select selectCurrency = new Select(currencyWebElement);
	 	selectCurrency.selectByVisibleText("INR ( Indian Rupee )");
	 	
	 	//Auto-Complete Tax Authority
//	 	webDriver.findElement(By.id("StoreForm-Company_actionbean_company_taxAuthorityId_AutoCompleter")).sendKeys("Service");
//	 	Thread.sleep(3000);
//	 	webDriver.findElement(By.id("StoreForm-Company_actionbean_company_taxAuthorityId_AutoCompleter")).sendKeys(Keys.DOWN);
//        webDriver.findElement(By.id("StoreForm-Company_actionbean_company_taxAuthorityId_AutoCompleter")).sendKeys(Keys.ENTER);

      	Thread.sleep(TIMEOUT);
	 	
	 	//Selecting the value form the Drop Down List of Invoice Report Template
//	 	WebElement invoiceReportElement = webDriver.findElement(By.id("StoreForm-Company_actionbean_company_invoiceReportTemplateId"));
//		Select sellectInvoiceReport = new Select(invoiceReportElement);
//		sellectInvoiceReport.selectByVisibleText("Invoice Report");
		
	 	
		//MSA Signed
		webDriver.findElement(By.id("StoreForm-Company_actionbean_company_msaSigned")).click();
		
		
		//Notes
		webDriver.findElement(By.id("StoreForm-Company_actionbean_company_notes")).clear();
		webDriver.findElement(By.id("StoreForm-Company_actionbean_company_notes")).sendKeys("Test test test.");
		
		//Store Button
		WebElement element = webDriver.findElement(By.xpath("//ul[@id='tools']/li[2]/a/span"));
	 	JavascriptExecutor executor = (JavascriptExecutor)webDriver;
	 	executor.executeScript("arguments[0].click();", element);
	 	
	 	Thread.sleep(TIMEOUT);
	 	
	 	Thread.sleep(TIMEOUT);
		Alert alert = webDriver.switchTo().alert();
	 	alert.accept();
	 	
	 	Thread.sleep(TIMEOUT);
	 	Thread.sleep(TIMEOUT);

		
	}
/*	
	public void verifyTextPresent(String errorMessage)
	{
	webDriver.getPageSource().contains(errorMessage) ;
	}
	*/
	
}
