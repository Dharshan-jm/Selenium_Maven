package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParameterTest {
	@Test
	public void recieveData() {
		String URL = System.getProperty("url");
		System.out.println(URL);
		WebDriver driver=new ChromeDriver();
		
		driver.get(URL);
	}
}
