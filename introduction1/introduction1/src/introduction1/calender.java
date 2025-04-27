package introduction1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//input[name='day']
		//button[class='react-date-picker__calendar-button react-date-picker__button']
		////button[@class='react-calendar__navigation__label']
		//class="react-date-picker__inputGroup"
		String month = "8";
		String date ="3";
		String year = "2027";
		String[] aclist = {month,date,year};
		
		driver.findElement(By.cssSelector("button[class='react-date-picker__calendar-button react-date-picker__button']")).click();
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("button[@class='react-calendar__navigation__label']")));
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();	
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();	
		driver.findElement(By.xpath("//button[text()='"+ year +"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date +"']")).click();
		
		//System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i = 0; i<actualList.size();i++) {
			System.out.println(actualList.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), aclist[i]);			
		}
	}

}
