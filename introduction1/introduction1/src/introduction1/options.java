package introduction1;



//import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
/*import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;*/
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class options {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		ChromeOptions options = new ChromeOptions();
		
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links) {
			
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection(); 
			
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int  resp= conn.getResponseCode();
			System.out.println(resp);
		    a.assertTrue(resp<400, "This Link "+link.getText()+" Broken and the code is "+resp);
			
		}
		a.assertAll();
		
		
		
		
		//driver.manage().deleteAllCookies();
		/*
		 * 
		 * //driver.get("https://expired.badssl.com/");
		 * driver.get("https://google.com/"); //System.out.println(driver.getTitle());
		 * 
		 * File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * FileUtils.copyFile(scr, new
		 * File("C:\\Users\\Dell\\Desktop\\New folder\\screenshot.png"));
		 */
	}

}
