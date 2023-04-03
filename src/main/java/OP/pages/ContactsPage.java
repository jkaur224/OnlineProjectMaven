package OP.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import OP.base.TestBase;
import OP.utilities.util;

public class ContactsPage extends TestBase{

util Utility = new util();

@FindBy(xpath ="//td[contains(text(),'Contacts')]")
public WebElement ContactsTableHeading;

@FindBy(xpath="//td[contains(text(),'Email')]")
public WebElement EamilforContacts;

//@FindBy(xpath="//select[@name='title']")
//public WebElement Title;

@FindBy(id="first_name")
public WebElement FirstName;

@FindBy(id="surname")
public WebElement LastName;

@FindBy(xpath="//input[@type='submit' and @value='Save']")
public WebElement Save;


public ContactsPage() throws IOException
{
	PageFactory.initElements(driver,this);
}

public boolean VerifyContactTableHeading() throws InterruptedException
{
	Thread.sleep(3000);
	return ContactsTableHeading.isDisplayed();
}

public void ClickOnContactByName(String name)
{
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
		+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
}

public boolean EmailIsDisplayed()
{
	return EamilforContacts.isDisplayed();
}

public void addNewContact(String title, String firstname, String lastname) throws InterruptedException
{
	FirstName.sendKeys(firstname);
	Thread.sleep(3000);

	LastName.sendKeys(lastname);
	Select select = new Select(driver.findElement(By.name("title")));
	Thread.sleep(3000);
	select.selectByVisibleText(title);
	Thread.sleep(3000);
	
	Save.click();
}


}
