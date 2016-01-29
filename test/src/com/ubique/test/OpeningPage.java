package com.ubique.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class OpeningPage {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","D:\\BiswajitData\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.10.10:8080/corpmis-ui/admin/login");
	}	
	
	@Test
	public void Mo(){
		System.out.println("Hello World");
	}

}
