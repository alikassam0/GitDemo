package firstPackage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.cssSelector("button.signInBtn")).click();
		 System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		 driver.findElement(By.linkText("Forgot your password?")).click();
		 driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		 driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@email.com");
		 //driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		 driver.findElement(By.xpath("//form/input[3]")).sendKeys("2223334455");
		 driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		 System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		 String infoMsg = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		 String[] infoMsgSplit = infoMsg.split("'");
		 System.out.println(infoMsgSplit[1]);
		 driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		 driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		 driver.findElement(By.name("inputPassword")).sendKeys(infoMsgSplit[1]);
		 driver.findElement(By.cssSelector("input[value='rmbrUsername']")).click();
		 driver.findElement(By.cssSelector("input[value='agreeTerms']")).click();
		 driver.findElement(By.cssSelector("button.submit")).click();
	}
	
}



		
		
		
	}