package test.selenium;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumManageMenu {
	
	public static void main(String arg[]) throws InterruptedException {
		SeleniumManageMenu seleniumManageMenu = new SeleniumManageMenu();
		seleniumManageMenu.seleniumTest();
	}

	@Test
	public void seleniumTest() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/EaT_10_02_2021_1/HomePageTouristView.jsp");
		driver.findElement(By.id("logout")).click();
	    driver.findElement(By.id("usernametx")).click();
	    driver.findElement(By.id("usernametx")).sendKeys("Elvira");
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.id("passtx")).click();
	    driver.findElement(By.id("passtx")).sendKeys("1");
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.id("ownercb")).click();
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.id("login")).click();
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.id("Manage")).click();
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();;    
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.xpath("//*[@id=\"Done\"]")).click();
	    TimeUnit.SECONDS.sleep(1);
	    String textError = driver.findElement(By.xpath("//*[@id=\"errore\"]")).getText();
	
		assertEquals("the inserted dish does not belong to the selected restaurant", textError);
		
		driver.close();
		
	}
	
}
