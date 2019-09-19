package SoniSelenium.SeleniumClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {

public static void main(String[] args) {
	
	
	String Projectpath= System.getProperty("user.dir");  /**Setting up user directory path*/
	System.out.println(Projectpath);  

	String DriverPath= Projectpath+"/Drivers/chromedriver.exe" ;   /**Setting up driver directory path */
	System.out.println(DriverPath);              

	System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/

	WebDriver driver = new ChromeDriver();    /** Creating object of Webdriver interface with refernece of ChromeDriver class*/

	driver.get("https://www.toolsqa.com/automation-practice-form/");
	
	driver.manage().window().maximize();
	
	List<WebElement> elm = driver.findElements(By.xpath("//select[@id='continents']/option"));
	
	for(int i=0;i<elm.size();i++) {
		
		System.out.println(elm.get(i).getText());
		
		if(elm.get(i).getText().equalsIgnoreCase("Australia")) {
			elm.get(i).click();
		}		
		
	}

}

}
