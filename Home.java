package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	public static final String URL = "https://www.saucedemo.com/";
	public static final String USERNAME_XPATH = "//*[@id=\"user-name\"]";
	public static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	
	public static void inputUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(USERNAME_XPATH )).sendKeys(username);
	}
	public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
	}
	public static void login(WebDriver driver) {
		driver.findElement(By.name("LOGIN")).click();
		
	}
	
}
