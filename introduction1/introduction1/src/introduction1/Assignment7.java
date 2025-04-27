package introduction1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,500)");
		
		/*
		 * List<WebElement> cols =
		 * driver.findElements(By.cssSelector(".table-display th"));
		 * 
		 * System.out.println("The number columns are = "+cols.size());
		 * 
		 * List<WebElement> rows =
		 * driver.findElements(By.cssSelector(".table-display tr"));
		 * 
		 * System.out.println("The number rows are = "+rows.size());
		 * 
		 * System.out.println(driver.findElement(By.
		 * cssSelector(".table-display tr:nth-child(4)")).getText());
		 */
		
		WebElement tabl = driver.findElement(By.id("product"));
		
		System.out.println(tabl.findElements(By.tagName("tr")).size());
        System.out.println(tabl.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        List<WebElement> second = tabl.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        
        System.out.println(second.get(0).getText());
        System.out.println(second.get(1).getText());
        System.out.println(second.get(2).getText());
	}

}
