package selections;

import org.testng.annotations.Test;

import baseTest.Common;

public class WomenSelectionText extends Common{
	/*
	private WebDriver driver;
	private Index index;
	private Items item;
	private Category category;

	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		
//		index = new Index(driver);
//		item = new Items(driver);
		category = new Category(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	*/
	
	@Test(description = "Search by checks")
	public void searchByChecks() {		
		index.clickWomenLink();
		category.checkDress();
		category.checkL();
		category.clickColor(3);
	}
	

	
}
