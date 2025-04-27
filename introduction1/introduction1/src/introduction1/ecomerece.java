package introduction1;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ecomerece {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String[] itemNeeded = { "Brocolli", "Cauliflower", "Cucumber", "Beetroot", "Carrot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver, itemNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'PROCEED TO CHECKOUT')])")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] itemNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String[] names = products.get(i).getText().split("-");
			String splitedVege = names[0].trim();

			List itemNeededList = Arrays.asList(itemNeeded);

			if (itemNeededList.contains(splitedVege)) {

				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemNeeded.length) {
					break;
				}
			}
		}
	}

}
