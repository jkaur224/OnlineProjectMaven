package OP.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OP.base.TestBase;
import OP.pages.HomePage;
import OP.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage object;
	HomePage homepage;
	
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
	initialization();
	object= new LoginPage();
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void titleTest() throws InterruptedException
	{
		Thread.sleep(3000);
		String actual = object.validTitleofLoginPage();
		String expected = "Free CRM - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void logoTest() throws InterruptedException
	{
		Thread.sleep(5000);
		boolean flag=object.validlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginValidTest() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		homepage= object.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
	}
	
	
	
}
