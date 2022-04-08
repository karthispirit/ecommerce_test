package ecommerce;

import org.testng.annotations.Test;

public class Costco_test  {

	
	@Test
	public void costco_login() throws InterruptedException {
		Costco_main a = new Costco_main();
		a.start();
		a.costco_login();
		//a.costco_accout_print();
		a.costco_orders("online", "2020 July - December");
		//a.costco_orders("warehouseOrdersTab","2020 July - December");
		//a.Costco_account_details();
		a.stop();
		
	}
}
