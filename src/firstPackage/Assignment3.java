package firstPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Assignment3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String OptionText = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		WebElement example = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(example);
		dropdown.selectByVisibleText(OptionText);
		driver.findElement(By.id("name")).sendKeys(OptionText);
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if (alertText.contains(OptionText)) {
			System.out.println("Test Passes");
		}
	}
}
