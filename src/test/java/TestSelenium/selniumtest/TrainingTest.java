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


public class TrainingTest  {
	
	static WebDriver driver=null;	
	static String urlParam="http://ethanadmin:bKwNaylfsHOcyO8d89@capf-1308302777.ap-southeast-2.elb.amazonaws.com/gitlab/users/sign_in";
	static String userName="root";
	static String password="bKwNaylfsHOcyO8d89";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
		// LoginJenkinsApp();
		 loginGitlab();		
		 createNewGitProject();		 
		// deleteGitLabProject();
		 driver.quit();	 
	}
	
		private static void createNewGitProject() {
			
			 driver.findElement(By.xpath("//div[@id='content-body']//a[text()='New project']")).click();
			String AutGenProject="auttestmay"+String.valueOf(Math.random()).substring(2, 9);
			System.out.println("AUtgenerated Project is ---------->::"+AutGenProject);
			 driver.findElement(By.xpath("//div[@id='blank-project-name']//*[@id='project_name']")).sendKeys(AutGenProject);
		
			 driver.findElement(By.xpath("(//form[@id='new_project']//input[@id='project_visibility_level_20'])[1]")).click();
			 driver.findElement(By.xpath("(//input[@value='Create project'])[1]")).click();
			 JavascriptExecutor js=(JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[normalize-space(text())='Settings']")));
			// explictWait(driver,"//span[normalize-space(text())='Settings']");
			 driver.findElement(By.xpath("//span[normalize-space(text())='Settings']")).click();
			 explictWait(driver,"//a[@title='CI / CD']//span[normalize-space(text())='CI / CD']");
			 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@title='CI / CD']//span[normalize-space(text())='CI / CD']")));
				
			 driver.findElement(By.xpath("//a[@title='CI / CD']//span[normalize-space(text())='CI / CD']")).click();
			 explictWait(driver,"//h4[normalize-space(text())='Auto DevOps']/following-sibling::button");
			 driver.findElement(By.xpath("//h4[normalize-space(text())='Auto DevOps']/following-sibling::button")).click();
			//verify if check box enabled	
			 boolean check=driver.findElement(By.id("project_auto_devops_attributes_enabled")).isSelected();
			 System.out.println("Devsecops CHeck box status----------->"+check);
			 if(check)
				 driver.findElement(By.id("project_auto_devops_attributes_enabled")).click();
			
			 driver.findElement(By.xpath("//div[contains(@class,'card-footer js-extra-settings true')]//following::input[@value='Save changes']")).click();
			
			 explictWait(driver,"//span[normalize-space(text())='Members']");
			 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[normalize-space(text())='Members']")));
				
			 driver.findElement(By.xpath("//span[normalize-space(text())='Members']")).click();
			 //Add Ethan member
			 Select selct=new Select(driver.findElement(By.id("access_level")));
			 selct.selectByVisibleText("Maintainer");
			
			 driver.findElement(By.id("s2id_autogen2")).click();
			
			 explictWait(driver, "//*[normalize-space(text())='ethanadmin']");
			 Actions action=new Actions(driver);
			 action.moveToElement(driver.findElement(By.xpath("//*[normalize-space(text())='ethanadmin']"))).click().build().perform();;
			 explictWait(driver, "//*[@value='Add to project']");
			 driver.findElement(By.xpath("//*[@value='Add to project']")).click();
			 System.out.println("New Project Created Successfully in Git Lab...");			
				 
	}

		public static void loginGitlab()
		{
			
			 driver.get(urlParam);
			 String title=driver.getTitle();
			 System.out.println("Tttile::"+title);
			 driver.findElement(By.xpath("//a[text()='Standard']")).click();
			 driver.findElement(By.id("user_login")).sendKeys(userName);
			 driver.findElement(By.id("user_password")).sendKeys(password);		
			 driver.findElement(By.xpath("//input[@value='Sign in'][@data-qa-selector='sign_in_button']")).click();;
		}
		
	public static void LoginJenkinsApp()
	{
		
		 driver.get("http://ethanadmin:bKwNaylfsHOcyO8d89@capf-1308302777.ap-southeast-2.elb.amazonaws.com/jenkinscore");
		 String title=driver.getTitle();
		 System.out.println("Tttile::"+title);
		 
	}
	
	
	private static void deleteGitLabProject() {
		//*[normalize-space(text())='Advanced']/following-sibling::button
		List users=driver.findElements(By.xpath(""));
		
		
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[normalize-space(text())='Settings']")));
		// explictWait(driver,"//span[normalize-space(text())='Settings']");
		 driver.findElement(By.xpath("//span[normalize-space(text())='Settings']")).click();
		 explictWait(driver,"//h4[normalize-space(text())='Advanced']/following-sibling::button");
		 driver.findElement(By.xpath("//h4[normalize-space(text())='Advanced']/following-sibling::button")).click();
	
		 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@value='Remove project']")));
			
		 driver.findElement(By.xpath("//input[@value='Remove project']")).click();
		 
		
		 driver.findElement(By.xpath("//input[@id='confirm_name_input']")).sendKeys("");;
			
			
	}
	
	//GENERIC METHODS BELOW
	public void threadSleep(long seconds)
	{
		
   try {
	Thread.sleep(seconds);
   } catch (InterruptedException e) {

	e.printStackTrace();
   }
	}
	
	public static void explictWait(WebDriver driver,String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
     
	}

}


