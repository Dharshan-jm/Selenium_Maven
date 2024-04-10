package itcompanies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TcsTest {
	@Test
	public void launchTcs() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.tcs.com/");
		Reporter.log("Tcs launched successfully",true);
	}
}
