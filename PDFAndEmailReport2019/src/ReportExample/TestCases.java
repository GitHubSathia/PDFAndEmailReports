package ReportExample;

import java.net.MalformedURLException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

@Listeners(JypersionListerner.class)
//import JypersionListener;
public class TestCases extends BaseClass {

	WebDriver driver;
	 //Testcase failed so screen shot generate
	@Test
	public void testCase1() throws MalformedURLException {
		driver=BaseClass.getDriver();
		driver.get("http://google.com");
		Assert.assertTrue(false);
	}
	//Testcase failed so screen shot generate
	@Test
	public void testCase2() throws Exception {
		driver=BaseClass.getDriver();
		driver.get("http:/guru99.com");
		try {
		Assert.assertTrue(false);
	
		}catch(AssertionError e){
			   Logger error;
		
			  
			   takeSnapshot(driver,"C:\\Prabhu\\Personal\\KnowledgeBase\\Learning\\Selenium\\SeleniumWorkSpace\\PDFAndEmailReport2019\\testcase2fail.jpeg");
			}
				
			
	}
	
	//Test test case will be pass, so no screen shot on it

    @Test

    public void testCase3() throws MalformedURLException{

        driver = BaseClass.getDriver();

        driver.get("http://demo.guru99.com");

        Assert.assertTrue(true);
	
}
    
    @AfterMethod
    public void closeBrowser()
    {
    	BaseClass.closeDriver();
    }
    
  //After complete execution send pdf report by email

    @AfterSuite

    public void tearDown(){

        sendPDFReportByGMail("b6269615@gmail.com", "abcdef1234%", "b6269615@gmail.com", "PDF Report", "");

        }

    

    /**

     * Send email using java

     * @param from

     * @param pass

     * @param to

     * @param subject

     * @param body

     */

    private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

Properties props = System.getProperties();

String host = "smtp.gmail.com";

props.put("mail.smtp.starttls.enable", "true");

props.put("mail.smtp.host", host);

props.put("mail.smtp.user", from);

props.put("mail.smtp.password", pass);

props.put("mail.smtp.port", "587");

props.put("mail.smtp.auth", "true");

Session session = Session.getDefaultInstance(props);

MimeMessage message = new MimeMessage(session);

try {

    //Set from address

message.setFrom(new InternetAddress(from));

message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//Set subject

message.setSubject(subject);

message.setText(body);

BodyPart objMessageBodyPart = new MimeBodyPart();

objMessageBodyPart.setText("Please Find The Attached Report File!");

Multipart multipart = new MimeMultipart();

multipart.addBodyPart(objMessageBodyPart);

objMessageBodyPart = new MimeBodyPart();

//Set path to the pdf report file

String filename = System.getProperty("user.dir")+"\\Default test.pdf";

//Create data source to attach the file in mail

DataSource source = new FileDataSource(filename);

objMessageBodyPart.setDataHandler(new DataHandler(source));

objMessageBodyPart.setFileName(filename);

multipart.addBodyPart(objMessageBodyPart);

message.setContent(multipart);

Transport transport = session.getTransport("smtp");

transport.connect(host, from, pass);

transport.sendMessage(message, message.getAllRecipients());

transport.close();

}

catch (AddressException ae) {

ae.printStackTrace();

}

catch (MessagingException me) {

me.printStackTrace();

}

}

}  
    
    
    
    

