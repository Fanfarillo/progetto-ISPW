package test.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Adrian Baba
 *
 */


public class SeleniumChooseRestaurant {

	
	@Test
	public void seleniumTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/EaTypical/HomePageTouristView.jsp");
		
		driver.findElement(By.xpath("//*[@id=\"logout\"]")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"usernametx\"]")).sendKeys("Pazizo");
		driver.findElement(By.xpath("//*[@id=\"passtx\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"chooseRestaurant\"]")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"TO_img\"]")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"restaurantsScroll\"]")).sendKeys("Tre");
		driver.findElement(By.xpath("//*[@id=\"updateInfo\"]")).click();
		TimeUnit.SECONDS.sleep(1);
		WebElement txtBoxContent= driver.findElement(By.xpath("//*[@id=\"addrtx\"]"));
		String addressContent= txtBoxContent.getAttribute("value");		
		driver.findElement(By.xpath("//*[@id=\"home\"]")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"logout\"]")).click();
		assertEquals("IndirizzoTre", addressContent);
		driver.close();
		}
}
