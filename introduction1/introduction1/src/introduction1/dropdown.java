package introduction1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement drop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(drop);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		/*
		 * driver.findElement(By.id("divpaxinfo")).click();
		 * System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		 * Thread.sleep(2000); int i=1; while(i<5) {
		 * 
		 * driver.findElement(By.id("hrefIncAdt")).click(); i++; }
		 * driver.findElement(By.id("btnclosepaxoption")).click();
		 * Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),
		 * "5 Adult");
		 * System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		 */

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click(); //some people
		// don't like the index so here is alternative.

		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']"))
				.click();
		// System.out.println(driver.findElement(By.cssSelector("input[ id *=
		// 'Content_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

		// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		// System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// .out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("It is enbled");
			Assert.assertTrue(true);
		} else {
			System.out.println("It is not enabled");
			Assert.assertTrue(false);
		}
		// driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		// driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
		// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

		/*
		 * 
		 * Assert.assertFalse(driver.findElement(By.
		 * cssSelector("input[ id *= 'Content_chk_friendsandfamily']")).isSelected());
		 * driver.findElement(By.
		 * cssSelector("input[ id *= 'Content_chk_friendsandfamily']")).click();
		 * 
		 * //System.out.println(driver.findElement(By.
		 * cssSelector("input[ id *= 'Content_chk_friendsandfamily']")).isSelected());
		 * 
		 * System.out.println(driver.findElements(By.cssSelector(
		 * "input[type='checkbox']")).size()); Assert.assertTrue(driver.findElement(By.
		 * cssSelector("input[ id *= 'Content_chk_friendsandfamily']")).isSelected());
		 * 
		 * driver.findElement(By.id("autosuggest")).sendKeys("ind"); //testNG is one the
		 * testing framework Thread.sleep(5000); 
		 * List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		 * 
		 * for(WebElement option :options) {
		 * 
		 * if(option.getText().equalsIgnoreCase("India")) { option.click(); break; }
		 * 
		 * }
		 * 
		 */
	}

}
