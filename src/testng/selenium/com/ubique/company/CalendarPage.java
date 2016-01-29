package testng.selenium.com.ubique.company;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class CalendarPage extends SeleniumWebDriverLoginTests {
	
	public WebDriver webDriver;

	public CalendarPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeCalendar() throws InterruptedException {
				  
		//Holiday Tab
		webDriver.findElement(By.xpath("//a[@title='Holidays']")).click();
		Thread.sleep(5000);
				
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
				// button
				Thread.sleep(TIMEOUT);
				withOutDataHitStoreButton();
		
		//Auto-Complete for Company
		WebElement company=webDriver.findElement(By.id("actionbean.calendar.company.id.AutoCompleter"));
		company.sendKeys("com");
		Thread.sleep(5000);
		company.sendKeys(Keys.DOWN);
		company.sendKeys(Keys.ENTER);
						
		//Auto-Complete for Office
		WebElement office=webDriver.findElement(By.id("actionbean.calendar.officeId.AutoCompleter"));
		office.sendKeys("off");
		Thread.sleep(5000);
		office.sendKeys(Keys.DOWN);
		office.sendKeys(Keys.ENTER);
		
		//Holidays Name
		WebElement holidayName=webDriver.findElement(By.id("StoreForm-Calendar_actionbean_calendar_name"));
		holidayName.clear();
		holidayName.sendKeys("Holiday Name");
		
		//Day Types
	    /*WebElement dayTypes = webDriver.findElement(By.id("StoreForm-Calendar_actionbean_calendar_type"));
	 	Select selectDayTypes = new Select(dayTypes);
	 	selectDayTypes.selectByVisibleText("Holiday");*/
	 	
	 	Thread.sleep(5000);
	 	
	 	//Calendar
	  	webDriver.findElement(By.name("actionbean.calendar.date")).click();
	 	
	  
	  	//For Year
	  	 	WebElement year = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]"));
		 	Select selectYear = new Select(year);
		 	selectYear.selectByValue("2006");
			  	 			 		
	 		Thread.sleep(5000);
	 		
	 		//For Month
	 		WebElement month = webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]"));
		 	Select selectMonth = new Select(month);
		 	selectMonth.selectByValue("1");
		 	webDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[3]/a")).click();
		 	
	 		Thread.sleep(5000);
	 		
	 	//Notes
	 	WebElement note=webDriver.findElement(By.id("StoreForm-Calendar_actionbean_calendar_notes"));
	 	note.click();
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
	 			
	}
	public void PageTitle(){
		
		String actualPageTitle = webDriver.getTitle();
		String expectedPageTitle = "Corp MIS - Company - Home";
		Assert.assertEquals(actualPageTitle,expectedPageTitle);{
			System.out.println("we are in the Calender page");
		}
	}
}