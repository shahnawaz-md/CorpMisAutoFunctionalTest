package testng.selenium.com.ubique;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testng.selenium.com.ubique.company.BankAccountPage;
import testng.selenium.com.ubique.company.CalendarPage;
import testng.selenium.com.ubique.company.CompanyPage;
import testng.selenium.com.ubique.company.ContactPersonPage;
import testng.selenium.com.ubique.company.OfficePage;
import testng.selenium.com.ubique.employee.EmployeePage;
import testng.selenium.com.ubique.employee.PersonalInfoPage;
import testng.selenium.com.ubique.employee.ContactPage;
import testng.selenium.com.ubique.employee.EmployeeBankAccountPage;
import testng.selenium.com.ubique.employee.PassportPage;
import testng.selenium.com.ubique.employee.VisaPage;
import testng.selenium.com.ubique.employee.InsurancePage;
import testng.selenium.com.ubique.employee.EducationPage;
import testng.selenium.com.ubique.consultant.ConsultantPage;
import testng.selenium.com.ubique.contract.ProjectPage;
import testng.selenium.com.ubique.contract.ContractPage;
import testng.selenium.com.ubique.contract.ContractItemPage;
import testng.selenium.com.ubique.employee.EmploymentHistoryPage;
import testng.selenium.com.ubique.employee.SkillPage;
import testng.selenium.com.ubique.employee.DeputationPage;
import testng.selenium.com.ubique.utils.Excelutils;



public class SanityTesting extends SeleniumWebDriverLoginTests{

	//public WebDriver webDriver;
	
	@Test(groups = { "company" },priority=1)//, enabled = false)
	public void companyPage() throws InterruptedException {
		CompanyPage cp =  new CompanyPage(webDriver); //PageFactory.initElements(webDriver, CompanyPage.class);
		cp.storeCompany();
	}
	
	@Test(dataProvider = "OfficeDataEntry",groups = { "company" },priority=2)// dependsOnMethods="companyPage")
	public void officePage(String COMPANYID, String NAME, String ADDRESS1, String ADDRESS2, String ADDRESS3, String POSTALCODE, String GEOCOUNTRYID, String GEOREGIONID, String CITYLOCATIONID, String MOBILE,String EMAIL, String PHONE, String FAX, String URL, String NOTES  ) throws InterruptedException {
		OfficePage op =new OfficePage(webDriver); // PageFactory.initElements(webDriver, OfficePage.class);
		op.storeOffice(COMPANYID, NAME, ADDRESS1, ADDRESS2, ADDRESS3, POSTALCODE, GEOCOUNTRYID, GEOREGIONID, CITYLOCATIONID, MOBILE, EMAIL, PHONE, FAX, URL, NOTES);
	}
	
	
	 @DataProvider(name = "OfficeDataEntry")
	 public Object[][] getNewCompanyData() throws Exception {
	  System.out.println(new File(".").getAbsolutePath());
	  Object[][] cellData = Excelutils.getInstance().readData("D:/workspace/corpmis-autoFunctionalTest/src/COMANYOFFICES1.xls", 0);
	  System.out.println("MMMMMM : " + cellData);
	  return cellData;
	 }

	
	
	@Test(groups = { "company" },priority=3, dependsOnMethods={"companyPage","officePage"},enabled=false)
	public void contactPersonPage() throws InterruptedException {
		ContactPersonPage con =new ContactPersonPage(webDriver); // PageFactory.initElements(webDriver, OfficePage.class);
		con.storeContactPerson();
	}
	
	@Test(groups = { "company" },priority=4, dependsOnMethods={"companyPage","officePage"},enabled=false)
	public void bankAccountPage() throws InterruptedException {
		BankAccountPage bank =new BankAccountPage(webDriver); // PageFactory.initElements(webDriver, OfficePage.class);
		bank.storeBankAccount();
	}

	@Test(groups = { "company" },priority=5, dependsOnMethods={"companyPage","officePage"},enabled=false)
	public void calendarPage() throws InterruptedException {
		CalendarPage cal =new CalendarPage(webDriver); // PageFactory.initElements(webDriver, OfficePage.class);
		cal.storeCalendar();
	}
	
	@Test(groups = { "employee" },enabled=false)//, priority=6, dependsOnGroups = "company", dependsOnMethods="companyPage")
	public void employeePage() throws InterruptedException {
		EmployeePage emp =new EmployeePage(webDriver); // PageFactory.initElements(webDriver, OfficePage.class);
		emp.storeEmployee();
	}
	
	@Test(groups = { "employee" }, priority=7,dependsOnMethods="employeePage",enabled=false)
	public void PersonalInfoPage() throws InterruptedException {
		PersonalInfoPage per =new PersonalInfoPage(webDriver);
		per.storePersonalInfo();
	}
	
	@Test(groups = { "employee" }, priority=8, dependsOnMethods="employeePage",enabled=false)
	public void ContactPage() throws InterruptedException {
		ContactPage c =new ContactPage(webDriver);
		c.storeContact();
	}
	
	@Test(groups = { "employee" }, priority=9,dependsOnMethods="employeePage",enabled=false)
	public void EmployeeBankAccountPage() throws InterruptedException {
		EmployeeBankAccountPage b =new EmployeeBankAccountPage(webDriver);
		b.storeEmployeeBankAccount();
	}
	
	@Test(groups = { "employee" }, priority=10,dependsOnMethods="employeePage",enabled=false)
	public void PassportPage() throws InterruptedException {
		PassportPage b =new PassportPage(webDriver);
		b.storePassport();
	}
	
	@Test(groups = { "employee" }, priority=11,dependsOnMethods="employeePage",enabled=false)
	public void VisaPage() throws InterruptedException {
		VisaPage v =new VisaPage(webDriver);
		v.storeVisa();
	}
	
	@Test(groups = { "employee" }, priority=12,dependsOnMethods="employeePage",enabled=false)
	public void InsurancePage() throws InterruptedException {
		InsurancePage ins =new InsurancePage(webDriver);
		ins.storeInsurance();
	}
	
	@Test(groups = { "employee" }, priority=13,dependsOnMethods="employeePage",enabled=false)
	public void EducationPage() throws InterruptedException {
		EducationPage edu =new EducationPage(webDriver);
		edu.storeEducation();
	}
	
	@Test(groups = { "employee" }, priority=14,dependsOnMethods="employeePage",enabled=false)
	public void EmploymentHistoryPage() throws InterruptedException {
		EmploymentHistoryPage edu =new EmploymentHistoryPage(webDriver);
		edu.storeEmploymentHistory();
	}
	
	@Test(groups = { "employee" }, priority=15,dependsOnMethods="employeePage",enabled=false)
	public void SkillPage() throws InterruptedException {
		SkillPage edu =new SkillPage(webDriver);
		edu.storeSkill();
	}
	
	@Test(groups = { "employee" }, priority=16,dependsOnMethods={"employeePage"},enabled=false)//,"companyPage","officePage"})
	public void DeputationPage() throws InterruptedException {
		DeputationPage dep =new DeputationPage(webDriver);
		dep.storeDeputation();
	}
	
	@Test(groups = { "consultant" },priority=17, dependsOnMethods="companyPage",enabled=false)
	public void ConsultantPage() throws InterruptedException {
		ConsultantPage con =new ConsultantPage(webDriver);
		con.storeConsultant();
	}
	
	@Test(groups = { "contract" },priority=18,dependsOnMethods="companyPage",enabled=false)
	public void projectPage() throws InterruptedException {
		ProjectPage con =new ProjectPage(webDriver);
		con.storeProject();
	}
	
	@Test(groups = { "contract" },priority=19, dependsOnMethods="projectPage",enabled=false)
	public void contractPage() throws InterruptedException {
		ContractPage con =new ContractPage(webDriver);
		con.storeContract();
	}
	
	@Test(groups = { "contract" },priority=20, dependsOnMethods="contractPage",enabled=false)
	public void contractItemPage() throws InterruptedException {
		ContractItemPage con =new ContractItemPage(webDriver);
		con.storeContractItem();
	}
	
}
