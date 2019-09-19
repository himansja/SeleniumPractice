package SoniSelenium.SeleniumClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TableCalendar {
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
		WebElement calendar = driver.findElement(By.xpath("//a[@title='Calendar']"));
		WebElement newEvent = driver.findElement(By.xpath("//a[@title='New Event']"));
		action.moveToElement(calendar).moveToElement(newEvent).click().build().perform();

		driver.findElement(By.xpath("//input[@id='fieldId_start']/following-sibling::img[@title='Date selector']")).click();

		WebElement tableobj = driver.findElement(By.xpath("//div[@class='calendar']/child::table[@style='visibility: visible;']"));

		/**for body */

		WebElement tbodyobj = tableobj.findElement(By.tagName("tbody"));
		//System.out.println(tbodyobj.getText());
		List<WebElement> trRowslistObj = tbodyobj.findElements(By.tagName("tr"));
		for(int i=0;i<trRowslistObj.size();i++) {
			WebElement eachRowObj= trRowslistObj.get(i);

			List<WebElement> tdColumnObj = eachRowObj.findElements(By.tagName("td"));
			for(int j=0;j<tdColumnObj.size();j++) {
				WebElement eachColObj = tdColumnObj.get(j);
				if(eachColObj.getAttribute("class").equalsIgnoreCase("day")) {
					System.out.println(eachColObj.getText());
				}
			}
		}



	}
}
