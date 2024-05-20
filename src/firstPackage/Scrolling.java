package firstPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		int sumNumbers = 0;
		for (int i = 0; i < values.size(); i++) { 
			sumNumbers += Integer.parseInt(values.get(i).getText());
		}
		String amountMessage = driver.findElement(By.className("totalAmount")).getText();
		String[] amountMessageSplit = amountMessage.split(":");
		Assert.assertEquals(sumNumbers, Integer.parseInt(amountMessageSplit[1].trim()));
	}

}
