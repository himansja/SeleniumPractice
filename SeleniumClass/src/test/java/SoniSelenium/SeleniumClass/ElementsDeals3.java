package SoniSelenium.SeleniumClass;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsDeals3 {

	public static void main(String[] args) throws InterruptedException {


		String Projectpath= System.getProperty("user.dir");  /**Setting up user directory path*/
		System.out.println(Projectpath);  

		String DriverPath= Projectpath+"/Drivers/chromedriver.exe" ;   /**Setting up driver directory path */
		System.out.println(DriverPath);              

		System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/
 
		WebDriver driver = new ChromeDriver();    /** Creating object of Webdriver with refernece of ChromeDriver*/

		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();

		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")).click();

		/**Getting value of tag value */
		String Header= driver.findElement(By.xpath("//h2[@class='ui blue header']")).getText();
		System.out.println(Header);

		/**Sending value*/
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vijet.jain27@gmail.com");

		/** Getting attribute value */
		String value= driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
		System.out.println(value);

		
		driver.findElement(By.xpath("//div[@id='country']//i[@class='dropdown icon']")).click();
		Thread.sleep(10000);
		List<WebElement> country= driver.findElements(By.xpath("//div[@id='country']//div[@class='menu transition visible']/child::div"));
		int size= country.size();
		
		System.out.println(size);
		for(int i=0;i<size;i++) {
			WebElement elm = country.get(i);
			System.out.println(elm.getText());
			if(elm.getText().equalsIgnoreCase("Ireland (+353)")) {
				System.out.println("Hello");
				elm.findElement(By.tagName("i")).click();
				break;
			}
			
		}

		
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9011930186");
			driver.findElement(By.xpath("//input[@id='terms']")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		

}

	}
