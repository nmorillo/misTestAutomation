package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Items {
	private WebDriver driver;
	private By lighterBanner;
	private By noResultsBanner;
	private By btnSelectColor;
	private By orangeColor;
	
	public Items(WebDriver driver) {
		this.driver = driver;
		lighterBanner = By.className("lighter");
		noResultsBanner = By.xpath("//*[@id=\'center_column\']/p");
		btnSelectColor = By.id("color_2");
		orangeColor = By.id("color_21");
	}
	
	public String getLighterBannerText() {
		return driver.findElement(lighterBanner).getText();	
	}
	
	public String getNoResultsBannerText() {
		return driver.findElement(noResultsBanner).getText();
	}
	
	public void selectColor(int num) {
		driver.findElement(By.id("color_"+num)).click();
	}
	
	public void clickOrangeColorWithTimeCondition() {
		//driver.findElement(orangeColor);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement orange = wait.until(ExpectedConditions.elementToBeClickable(orangeColor));
		orange.click();
	}

}
