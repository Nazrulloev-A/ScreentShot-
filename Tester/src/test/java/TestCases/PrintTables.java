package TestCases;


import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import PadgeObjectModels.MainpaGeLoginObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintTables {
	
	WebDriver driver;
	
	
	
	@BeforeTest
   public void setUp() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
   }
	
	@Test
	public void Login() {
		MainpaGeLoginObjects login = new MainpaGeLoginObjects(driver);
		login.username.sendKeys("Tester");
		login.password.sendKeys("test");
		login.logIn.click();
		
		
	}
	
	
	@Test (groups = { "functionalTest" })
	
	public void printTables() {
		/*for(WebElement tableData:driver.findElements(By.tagName("tr")))
			System.out.println(tableData.getText());
			*/
		
	WebElement link= driver.findElement(By.xpath("//body//tr[2]"));
		System.out.println(link.getText());
		
//		String name = driver.findElement(By.xpath("//body//tr[3]")).getText();
//		System.out.println(name);
		
		
			
		}
		
			
	
   

	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
