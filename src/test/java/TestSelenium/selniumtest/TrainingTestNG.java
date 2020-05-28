package TestSelenium.selniumtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TrainingTest  {
	static WebDriver driver=null;	
  @Test
	private static void type4() {
	

System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
		// LoginJenkinsApp();
		driver.get("https://www.google.co.in/");	 
		// deleteGitLabProject();
		 driver.quit();	 
  }
}
