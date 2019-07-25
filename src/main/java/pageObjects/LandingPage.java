package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.*;

public class LandingPage {

	public WebDriver driver;
	@FindBy 
	
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath(" //h2[contains(text(),'Featured Courses')]");
	By NavBar=By.xpath(" //ul[@class='nav navbar-nav navbar-right']");
	

	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);

	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);

	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);

	}

	
}
