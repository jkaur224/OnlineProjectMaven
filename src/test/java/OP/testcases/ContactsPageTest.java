
package OP.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OP.base.TestBase;
import OP.data.dataNewContact;
import OP.pages.ContactsPage;
import OP.pages.DealsPage;
import OP.pages.HomePage;
import OP.pages.LoginPage;
import OP.pages.TasksPage;
import OP.utilities.util;

public class ContactsPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage login;
	ContactsPage contactpage;
	DealsPage dealpage;
	TasksPage taskpage;
	util Utility;
	dataNewContact data;
	
	public ContactsPageTest() throws IOException, InterruptedException {
		super();
		}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
	Thread.sleep(5000);
	initialization();
	Utility = new util();
	contactpage = new ContactsPage();
	login= new LoginPage();
	homepage=login.Login(prop.getProperty("username"), prop.getProperty("password"));
	Utility.switchToFrameMainPanel();
	contactpage =homepage.clickOnContacts();
	data = new dataNewContact();
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

	@Test(priority=1)
	public void ValidateContactPageTest() throws InterruptedException
	{
		Assert.assertTrue(contactpage.EmailIsDisplayed());
		Assert.assertTrue(contactpage.VerifyContactTableHeading());
	}
	
	@Test(priority=2)
	public void ContactsNamesTest() throws InterruptedException
	{
		contactpage.ClickOnContactByName("Bisman Singh");
	}
	
	@Test(priority=3)
	public void NewContactTest() throws InterruptedException, IOException
	{
		homepage.selectNewContact();
		//contactpage.addNewContact("Dr.","Ravleen","Miglani");
		contactpage.addNewContact(data.correctTitle,data.correctFirstName,data.correctLastName);
	}
		
	
	
}