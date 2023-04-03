package OP.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import OP.base.TestBase;

public class util extends TestBase {
	
public util() throws IOException {
		
	}


public static long loadtime = 20;
public static long implicitwait =10;


public void switchToFrameMainPanel()
{
	driver.switchTo().frame("mainpanel");
}

public static void takeScreenshotAtEndOfTest() throws IOException
{
	File SS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("usr.dir"); 
	FileUtils.copyFile(SS, new File(currentDir+"/screnshots/"+ System.currentTimeMillis()+".png"));}
}
