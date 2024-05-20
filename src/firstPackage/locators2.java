package firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators2 {
	

		public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get("http://rahulshettyacademy.com/locatorspractice/");
			//driver.findElement(By.id("inputUsername")).sendKeys("rahul");
			//driver.findElement(By.name("inputPassword")).sendKeys("hello123");
			//driver.findElement(By.className("signInBtn")).click();
			//System.out.println(driver.findElement(By.cssSelector("p.error")));
			
		
		
	}

}
