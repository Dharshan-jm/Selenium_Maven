package itcompanies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InfosysTest {
	@Test
	public void launchInfosys() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.infosys.com/");
		Reporter.log("Infosys launched successfully",true);
	}
}
