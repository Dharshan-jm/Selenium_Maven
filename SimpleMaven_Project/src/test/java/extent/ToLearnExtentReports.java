package extent;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ToLearnExtentReports {
	@Test
	public void report() {
		String TIME = LocalDateTime.now().toString().replace(":", "-");
		
		// step 1: create an instance of ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/extentReport_"+TIME+".html");
		spark.config().setDocumentTitle("DemoReport");
		spark.config().setTheme(Theme.DARK);
		
		// step 2: create an instance of ExtentReports
		ExtentReports extReports=new ExtentReports();
		
		// step 3: attach ExtentSparkReporter to ExtentReports
		extReports.attachReporter(spark);
		
		// step 4: create an instance of ExtentTest
		ExtentTest test = extReports.createTest("report");
		
		// step 5: add log message into report
		test.log(Status.PASS, "log message added into report");
		
		// step 6: call flush()
		extReports.flush();
	}
}
