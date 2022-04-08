package ecommerce;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
	
public class Loginpage_costco extends TestBase {

	@FindBy(id="header_sign_in")
	WebElement sign_in;
	
	
	@FindBy(id="signInName")
	WebElement username;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(id="next")
	WebElement submit;
	
	@FindBy(id="myaccount-react-d")
	WebElement account;
	
	@FindBy(id="header_order_and_returns")
	WebElement orders;
	
	@FindBy(id="onlineOrdersTab")
	WebElement online_order;
	
	@FindBy(xpath="//*[@id=\"order-status-wrapper\"]/div/div[1]")
	WebElement order_details;
	
	public Loginpage_costco(){
		PageFactory.initElements(driver, this);
	}
	
		@SuppressWarnings("deprecation")
		public void costco_login(String un,String pwd) {
			
			System.out.println(driver.getWindowHandles());
			//Thread.sleep(15000);
			sign_in.click();
			System.out.println("link_clicked");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			username.sendKeys(un);
			System.out.println("user name entred");
			
			password.sendKeys(pwd);
			System.out.println("password_entered");
			submit.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			System.out.println("------------costco_login_passed--------");
		}
		public void costco_accout_print() {
			
			System.out.println(account.getText());
			System.out.println("------------costco_account_printed--------");
		}
		
		public void costco_orders(String text) throws InterruptedException {
			orders.click();
			String name = "online";
			System.out.println(name);
			
			if (name=="online") {
			System.out.println("online-processed");
			online_order.click();
			System.out.println(order_details.getText());
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
			System.out.println("warehouse processed");
			driver.findElement(By.id("warehouseOrdersTab")).click();
			
			Select sss=new Select(driver.findElement(By.id("Showing")));
			sss.selectByVisibleText(text);
			}
			System.out.println("------------costco_online_order_passed--------");
		}	
		public void Costco_account_details() {
			
			driver.findElement(By.linkText("Account Details")).click();
			String accountno=driver.findElement(By.id("membership-number-value")).getText();
			System.out.println("member id : " + accountno);
			String exp_date=driver.findElement(By.id("expiration-date-value")).getText();
			System.out.println("Exp date : " + exp_date);
			String email=driver.findElement(By.id("email-value")).getText();
			System.out.println("Email : " + email);
			System.out.println("------------costco_acc_details__passed--------");
			
			
			
			
		}
	
		
		
	}




