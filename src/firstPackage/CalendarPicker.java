package firstPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarPicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String monthNumber = "6";
		String dayNumber = "15";
		String year = "2027";
		String[] expectedList = {monthNumber, dayNumber, year};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.xpath("//button[contains(text(),'"+year+"')]")).click();
		driver.findElements(By.className("react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+dayNumber+"']")).click();
		driver.findElement(By.className("react-date-picker__inputGroup")).getText();
		List<WebElement> actualList = driver.findElements(By.className("react-date-picker__inputGroup__input"));
		for (int i = 0; i < actualList.size(); i++) {
			actualList.get(i).getAttribute("value");
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
			
		}

	}

}
