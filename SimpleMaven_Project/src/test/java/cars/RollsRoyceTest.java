package cars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RollsRoyceTest {
	@Test(groups = "system")
	public void launchRollsRoyce() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.rolls-roycemotorcars.com/en_GB/home.html");
		Reporter.log("RollsRoyce launched successfully",true);
	}
}
