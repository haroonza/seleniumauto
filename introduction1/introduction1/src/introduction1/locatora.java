
package introduction1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class locatora {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//implicit wait for the output.
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Haroon");
		
		driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
		
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		String password = getPassword(driver);
	    Thread.sleep(2000);//to stop the thread of code 
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Haroon");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Haroonzaman@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("haroon@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("03339074679");
	
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Haroon");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.cssSelector("label[for='chkboxOne']")).click();
		driver.findElement(By.cssSelector("label[for='chkboxTwo']")).click();
	
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();		
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passArray = passwordText.split("'");
		
		String password = passArray[1].split("'")[0];
		return password;
	}

}

//CSS Selector///
// class select ++  .classname ++
//Class name; tagname.classname
//Or Id = tagname#ID
//Or Tagname[attribute='value']
// when you can't find unique then input[placeholder='Email']:nth-child(3)
// parenttagname childtagname
//???????   //button[contains(@class,'submit')]   -> regular expression

//?????XPATH?????//
//????  //tagname[@attribute='value']        ??????//
// tagname[@attribute='value'][index] when no unique       

//?????  //parenttag/childtag[index] ?????//