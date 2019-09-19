package SoniSelenium.SeleniumClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class RedBusDatePicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);

		String chromedriverpath = projectpath+ "/Drivers/chromedriver.exe";
		System.out.println(chromedriverpath);

		System.setProperty("webdriver.chrome.driver", chromedriverpath);

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(1000);

		//String popup = driver.switchTo().alert().getText();
		//System.out.println(popup);
		//driver.switchTo().alert().accept();
		//driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bhopal");

		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();

		WebElement tableobj =driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/child::table[@class='rb-monthTable first last']"));
		System.out.println(tableobj);
		WebElement forwardArrow = tableobj.findElement(By.xpath("tbody/tr[@class='rb-monthHeader']/td[2]"));
		Actions action =  new Actions(driver);





		List<WebElement> tablebodyObj = tableobj.findElements(By.tagName("tr"));
		for(int i=0;i<tablebodyObj.size();i++) {
			//String tbody= tablebodyObj.get(i).getText();
			WebElement tablerowObj= tablebodyObj.get(i);

			List<WebElement> tableColObj = tablerowObj.findElements(By.tagName("td"));
			for(int j=0;j<tableColObj.size();j++) {
				WebElement eachcellobj = tableColObj.get(j);
				//String col = tableColObj.get(j).getText();
				//System.out.println(col);
				
				while(!(tableColObj.get(j).getText().equalsIgnoreCase("May 2021"))) {
					action.moveToElement(forwardArrow).click().build().perform();;					
				}


			}


		}


		System.out.println("Done");


	}

}

