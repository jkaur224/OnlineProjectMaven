package OP.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OP.base.TestBase;
import OP.pages.ContactsPage;
import OP.pages.DealsPage;
import OP.pages.HomePage;
import OP.pages.LoginPage;
import OP.pages.TasksPage;


public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage login;
	ContactsPage contactpage;
	DealsPage dealpage;
	TasksPage taskpage;
	
	public HomePageTest() throws IOException
	{
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
	Thread.sleep(5000);
	initialization();
	login= new LoginPage();
	homepage=login.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest()
	{
		String actual = homepage.homepageTitle();
		Assert.assertEquals(actual, "CRMPRO");
	}
	
	@Test(priority=2)
	public void validateAccountHolderNameTest() throws InterruptedException
	{
		Assert.assertTrue(homepage.accountHolderName());
	}
	
	@Test(priority=3)
	public void validateContacts() throws InterruptedException, IOException
	{
		contactpage =homepage.clickOnContacts();
		Assert.assertTrue(contactpage.VerifyContactTableHeading());
	}
	
	@Test(priority=4)
	public void validateDeals() throws InterruptedException, IOException
	{
		dealpage =homepage.clickOnDeals();
		Assert.assertTrue(dealpage.VerifyDealsTableHeading());
	}
	
	@Test(priority=5)
	public void validateTasks() throws InterruptedException, IOException
	{
		taskpage =homepage.clickOnTasks();
		Assert.assertTrue(taskpage.VerifyTasksTableHeading());
	}
	
	@Test(priority=6)
	public void BrokenLinkTest() throws InterruptedException, IOException
	{
		homepage.BrokenLinks();
	}
	
}
