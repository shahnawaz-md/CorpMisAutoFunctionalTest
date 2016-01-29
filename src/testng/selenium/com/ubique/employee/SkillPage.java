package testng.selenium.com.ubique.employee;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testng.selenium.com.ubique.SeleniumWebDriverLoginTests;

public class SkillPage extends SeleniumWebDriverLoginTests{
	
	public WebDriver webDriver;

	public SkillPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void storeSkill() throws InterruptedException{
		
		
		
	    //Skill Tab
	    webDriver.findElement(By.xpath("//a[@title='Skill']")).click();
		Thread.sleep(5000);
		
		PageTitle();
		
		// Adding delay to wait for certain amount of time then hitting the save
				// button
				Thread.sleep(TIMEOUT);
				withOutDataHitStoreButton();
		
		//Auto-Complete For Employee
		WebElement employee=webDriver.findElement(By.id("actionbean.skill.employee.id.AutoCompleter"));
		employee.sendKeys("first");
		Thread.sleep(5000);
		employee.sendKeys(Keys.DOWN);
		employee.sendKeys(Keys.ENTER);
		
		//Skill Type
	 	WebElement skill = webDriver.findElement(By.id("StoreForm-Skill_actionbean_skill_type"));
 		Select selectSkillType = new Select(skill);
 		selectSkillType.selectByVisibleText("Primary");
 		
 		//Year Of Experience
 		WebElement exp=webDriver.findElement(By.id("StoreForm-Skill_actionbean_skill_yearOfExperience"));
 		exp.clear();
 		exp.sendKeys("2");
 		
 		//Key Skills
 		WebElement key=webDriver.findElement(By.id("StoreForm-Skill_actionbean_skill_name"));
 		key.clear();
 		key.sendKeys("Manual Testing, Automation Testing");
 		
 		//Details
 		WebElement des=webDriver.findElement(By.id("StoreForm-Skill_actionbean_skill_descriptions"));
 		des.clear();
 		des.sendKeys("Test Test Test Test");
 		
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
			System.out.println("we are in the Skill page");
		}
	}
	
	

}
