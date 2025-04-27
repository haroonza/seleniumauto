package introduction1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class scroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		
		List<WebElement> fourthCol = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i=0 ; i<fourthCol.size(); i++) {
		//System.out.println(fourthCol.get(i).getText());
		sum = sum + Integer.parseInt(fourthCol.get(i).getText());
		}
		
		System.out.println(sum);
		System.out.println(driver.findElement(By.cssSelector(".totalAmount")).getText());
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		
	}
}