package helpers;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class DinamicWaiter {
	private Driver driver;
	public DinamicWaiter(Driver driver) {
		this.driver = driver;
	}
	public void implicitWait(int segundos){		
		//this.driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
		
	}

}
