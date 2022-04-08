package ecommerce;



	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;



	public class Test_POM  extends TestBase{
		Loginpage_costco Loginpage_costco;
		
		
		public Test_POM(){
			super();
		}
		
		@BeforeMethod
		public void setUp(){
			initialization();
			Loginpage_costco = new Loginpage_costco();	
		}
		
		@Test(priority=1)
		public void loginPageTitleTest() throws InterruptedException{
			 Loginpage_costco.costco_login(prop.getProperty("username"), prop.getProperty("password"));
			 Loginpage_costco.costco_accout_print();
			// Loginpage_costco.costco_orders(prop.getProperty("category"), prop.getProperty("time"));
			 Loginpage_costco.costco_orders(prop.getProperty("time"));
			 Loginpage_costco.Costco_account_details();
					
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		
		
		

	}


