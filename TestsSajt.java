package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objs.Home;
import objs.Proizvodi;


public class TestsSajt {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chdriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1)
	public void testHome() {
		driver.navigate().to(Home.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = Home.URL;
		
		Assert.assertEquals(currentUrl, expectedUrl);
	}
	
	@Test(priority =2)
	public void testLog() {
			
		File f = new File("data.xlsx");
		
		try {
			InputStream in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);
			
			SoftAssert sa = new SoftAssert();
			
			for (int i = 0; i < 4; i++) {
				
				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				
				driver.navigate().to(Home.URL);
				
				String username = c0.toString();
				String password = c1.toString();
				
				Home.inputUsername(driver, username);
				Home.inputPassword(driver, password);
				Home.login(driver);
				
				String currentUrl = driver.getCurrentUrl();
				String expectedUrl = "https://www.saucedemo.com/inventory.html";
				
				sa.assertEquals(currentUrl, expectedUrl);
				
			}
			
			sa.assertAll();
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public void proizvSort() {
		
		driver.navigate().to(Proizvodi.URL);
		Proizvodi.selectBtn(driver);
		Proizvodi.sortLowHight(driver);
		
		List<WebElement>artikli = driver.findElements(By.className("inventory_item_name"));
		
		
				
		
	}
	
}
