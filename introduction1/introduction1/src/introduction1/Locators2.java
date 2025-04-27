
package introduction1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //traverse to siblings
		//????//header/div/button[1]/following-sibling::button[1]
		//traverse child to parent 
		////header/div/button[1]///header/div/button[1]/parent::div/button[2]
		WebDriver driver = new ChromeDriver();
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//run tests in maximize mode 
		/*
		 * driver.manage().window().maximize(); driver.get("https://google.com");
		 * driver.navigate().to("https://rahulshettyacademy.com");
		 * driver.navigate().back(); driver.navigate().forward();
		 */
		
		driver.get("https://rahulshettyacademy.com/documents-request");
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		}
	}
