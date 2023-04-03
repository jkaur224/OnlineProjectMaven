package OP.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import OP.utilities.WebEventListener;
import OP.utilities.util;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws IOException
	{
		try 
		{
		FileInputStream f = new FileInputStream("C:\\QA\\SeleniumWorkSpace\\OnlineProject\\src\\main\\java\\OP\\configurations\\configuration.properties");
		 prop = new Properties();
		
		prop.load(f);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public static void initialization() throws IOException
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumWorkSpace\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumWorkSpace\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//object for EventListHandler
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(util.loadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.implicitwait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
}
