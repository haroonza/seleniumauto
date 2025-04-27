package introduction1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ajax {

	public static void main(String[] args) {

		// TODO Auto-generated method
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String>it = windows.iterator();

		String parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para red")).getText());
		
		String EmailID = driver.findElement(By.cssSelector(".im-para red")).getText().split("at")[1].split(" ")[0];
		
		driver.switchTo().window(parent);
		
		driver.findElement(By.id("username")).sendKeys(EmailID);
	}

}
