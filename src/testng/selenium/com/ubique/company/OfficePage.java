package testng.selenium.com.ubique.company;

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

public class OfficePage extends SeleniumWebDriverLoginTests {

//	private String autoOfficeName = "OfficeName" + number;
	//private String autoEmailId = "autoemailid" + number + "@test.com";
	private WebDriver webDriver;

	Random random = new Random();

	public OfficePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void storeOffice(String COMPANY_ID, String NAME, String ADDRESS1,
			String ADDRESS2, String ADDRESS3, String POSTAL_CODE,
			String GEO_COUNTRY_ID, String GEO_REGION_ID,
			String CITY_LOCATION_ID, String MOBILE, String EMAIL, String PHONE,
			String FAX, String URL, String NOTES) throws InterruptedException {
		
	     webDriver.get(baseUrl+"home");
			
	   	  	WebElement projectMenulink=webDriver.findElement(By.linkText("Company"));
		    WebElement projectSubMenulink=webDriver.findElement(By.xpath(".//*[@id='headerPan']/div[4]/ul/li[1]/ul/li[3]/a"));
		   
		    Actions actions = new Actions(webDriver);
		    actions.moveToElement(projectMenulink);

		    
		    actions.moveToElement(projectSubMenulink);
		    actions.build().perform();
		    webDriver.get(baseUrl+"company/home?actionbean.tindex=2");
		    
		 // OfficeTab.click();
			//webDriver.findElement(By.xpath("//a[@title='Offices']")).click();
			Thread.sleep(5000);
			
			PageTitle();

			// Adding delay to wait for certain amount of time then hitting the save
			// button
			Thread.sleep(TIMEOUT);
			withOutDataHitStoreButton();
	


		// Auto-Complete For Company Name
		webDriver.findElement(
				By.id("actionbean.office.company.id.AutoCompleter")).sendKeys(COMPANY_ID);
		Thread.sleep(5000);
		webDriver.findElement(
				By.id("actionbean.office.company.id.AutoCompleter")).sendKeys(
				Keys.DOWN);
		webDriver.findElement(
				By.id("actionbean.office.company.id.AutoCompleter")).sendKeys(
				Keys.ENTER);

		// Auto-Complete For Office Name
		webDriver.findElement(By.id("StoreForm-Office_actionbean_office_name"))
				.clear();
		webDriver.findElement(By.id("StoreForm-Office_actionbean_office_name"))
				.sendKeys(NAME);

		// validating the field length for the company text box
		String flengthOfficeName = webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_name")).getAttribute(
				"maxlength");
		String dataOfficeName = "data" + random;
		if (dataOfficeName.length() < Integer.parseInt(flengthOfficeName)) {
			System.out
					.println("The entered data is less then field length(Office Name)");
		} else {
			System.out
					.println("the entered data is more then field length(Office Name)");
		}

		Thread.sleep(TIMEOUT);

		// Drop Down For Office Type
		WebElement officeType = webDriver.findElement(By
				.id("StoreForm-Office_actionbean_office_type"));
		Select sellectOfficeType = new Select(officeType);
		sellectOfficeType.selectByVisibleText("Branch Office");

		// Address1
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_address1")).clear();
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_address1")).sendKeys(ADDRESS1);

		// validating the field length for the company text box
		String flengthAddress1 = webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_name")).getAttribute(
				"maxlength");
		String dataAddress1 = "data" + random;
		if (dataAddress1.length() < Integer.parseInt(flengthAddress1)) {
			System.out
					.println("The entered data is less then field length(Address1)");
		} else {
			System.out
					.println("the entered data is more then field length(Address1)");
		}

		Thread.sleep(TIMEOUT);

		// Address2
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_address2")).clear();
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_address2")).sendKeys(ADDRESS2);

		// Address3
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_address3")).clear();
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_address3")).sendKeys(ADDRESS3);

		// Zip Code
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_postalCode")).clear();
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_postalCode"))	.sendKeys(POSTAL_CODE);

		// Auto-Complete For Location
		webDriver.findElement(
				By.id("actionbean.office.countryId.AutoCompleter")).sendKeys(GEO_COUNTRY_ID);
		Thread.sleep(3000);
		webDriver.findElement(
				By.id("actionbean.office.regionId.AutoCompleter")).sendKeys(GEO_REGION_ID);
		webDriver.findElement(
				By.id("actionbean.office.locationId.AutoCompleter")).sendKeys(CITY_LOCATION_ID);

		Thread.sleep(5000);

		// Mobile Number
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_mobile")).clear();
		webDriver.findElement(
				By.id("StoreForm-Office_actionbean_office_mobile")).sendKeys(MOBILE);

		// Email
		webDriver
				.findElement(By.id("StoreForm-Office_actionbean_office_email"))
				.clear();
		webDriver
				.findElement(By.id("StoreForm-Office_actionbean_office_email"))
				.sendKeys(EMAIL);
		
		// Phone Number
				webDriver
						.findElement(By.id("StoreForm-Office_actionbean_office_phone"))
						.clear();
				webDriver
						.findElement(By.id("StoreForm-Office_actionbean_office_phone"))
						.sendKeys(PHONE);
		//Fax Number
				
				webDriver
				.findElement(By.id("StoreForm-Office_actionbean_office_fax"))
				.clear();
		webDriver
				.findElement(By.id("StoreForm-Office_actionbean_office_fax"))
				.sendKeys(FAX);

		// URL
		webDriver.findElement(By.id("StoreForm-Office_actionbean_office_url"))
				.clear();
		webDriver.findElement(By.id("StoreForm-Office_actionbean_office_url"))
				.sendKeys(URL);

		// Store Button
		WebElement element = webDriver.findElement(By
				.xpath("//ul[@id='tools']/li[2]/a/span"));
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", element);

		/*
		 * String storeButton=webDriver.findElement(By.xpath(
		 * "//ul[@id='tools']/li[2]/a/span")).getText();
		 * webDriver.findElement(By.linkText(storeButton)).click();
		 */

		Thread.sleep(TIMEOUT);

		Alert alert = webDriver.switchTo().alert();
		alert.accept();

		Thread.sleep(TIMEOUT);
		Thread.sleep(TIMEOUT);
	}

	public void PageTitle() {

		String actualPageTitle = webDriver.getTitle();
		String expectedPageTitle = "Corp MIS - Company - Home";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		{
			System.out.println("we are in the office page");
		}
	}

}
