package firstPackage;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ravinemangala/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		String[] productsToSelect = {"Brocolli", "Cucumber", "Carrot"};  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, productsToSelect);
		driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
				
	}
	
	public static void addItems(WebDriver driver, String[] productsToSelect) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		
		
		for (int i = 0; i < products.size(); i++) {
			String[] productNameUnformatted = products.get(i).getText().split(" ");
			String productName = productNameUnformatted[0];
			List<String> productsToSelectList = Arrays.asList(productsToSelect);
			if (productsToSelectList.contains(productName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}

	}
	
}
