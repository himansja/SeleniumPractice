package SoniSelenium.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassEx {
	public static void main(String[] args) throws InterruptedException {
		String Projectpath= System.getProperty("user.dir");  /**Setting up user directory path*/
		System.out.println(Projectpath);  

		String DriverPath= Projectpath+"/Drivers/chromedriver.exe" ;   /**Setting up driver directory path */
		System.out.println(DriverPath);              

		System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/

		WebDriver driver = new ChromeDriver();    /** Creating object of Webdriver interface with refernece of ChromeDriver class*/

		//driver.get("https://classic.crmpro.com/login.cfm");
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("himansja");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("ispl123#"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);

		
		
		WebElement iframe1= driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(iframe1);

		/** Action class is used for Mouse and Keyboard inputs */
		Actions action = new Actions(driver);
		//WebElement el= driver.findElement(By.xpath(xpathExpression))
		//action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.CONTROL.END).build().perform();


		/**Double Click */  
		/*WebElement clickxpath = driver.findElement(By.xpath("//input[@type='submit']"));
		action.doubleClick().build(); */

		/** LeftClick */
		/*WebElement clickelement = driver.findElement(By.xpath("//a[@onclick='addHomeBoxPanel();']"));
		action.click(clickelement).build().perform();
		WebElement clickelement1 = driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));		
		action.click(clickelement1).build().perform();*/

		/** ContextClick */
		//WebElement we= driver.findElement(By.xpath("//a[@onclick='addHomeBoxPanel();']"));
		
		
		
		//action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		//action.moveToElement(We)
        

		System.out.println("Done");

	}
}
