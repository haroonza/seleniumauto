package introduction1;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.org.apache.bcel.internal.generic.Select;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.name("name")).sendKeys("Haroon Zaman");
		driver.findElement(By.name("email")).sendKeys("haroon@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Haroon");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		

		WebElement drop = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select dropdown = new Select(drop);
		dropdown.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("03/08/1995");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class= 'alert alert-success alert-dismissible']")).getText());

	}

}
