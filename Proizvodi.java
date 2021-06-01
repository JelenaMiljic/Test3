package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Proizvodi {

	public static final String URL = "https://www.saucedemo.com/inventory.html";
	
	public static final String SEARCH_XPATH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select";

	public static void selectBtn(WebDriver driver) {
		driver.findElement(By.xpath(SEARCH_XPATH)).click();
	}
	public static void sortLowHight(WebDriver driver ) {
		driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select")).click();
		
	
	}
	
}
