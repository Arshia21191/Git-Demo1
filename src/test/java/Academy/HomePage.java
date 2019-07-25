package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

    public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	
	public void initialize() throws IOException
	
	{
		driver=initializeDriver();
		
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password,String text) throws IOException {
		
		// one is inheritance
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();// driver.findElement(By.css()

		LoginPage lp = new LoginPage(driver);
		
		  lp.getEmail().sendKeys(Username);
		  lp.getPassword().sendKeys(Password);
		  log.info(text);
		 
		lp.getLogin().click();
	}
		
	@DataProvider(name="getData")
	public Object[][] getData()

	{

	//row stands for how many different data types test should run

	//column stands for how many values per each test

	Object[][] data=new Object[2][3];

	//0th row

	data[0][0] = "nonrestricteduser@1.com";

	data[0][1] = "123456";

	data[0][2] = "Restricted User";

	//1st row

	data[1][0] = "restricteduser@1.com";

	data[1][1] = "123456";

	data[1][2] = "Non Restricted User";

	return data;

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
