package TestCases;


import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import PadgeObjectModels.MainpaGeLoginObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;
	private Object names;
	
	
	@BeforeTest
   public void setUp() {
	   WebDriverManager.iedriver().setup();
	   driver = new InternetExplorerDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
   }
	
	@Test(groups = {"smokeTest"})
	public void Login() {
		MainpaGeLoginObjects login = new MainpaGeLoginObjects(driver);
		login.username.sendKeys("Tester");
		login.password.sendKeys("test");
		login.logIn.click();
		
		
	}
	
	
	@Test
	
	public void captureScreen() throws Exception {
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/Users/abrahamben/Desktop/NY/Tester/src/test/resources/ScreenShot/"+ System.currentTimeMillis()+".png"));
	}
	
	
	
	
//	@Test
//	
//	public void printTables() {
//		/*for(WebElement tableData:driver.findElements(By.tagName("tr")))
//			System.out.println(tableData.getText());
//			*/
//		
//	List<WebElement> link= driver.findElements(By.xpath("//body//tr[2]"));
//		System.out.println(link.size());
//		
//		String name = driver.findElement(By.xpath("//body//tr[3]")).getText();
//		System.out.println(name);
//		
//		
//			
//		}
		
			
	
   

	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
