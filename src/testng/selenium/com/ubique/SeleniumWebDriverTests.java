package testng.selenium.com.ubique;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;

public class SeleniumWebDriverTests extends TestNG{

	public static int STACK_TRACE_METHOD_NAME_INDEX=1;

	public static Long TIMEOUT=5000L;

	protected boolean testResult=true;

	protected String time = String.valueOf(new Date().getTime());

	protected String number = String.valueOf(time);

	protected Long startTime= null;
	protected String currentTestMethod=null;
	protected List<Object> testModels=new ArrayList<Object>();

	protected static WebDriver webDriver;

	protected static WebDriverWait webDriverWait=null;

	 protected StringBuffer verificationErrors = new StringBuffer();

	protected File testOutPutDirectory=new File(".",File.separator+"test-output");

	protected File tesScreenshotDirectory=null;

	protected File testCaseClassDirectory=null;

	protected String testCaseScreenshotFileName=null;

	protected String testCaseScreenshotFileNameSuffix="-"+String.valueOf(time)+".png";
	
	protected String testCaseName=null;

	protected String baseUrl = "http://192.168.10.12:8090/corpmis/admin/login";

}
