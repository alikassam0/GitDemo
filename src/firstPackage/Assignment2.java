package firstPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("ali kassam");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("fake@email.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("fakepw");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genderDropdown = new Select(dropdown);
		genderDropdown.selectByVisibleText("Female");
		driver.findElement(By.xpath("//input[@id=\'inlineRadio2']")).click();
		driver.findElement(By.name("bday")).sendKeys("01012000");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		String successMessage = driver.findElement(By.xpath("//form-comp/div/div[2]/div")).getText();
		//Assert.assertEquals(successMessage, "Success! The Form has been submitted successfully!.");
		
		System.out.println(successMessage);
				


	}

}
