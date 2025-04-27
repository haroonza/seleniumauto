package introduction1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 
		driver.findElement(By.id("checkBoxOption2")).click();
		String lab = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		
		WebElement ele = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(ele);
		
		sel.selectByVisibleText(lab);
		
		driver.findElement(By.id("name")).sendKeys(lab);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String msg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		System.out.println(msg.split(",")[0].split(" ")[1]);
	}

}
