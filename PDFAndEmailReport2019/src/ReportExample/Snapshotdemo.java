package ReportExample;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class Snapshotdemo extends BaseClass{
	
	WebDriver driver;
	@Test
	public void testCase1() throws Exception {
		driver=BaseClass.getDriver();
		driver.get("http://google.com");
		takeSnapshot(driver,"C:\\Prabhu\\Personal\\KnowledgeBase\\Learning\\Selenium\\SeleniumWorkSpace\\PDFAndEmailReport2019\\testcase2fail.jpeg");
	}

}
