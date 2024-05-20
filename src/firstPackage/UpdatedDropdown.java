package firstPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size(); 
		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
		System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		
		int i = 1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
