package OP.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OP.base.TestBase;
import OP.utilities.util;

public class DealsPage extends TestBase {
	util Utility = new util();
	
	@FindBy(xpath ="(//td[@class='datacardtitle'])[4]")
	public WebElement DealssTableHeading;

	public DealsPage() throws IOException {
	PageFactory.initElements(driver,this);	
	}

	public boolean VerifyDealsTableHeading() throws InterruptedException
	{
		Thread.sleep(3000);
		return DealssTableHeading.isDisplayed();
	}

}
