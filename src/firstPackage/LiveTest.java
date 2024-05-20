package firstPackage;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LiveTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		//capture all webelements into list
		List<WebElement> products = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//scan name column.  If rice is returned, get the price for rice
	
		//capture the text from each webelement
		List<String> productNames = products.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort the text alphabetically,
		List<String> productNamesSorted = productNames.stream().sorted().collect(Collectors.toList());
		//click on column
		
		//get the sorted list provided by the UI
		
		//verify the sorted list matches the text from the column
		Assert.assertTrue(productNames.equals(productNamesSorted));
		
		//scan name column.  If beans is returned, get the price for rice
		List<String> price =  products.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList()); 
		price.forEach(p->System.out.println("price of Beans is " + p));
	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
