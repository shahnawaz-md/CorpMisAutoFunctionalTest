package testng.selenium.com.ubique.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class Department extends SeleniumWebDriverLoginTests {

	
	private WebDriver webDriver;
	
	public Department(WebDriver webDriver) {
		this.webDriver = webDriver;
	}


	@Test
	public void departmentAdd(){
		
		webDriver.findElement(By.id("StoreForm-Department_actionbean_department_company_id_AutoCompleter")).sendKeys("CompanyWeb");
		webDriver.findElement(By.id("")).sendKeys(Keys.DOWN);
		webDriver.findElement(By.id("")).sendKeys(Keys.ENTER);
		
		logout();
		
	}
       
	
}
