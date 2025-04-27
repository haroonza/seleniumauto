package introduction1;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String pass = "learning";
		String usern = "rahulshettyacademy";
		
		login(driver, pass, usern);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Checkout")));
		inside(driver);
		
		driver.findElement(By.partialLinkText("Checkout")).click();
		
		

	}

	public static void login(WebDriver driver, String password, String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(), 'User')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

		WebElement drop = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(drop);
		dropdown.selectByValue("consult");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

	}
	
	public static void inside(WebDriver driver) {
		
		List<WebElement> products =  driver.findElements(By.cssSelector(".card-footer .btn-info"));
		
		for(int i= 0; i < products.size(); i++) {
		products.get(i).click();
		}
	}

}
