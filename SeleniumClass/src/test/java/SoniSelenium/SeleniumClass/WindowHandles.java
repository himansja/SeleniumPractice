package SoniSelenium.SeleniumClass;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandles {
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
		WebElement blog = driver.findElement(By.xpath("//a[@title='Blog']"));
		action.moveToElement(blog).click().build().perform();

		Set<String> windowsHandleSet = driver.getWindowHandles();
		ArrayList <String> windowhandlelist = new ArrayList<String>(windowsHandleSet);
		for(int i=0;i<windowhandlelist.size();i++) {
			System.out.println(windowhandlelist.get(i));
			String pageTitle = driver.switchTo().window(windowhandlelist.get(i)).getTitle();
			Thread.sleep(2000);
			System.out.println(pageTitle);

			if(pageTitle.contains("CRMPRO Professional CRM Software – Cloud and Licensed")) {
				System.out.println("inside 2nd page");
				Thread.sleep(10000);
				WebElement sampression = driver.findElement(By.xpath("//a[@title='Sampression']"));
				if(sampression.isEnabled()) {
					action.moveToElement(sampression).build().perform();
					Thread.sleep(5000);
					sampression.click();
					Set<String> ThridWindowhandleSet = driver.getWindowHandles();
					ArrayList<String> ThridWindowhandleSetList = new ArrayList<String>(ThridWindowhandleSet);
					for(int j=0;j<ThridWindowhandleSetList.size();j++) {
						String newPageTitle = driver.switchTo().window(ThridWindowhandleSetList.get(j)).getTitle();
						System.out.println(newPageTitle);
						Thread.sleep(2000);
						if(newPageTitle.contains("Premium Responsive WordPress Themes for Blog and Business")){
							driver.close();
						}
						else if(newPageTitle.contains("CRMPRO – CRMPRO Professional CRM Software – Cloud and Licensed"))	{
							driver.close();
						}
						else {
							Set<String> mainWindowID = driver.getWindowHandles();
							ArrayList<String> mainWindowIDList = new ArrayList<String>(mainWindowID);
							for(int k=0;k<mainWindowIDList.size();k++) {
								 String mainWindowPageTitle= driver.switchTo().window(mainWindowIDList.get(k)).getTitle();
								 System.out.println("inside k loop"+mainWindowPageTitle);
								 if(mainWindowPageTitle.equalsIgnoreCase("CRMPRO")) {
									 System.out.println("inside parent window");
								 
									Thread.sleep(5000);
									driver.switchTo().frame(mainpanelFrame);
									Thread.sleep(2000);
									WebElement calendar = driver.findElement(By.xpath("//a[@title='Calendar']"));
									WebElement newEvent = driver.findElement(By.xpath("//a[@title='New Event']"));
									action.moveToElement(calendar).moveToElement(newEvent).click().build().perform();
									
								 }
							}
						}

					}
				}
				else 
				{
					System.out.println("not intractable");
				}


			}

		}
		System.out.println("done");
	}
}