package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Matteo Fanfarillo
 *
 */

public class SeleniumScheduleTrip {

	@Test
	public void seleniumTest() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/EaTypical/HomePageTouristView.jsp");
		
		driver.findElement(By.xpath("//*[@id=\"logout\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"usernametx\"]")).sendKeys("Pazizo");
		driver.findElement(By.xpath("//*[@id=\"passtx\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"scheduleTrip\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"TorinoImg\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"generate\"]")).click();
		
		WebElement labelPath = driver.findElement(By.xpath("//*[@id=\"errorMsg\"]"));
		String labelContent = labelPath.getText();
		
		assertEquals("You need to specify both the first day of your trip and the last day of your trip.", labelContent);
		driver.close();
		
	}
	
}