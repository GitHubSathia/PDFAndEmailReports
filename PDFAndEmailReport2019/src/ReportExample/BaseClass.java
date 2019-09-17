package ReportExample;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//This base class has functions to create WebDriver and Take Screenshot
public class BaseClass {
	static WebDriver driver;
	
	public static WebDriver getDriver() throws MalformedURLException {
		String nodeUrl="http://192.168.1.156:5566/wd/hub";
		DesiredCapabilities capability=DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		//capability.setVersion("72.0.3626.109");
		capability.setPlatform(Platform.WINDOWS);
		//System.setProperty("webdriver.gecko.driver", "C:\\Prabhu\\Personal\\KnowledgeBase\\Learning\\Selenium\\BrowserDriverDownloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		  //driver=new FirefoxDriver();
		
		driver=new RemoteWebDriver(new URL(nodeUrl),capability);
		
		  return driver;
		
	}
	
public static void closeDriver() {
		
		driver.quit();
		  
		
	}
	
	public static void takeSnapshot(WebDriver driver,String fileWithPath) throws Exception{
		 //Convert web driver object to TakeScreenshot
		
		TakesScreenshot scrshot=((TakesScreenshot)driver);
		 //Call getScreenshotAs method to create image file
		File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileHandler.copy(SrcFile, DestFile);

	}
	

}
