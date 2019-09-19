package SoniSelenium.SeleniumClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MovetoElement {
	public static void main(String[] args) throws InterruptedException {
		String Projectpath= System.getProperty("user.dir");  /**Setting up user directory path*/
		System.out.println(Projectpath);  

		String DriverPath= Projectpath+"/Drivers/chromedriver.exe" ;   /**Setting up driver directory path */
		System.out.println(DriverPath);              

		System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/

		WebDriver driver = new ChromeDriver();    /** Creating object of Webdriver interface with refernece of ChromeDriver class*/

		driver.get("https://classic.crmpro.com/login.cfm");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("himansja");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("ispl123#"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(5000);

		/**Number of frames in webpage */
		int ifarmeSize= driver.findElements(By.tagName("frame")).size();
		System.out.println(ifarmeSize);
		/** Swiching to frame */

		WebElement mainpanelFrame=  driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(mainpanelFrame);


		Actions action = new Actions(driver);
		WebElement companies = driver.findElement(By.xpath("//a[@title='Companies']"));
		WebElement newcompany = driver.findElement(By.xpath("//a[@title='New Company']"));
		action.moveToElement(companies).moveToElement(newcompany).click().build().perform();

		WebElement statusdropdown = driver.findElement(By.xpath("//select[@name='status']"));

		Select sobj = new Select(statusdropdown);

		/** Select by visible text */
		sobj.selectByVisibleText("Inactive");

		/** Select by attribute value */
		WebElement categoryDropdown = driver.findElement(By.xpath("//select[@name='category']"));
		Select sobj1 = new Select(categoryDropdown);
		sobj1.selectByValue("Partner");

		/** Select by index*/
		WebElement priorityDropdown = driver.findElement(By.xpath("//select[@name='priority']"));
		Select sobj2 = new Select(priorityDropdown);
		sobj2.selectByIndex(2);
		
		/** isMultiple Select */
		
		System.out.println(sobj2.isMultiple());

		/** Get all the values from dropdown */
		List<WebElement> optionlist = sobj2.getOptions();

		for(int i=0;i<optionlist.size();i++) {
			System.out.println(optionlist.get(i).getText()); /**Get all the dropdown */
		}
		
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		WebElement em = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
		
		Select s = new Select(em);
		System.out.println(s.isMultiple());
		s.selectByIndex(0);
		s.selectByVisibleText("Switch Commands");
		s.deselectByIndex(0);
		System.out.println("Done");

	}

	
	
}
