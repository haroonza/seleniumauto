package introduction1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> webele = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> orgList = webele.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortList = orgList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(orgList.equals(sortList));
		
		List<String> price;
		
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]")); //search for rows freshly
		price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList()); //get the text into list
		price.forEach(a->System.out.println(a)); //print the required text
		
		if(price.size()<1) {   //it searches the that the price should not be zero
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click(); //invoke the button todo pagination
		}
		}while(price.size()<1);

	}
	
	
	public static String getPrice(WebElement s) {   //this method is for getting the price from second column
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
