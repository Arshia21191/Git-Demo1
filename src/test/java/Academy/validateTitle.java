package Academy;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	
	@Test
	public void validateAppTitle() throws IOException {
	
		// one is inheritance
		// creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
	    //Assert.assertFalse(false);
		log.info("Successfully Validated Text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
		
}
