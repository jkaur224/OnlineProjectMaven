package OP.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.server.HttpConnection;

import OP.base.TestBase;
import OP.utilities.util;

public class HomePage extends TestBase {
	util Utility = new util();
	
	@FindBy(xpath = "//td[contains(text(),'User: Jasmine Ahuja')]")
	public WebElement accountHolder;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	public WebElement Contact;
	
	@FindBy(xpath ="//a[contains(text(),'New Contact')]")
	public WebElement newContact;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	public WebElement Deals;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	public WebElement Tasks;	
	
	//initializing the page objects
	public HomePage() throws IOException {
	PageFactory.initElements(driver, this);
	}
	
	//method
	public boolean accountHolderName() throws InterruptedException
	{
		Thread.sleep(5000);
		Utility.switchToFrameMainPanel();
		return accountHolder.isDisplayed();
	
	}
	
	public String homepageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		Contact.click();
		return new ContactsPage();
	}
	
	public void selectNewContact() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(Contact).build().perform();
		newContact.click();
	}
	
	public DealsPage clickOnDeals() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		Utility.switchToFrameMainPanel();
		Thread.sleep(5000);
		Deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() throws InterruptedException, IOException
	{
		Thread.sleep(4000);
		Utility.switchToFrameMainPanel();
		Tasks.click();
		return new TasksPage();
	}
	
	public void BrokenLinks() throws InterruptedException, IOException
	{
		Thread.sleep(4000);
		//Links are in mainframe
		Utility.switchToFrameMainPanel();
		
		//list all links starting with a and image
		List<WebElement> AllLink = driver.findElements(By.tagName("a"));
		AllLink.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total number of links are:"+ AllLink.size());
		
		//make a list for all links that have href attribute
		List<WebElement> activeLink = new ArrayList<WebElement>();
		for(int i=0;i<AllLink.size();i++)
		{
			if((AllLink.get(i).getAttribute("href")!=null) && (! AllLink.get(i).getAttribute("href").contains("javascript")))
			{
				activeLink.add(AllLink.get(i));
			}
		}
		System.out.println("Total number of active links are:"+ activeLink.size());
		
		//Set Connection and check for broken links
		for(int j=0;j<activeLink.size();j++)
		{
			HttpURLConnection connection= (HttpURLConnection) new URL(activeLink.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLink.get(j).getAttribute("href")+" -----> "+ response);
		}
		
		}
	
	
	}
	

