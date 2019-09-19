package SoniSelenium.SeleniumClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploading {
	public static void main(String[] args) throws InterruptedException, ParseException {
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
		

		Thread.sleep(3000);

		/**Number of frames in webpage */
		int ifarmeSize= driver.findElements(By.tagName("frame")).size();
		System.out.println(ifarmeSize);
		/** Swiching to frame */

		WebElement mainpanelFrame=  driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(mainpanelFrame);


		Actions action = new Actions(driver);
		

		WebElement importoption = driver.findElement(By.xpath("//a[@title='Import']"));
		action.moveToElement(importoption).click().build().perform();
		Thread.sleep(1000);
		WebElement chooseFile = driver.findElement(By.xpath("//input[@name='import_file']"));
		action.moveToElement(chooseFile).click().build().perform();
		
		Thread.sleep(2000);
		
		String filePath = Projectpath+ "\\TestData\\authToken.png"; 
		System.out.println(filePath);
		/**Copy your content */
		StringSelection ss = new StringSelection(filePath);
		Thread.sleep(1000);
		/**Toolkit to paste content in your clipbaord */
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
			
			
			
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Done");
		
		
	}
}
