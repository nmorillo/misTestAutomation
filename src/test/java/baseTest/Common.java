package baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.Screenshots;
import pages.Category;
import pages.Index;
import pages.Items;

public class Common {
	protected int contadorPaso;
	protected int contadorFallo;
	protected WebDriver driver;
	protected Index index;
	protected Items item;
	protected Category category;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		
		index = new Index(driver);
		category = new Category(driver);
		item = new Items(driver);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		String resultado;
		System.out.println("============================================");
		if(result.getStatus()==1) {
			contadorPaso++;
			resultado = "Paso";
		}else {
			resultado = "Fallo";

			Screenshots.takeScreenshot(result.getMethod().getDescription(), driver);
			
			contadorFallo++;
		}
		System.out.println("El test "+result.getMethod().getDescription()+" | "+result.getMethod().getMethodName()+" : "+resultado+" la prueba");
		System.out.println("============================================");
		driver.close();
		driver.quit();
	}
}
