package extent;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddSSInExtentReport {
	@Test
	public void screenshot() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshotPath = ts.getScreenshotAs(OutputType.BASE64);
		
		//@BS
		// step 1: create an instance of ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/SSreport.html");
		
		// step 2: create an instance of ExtentReports
		ExtentReports extReports=new ExtentReports();
		
		// step 3: attach ExtentSparkReporter into ExtentReports
		extReports.attachReporter(spark);
		
		//@BM
		// step 4: create an instance of ExtentTest 
		ExtentTest test = extReports.createTest("screenshot");
		
		//@Test
		// step 5: add log message into reports
		test.log(Status.INFO, "Screenshot added");
		test.addScreenCaptureFromBase64String(screenshotPath);
		
		
		//@AS
		// step 6: call flush()
		extReports.flush();
	}
}
