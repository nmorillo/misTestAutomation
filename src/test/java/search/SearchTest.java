package search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.StaticWaiter;
import pages.Category;
import pages.Index;
import pages.Items;

public class SearchTest {
	private WebDriver driver;
	private Index index;
	private Items item;
	private Category category;
	//private StaticWaiter sw = new StaticWaiter();
	
	@BeforeClass
	public void BoforeAll() {
		System.out.println("Armando el ambiente...");
		System.out.println("Ambienete armado...");
		System.out.println("Preparando base de datos...");
		System.out.println("Base de datos armada...");
	}
	
	@AfterClass
	public void arterAll() {
		System.out.println("Ambiente destruido...");
		System.out.println("Base de datos eliminada...");
	}
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");		
		//options.addArguments("--window-size=600,480");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(600, 480));
		//driver.manage().window().setPosition(new Point(100, 100));
		driver.navigate().to("http://automationpractice.com/index.php");
		index = new Index(driver);
		item = new Items(driver);
		category = new Category(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test(enabled=false)
	public void searchByDress() {		
		index.search("dress");		
		//StaticWaiter.wait(3000);		
		Assert.assertEquals(item.getLighterBannerText(), "\"DRESS\"");
	}
	
	@Test(enabled=false)
	public void searchNoResults() {
		
		index.search("pepito");		
		Assert.assertEquals(item.getNoResultsBannerText(), "No results were found for your search \"pepito\"");		
	}
	
	@Test(enabled=false)
	public void searchCeroResults() {
		
		index.search("tennis");		
		String textTypeOfResult = driver.findElement(By.className("heading-counter")).getText();
		System.out.println(textTypeOfResult);
		
		Assert.assertEquals(textTypeOfResult, "0 results have been found.");		
	}	
	
	@Test(enabled=false)
	public void filterWomenBy() {
		
		index.clickWomenLink();
		category.selectProductSortByText("Price: Highest first");	
	}
	
	@Test(enabled=false)
	public void filterWomenResultName() {
		index.clickWomenLink();
		category.selectProductSortByValue("name:desc");
	}
	
	@Test(enabled=false)
	public void filterWomenResultIndex() {
		index.clickWomenLink();
		category.selectProductSortByIndex(5);
	}
	
	@Test(enabled=true)
	public void searchByDressChangeToBlueColor() {		
		index.search("dress");
		index.clickToIconList();
		category.selectProductSortByText("Reference: Lowest first");
		index.selectColor(2);		

		Assert.assertEquals(index.GetProductNameText(), "Faded Short Sleeve T-shirts");
		System.out.println("Assert passed");		
	}
	
	@Test
	public void searchOrangeShoe() {
		index.search("shoes");
		item.clickOrangeColorWithTimeCondition();
		Assert.assertEquals(index.GetProductNameText(), "Printed Summer Dress");		
	}
	

}
