package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Index {
	private WebDriver driver;
	private By searchField;
	private By searchButton;
	private By iconList;// list
	private By womenLink;
	private By productName;	
	
	public Index(WebDriver driver) {
		this.driver = driver;
		searchField = By.id("search_query_top");
		searchButton = By.name("submit_search");
		iconList = By.id("list");
		womenLink = By.linkText("Women");
		productName = By.xpath("//*[@id='center_column']/div/div/div[3]/h1");
	}
	
	public void search(String item) {
		driver.findElement(searchField).sendKeys(item);
		driver.findElement(searchButton).click();
		
	}
	public void clickToIconList() {
		driver.findElement(iconList).click();
	}
	
	public void clickWomenLink() {
		driver.findElement(womenLink).click();
	}
	
	public void selectColor(int num) {
		driver.findElement(By.id("color_"+num)).click();
	}
	
	public String GetProductNameText() {
		
		System.out.println("Estoy en Index......"+driver.findElement(productName).getText());
		return driver.findElement(productName).getText();
	}

}
