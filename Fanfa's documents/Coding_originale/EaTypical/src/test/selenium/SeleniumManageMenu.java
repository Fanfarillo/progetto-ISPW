package test.selenium;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumManageMenu {
	
	public static void main(String arg[]) {
		SeleniumManageMenu seleniumManageMenu = new SeleniumManageMenu();
		seleniumManageMenu.seleniumTest();
	}

	@Test
	public void seleniumTest() {
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/EaT_10_02_2021_1/HomePageTouristView.jsp");
		driver.findElement(By.id("logout")).click();
	    driver.findElement(By.id("usernametx")).click();
	    driver.findElement(By.id("usernametx")).sendKeys("Elvira");
	    driver.findElement(By.id("passtx")).click();
	    driver.findElement(By.id("passtx")).sendKeys("1");
	    driver.findElement(By.id("ownercb")).click();
	    driver.findElement(By.id("login")).click();
	    driver.findElement(By.id("Manage")).click();
	    driver.findElement(By.id("delete")).click();
	    
	    
	    
	
	    
	    
	    
	    
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("piatto")));
	    WebElement element = driver.findElement(By.name("piatto"));
	    element.findElement(By.xpath("//option[. = 'Arrosticini']")).click();
		WebElement element2 = driver.findElement(By.name("ristorante"));
		element2.findElement(By.xpath("/html/body/div/form/div[3]/select/option[4]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"delete\"]")));
		driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Done\"]")));
		driver.findElement(By.xpath("//*[@id=\"Done\"]")).click();
		
		WebElement labelPath = driver.findElement(By.xpath("//*[@id=\"errore\"]"));
		String labelContent = labelPath.getText();
		
		assertEquals("the inserted dish does not belong to the selected restaurant", labelContent);
		
		driver.close();
		
	}
	
}
