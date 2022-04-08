package ecommerce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase(){
		try {
			prop = new Properties();
			System.out.println("---------------1--------");
			FileInputStream ip = new FileInputStream("C:\\Users\\prema\\eclipse-workspace\\ecommerce\\src\\main\\java\\ecommerce\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\prema\\Desktop\\Selenium\\drivers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\prema\\Desktop\\Selenium\\drivers\\msedgedriver.exe");	
			driver = new EdgeDriver(); 
		}
		
		
		
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}
