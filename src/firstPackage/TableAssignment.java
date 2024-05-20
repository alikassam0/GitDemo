package firstPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());  
		System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size()); 
		List<WebElement> courses = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[2]"));
		for (WebElement element : courses) {
			System.out.println(element.getText());
		}
	}

}
