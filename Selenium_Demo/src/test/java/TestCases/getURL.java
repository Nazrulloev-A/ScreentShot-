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

import io.github.bonigarcia.wdm.WebDriverManager;

public class getURL {
	
	WebDriver driver;
	

	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://herkul.org/");
	}

	@Test
	public void URl() {
		String URL = driver.getCurrentUrl();
				System.out.println("CurrentUrl of the web is " + URL);
		String Title = driver.getTitle();
		System.out.println("The Title is " + Title);
	}
	
	@Test
	public void LInks() {
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("The links for Web " + allLinks.size()+"links");

         for (WebElement link: allLinks) {
        	 System.out.println(link.getText());
        	 
        	 			// second way 
        	 /*for(int i = 1; i<allLinks.size();i=i+1) {
     			System.out.println(allLinks.get(i).getText());
     			*/
         }
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
