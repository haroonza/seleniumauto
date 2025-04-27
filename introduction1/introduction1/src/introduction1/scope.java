package introduction1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(column.findElements(By.tagName("a")).size());
		
		for(int i=0; i<column.findElements(By.tagName("a")).size(); i++) {
			
			String newPage = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(newPage);
		}
		Set<String> windowHands =  driver.getWindowHandles();
		Iterator<String> it =  windowHands.iterator();
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		};

	}

}
