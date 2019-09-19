package SoniSelenium.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDeals2 {

	public static void main(String[] args) throws InterruptedException {


		String Projectpath= System.getProperty("user.dir");  /**Settingup user directory path*/
		System.out.println(Projectpath);  

		String DriverPath= Projectpath+"/Drivers/chromedriver.exe" ;   /**Setting up driver directory path */
		System.out.println(DriverPath);              

		System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/
		WebDriver driver = new ChromeDriver();    /**Creating object of Webdriver with refernece of ChromeDriver*/
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();
		 
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vijet.jain27@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9011930186");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
}
