package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Category {
	private By sortDropDown;
	private By women;
	private WebDriver driver;
	
	public Category(WebDriver driver) {
		this.driver = driver;
		women = By.linkText("Women");
		sortDropDown = By.id("selectProductSort");
		//Select order = new Select(driver.findElement(orderSelect));
	}
	
	public void goWomenCategory() {
		driver.findElement(women).click();
	}
	
	public void selectProductSortByText(String textSearch) {
		Select order1 = new Select(driver.findElement(sortDropDown));
		order1.selectByVisibleText(textSearch);
	}
	public void selectProductSortByValue(String valueSearch) {
		Select order2 = new Select(driver.findElement(sortDropDown));
		order2.selectByValue(valueSearch);
	}
	
	public void selectProductSortByIndex(int item) {
		Select order3 = new Select(driver.findElement(sortDropDown));
		order3.selectByIndex(item);
	}
}
