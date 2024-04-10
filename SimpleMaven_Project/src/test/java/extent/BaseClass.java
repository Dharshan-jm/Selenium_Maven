package extent;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extReports;
	public static ExtentTest test ;
	@BeforeSuite
	public void configReports() {
		String TIME = LocalDateTime.now().toString().replace(":", "-");
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/extentReport_" + TIME + ".html");
		extReports=new ExtentReports();
		extReports.attachReporter(spark);
	}
	@BeforeClass
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
	}
	@BeforeMethod
	public void login(Method method) {
		test = extReports.createTest(method.getName());
		test.log(Status.PASS, "user logged in");
	}
	@AfterMethod
	public void logout() {
		test.log(Status.PASS, "user logged out");
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		extReports.flush();
	}
	
}
