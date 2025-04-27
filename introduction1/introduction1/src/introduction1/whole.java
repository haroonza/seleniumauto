package introduction1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class whole {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']"))
				.click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			System.out.println("It is disabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("It is enabled");
			Assert.assertTrue(false);
		}

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int i = 1;
		while (i < 5) {

			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		WebElement drop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(drop);
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
