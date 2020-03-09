package calculadora;

import org.testng.Assert;
import org.testng.annotations.Test;

public class matematicaTest {
	
	@Test
	public void suma() {
		Assert.assertEquals(2+2,4);
	}

	@Test
	public void resta() {
		Assert.assertTrue(2-2==0);
	}
	
	@Test
	public void multiplicacion() {
		Assert.assertFalse(3*3==1000);
	}
	
	@Test
	public void division() {
		Assert.assertNotEquals(3/3,400);
	}
}
