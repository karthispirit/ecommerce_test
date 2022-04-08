package ecommerce;

	import java.util.List;
import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
	
	public class Costco_main {

		
		public static WebDriver driver;
		
		
		public  void start() throws InterruptedException {
			
			
			//System.setProperty("webdriver.ie.driver", "C:\\Users\\prema\\Desktop\\Selenium\\drivers\\IEDriverServer.exe");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\prema\\Desktop\\Selenium\\drivers\\chromedriver.exe");
			System.setProperty("webdriver.edge.driver", "C:\\Users\\prema\\Desktop\\Selenium\\drivers\\msedgedriver.exe");
			//WebDriver driver = new ChromeDriver(); 
			driver = new EdgeDriver();
			//WebDriver driver=new InternetExplorerDriver();  
			Thread.sleep(2000);
			driver.manage().window().maximize();
		}
		
		@SuppressWarnings("deprecation")
		public void costco_login() {
			driver.get("https://www.costco.com/");
			System.out.println(driver.getWindowHandles());
			//Thread.sleep(15000);
			driver.findElement(By.id("header_sign_in")).click();
			System.out.println("link_clicked");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("signInName")).sendKeys("karthispirit@gmail.com");
			System.out.println("user name entred");
			
			driver.findElement(By.name("Password")).sendKeys("Spider@1986");
			System.out.println("password_entered");
			driver.findElement(By.id("next")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		public void costco_accout_print() {
			
			System.out.println(driver.findElement(By.id("myaccount-react-d")).getText());
		}
		
		public void costco_orders(String name,String text) throws InterruptedException {
			driver.findElement(By.id("header_order_and_returns")).click();
			
			if (name=="online") {
			driver.findElement(By.id("onlineOrdersTab")).click();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"order-status-wrapper\"]/div/div[1]")).getText());
			List<WebElement> elementName =driver.findElements(By.xpath("//p[contains(@id,'orderLabel_')]"));
			System.out.println(elementName.size());
					
			
			
			for (int i=0; i<elementName.size();i++){
			      System.out.println("Ordernumber:" + elementName.get(i).getAttribute("value"));
			    }
			
			Select ss=new Select(driver.findElement(By.id("my_order_date_select")));
			//System.out.println(ss.getAllSelectedOptions());
			
			ss.selectByVisibleText("2021 January - June");
			}
			else {
			Thread.sleep(5000);
			driver.findElement(By.id("warehouseOrdersTab")).click();
			
			Select sss=new Select(driver.findElement(By.id("Showing")));
			sss.selectByVisibleText(text);
			}
		}	
		public void Costco_account_details() {
			
			driver.findElement(By.linkText("Account Details")).click();
			String accountno=driver.findElement(By.id("membership-number-value")).getText();
			System.out.println("member id : " + accountno);
			String exp_date=driver.findElement(By.id("expiration-date-value")).getText();
			System.out.println("Exp date : " + exp_date);
			String email=driver.findElement(By.id("email-value")).getText();
			System.out.println("Email : " + email);
			
			
			
			
		}
	
			public void stop() {
				driver.quit();
			}
		
	}

