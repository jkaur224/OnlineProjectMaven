package OP.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OP.base.TestBase;

public class LoginPage extends TestBase {


//pageFactory or OR(object repository)
	
	@FindBy(name = "username")
	public WebElement email;
	
	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//div[@class='input-group-btn']/input")
	public WebElement LogInButton;
	
	@FindBy(linkText = "Sign Up")
	public WebElement SignUpButton;
	
	@FindBy(className ="img-responsive")
	public WebElement Logo;
	
	//initializing the page objects
	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver,this);
	}
	
	//actions
	public String validTitleofLoginPage()
	{
		return driver.getTitle();
	}
	
	public boolean validlogo()
	{
		return Logo.isDisplayed();
	}
	
	public HomePage Login(String username, String pass) throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		email.sendKeys(username);
		password.sendKeys(pass);
		LogInButton.click();
		return new HomePage();
	}
	

}