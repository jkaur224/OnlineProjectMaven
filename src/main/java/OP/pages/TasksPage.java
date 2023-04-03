package OP.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OP.base.TestBase;
import OP.utilities.util;

public class TasksPage extends TestBase {

util Utility = new util();

@FindBy(xpath ="(//td[@class='datacardtitle'])[3]")
public WebElement TasksTableHeading;


public TasksPage() throws IOException
{
	PageFactory.initElements(driver,this);
}

public boolean VerifyTasksTableHeading() throws InterruptedException
{
	Thread.sleep(3000);
	return TasksTableHeading.isDisplayed();
}

}
