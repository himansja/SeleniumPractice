package SoniSelenium.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrame {

	public static void main(String[] args) throws InterruptedException {
		String Projectpath= System.getProperty("user.dir");  /**Setting up user directory path*/
		System.out.println(Projectpath);  

		String DriverPath= Projectpath+"/Drivers/chromedriver.exe" ;   /**Setting up driver directory path */
		System.out.println(DriverPath);              

		System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/

		WebDriver driver = new ChromeDriver();    /** Creating object of Webdriver interface with refernece of ChromeDriver class*/

		driver.get("https://classic.crmpro.com/login.cfm");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("himansja");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("ispl123#"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		/**Number of frames in webpage */
		int ifarmeSize= driver.findElements(By.tagName("frame")).size();
		System.out.println(ifarmeSize);
		/** Swiching to frame */
		
		WebElement iframe1= driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(iframe1);
	
		driver.findElement(By.xpath("//a[@onclick='addHomeBoxPanel();']")).click();
		Thread.sleep(5000);
		String title =driver.findElement(By.xpath("//div[@id='ibox_footer']")).getText();
		System.out.println(title);
		driver.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@onclick='expandPanel(this);']")).click();
		
		/**Exiting the iframe */
		driver.switchTo().defaultContent();
		
		String header =driver.findElement(By.xpath("//head/child::title[text()='CRMPRO']")).getText();
		System.out.println("Main Body" +header);
		
		
	}
	
	
}
