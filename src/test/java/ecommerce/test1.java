package ecommerce;


import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	
	
	@Test (groups = { "pre", "post" })
	public void start() {
		System.out.println("start");
		Assert.assertEquals("123","123");
	}
	
	@Test (groups = { "post"})
	public void A() {
		Assert.assertEquals(false, false);
		System.out.println("A");
	}
	
	
	
	@Test (groups = { "pre" })
	public void B() {
		Assert.assertEquals(true, false);
		System.out.println("B");
	}

	
	@Test (groups = { "post" })
	public void stop() {
		System.out.println("stop");
		Assert.assertEquals(false, false);
	}
}
