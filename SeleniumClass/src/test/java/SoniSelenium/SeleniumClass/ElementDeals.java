package SoniSelenium.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDeals {

	public static void main(String[] args) {

		String Projectpath= System.getProperty("user.dir");  /**Settingup user directory path*/
		System.out.println(Projectpath);  

		String DriverPath= Projectpath+"/Drivers/chromedriver.exe" ;   /**Setting up driver directory path */
		System.out.println(DriverPath);              

		System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/
		WebDriver driver = new ChromeDriver();    /**Creating object of Webdriver with refernece of ChromeDriver*/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize(); 

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Alexa");
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']")).click();  


	}

}
