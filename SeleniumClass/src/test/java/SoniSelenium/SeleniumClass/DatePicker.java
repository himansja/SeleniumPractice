package SoniSelenium.SeleniumClass;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DatePicker {
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
		int userinputyear =2024;
		int userInputMonth = 5;
		int userInputDate = 21;

		/** for header */

		WebElement tableheader = tableobj.findElement(By.tagName("thead"));
		WebElement moveBackSelectYear=tableheader.findElement(By.xpath("tr[2]/td/div[text()='«']"));
		WebElement moveBackSelectMonth=tableheader.findElement(By.xpath("tr[2]/td/div[text()='‹']"));
		WebElement yearElement=tableheader.findElement(By.xpath("tr[1]/td[@class='title']"));
		WebElement moveForwardSelectMonth = tableheader.findElement(By.xpath("//tr[2]/td[4]/div[text()='›']"));
		WebElement moveForwardSelectYear = tableheader.findElement(By.xpath("//tr[2]/td[5]/div[text()='»']"));

		/** Converting CRM Year string  to Interger */
		String yearElm = yearElement.getText();
		System.out.println(yearElm);
		String[] crmYear = yearElm.split(", ");

		int currentYearOfCrm = new Integer(crmYear[1]);
		System.out.println(currentYearOfCrm);


		/** Code to convert CRM month string to integer*/
		Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(crmYear[0]);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int m = month+1;
		System.out.println(m);


		/**Converting user input date,month & Year into String */

		String userinputyearinString = Integer.toString(userinputyear);
		String userinputdateinString = Integer.toString(userInputDate);

		/** Converting user input month to String Month for ex: 1= Janurary, 2=Feb */
		String userInputMonthString =new DateFormatSymbols().getMonths()[userInputMonth-1];


		if(userinputyear <= currentYearOfCrm) {

			while(!(yearElement.getText().contains(userinputyearinString))) {

				System.out.println(yearElement.getText());
				moveBackSelectYear.click();
				Thread.sleep(2000);
			}

			if(userInputMonth<m) {

				while(!(yearElement.getText().contains(userInputMonthString))) {

					System.out.println(yearElement.getText());
					moveBackSelectMonth.click();
					Thread.sleep(2000);

				}
			}

			else {
				while(!(yearElement.getText().contains(userInputMonthString))) {

					System.out.println(yearElement.getText());
					moveForwardSelectMonth.click();
					Thread.sleep(2000);
				}
			}

			/**for body */

			WebElement tbodyobj = tableobj.findElement(By.tagName("tbody"));
			//System.out.println(tbodyobj.getText());
			List<WebElement> trRowslistObj = tbodyobj.findElements(By.tagName("tr"));
			for(int i=0;i<trRowslistObj.size();i++) {
				WebElement eachRowObj= trRowslistObj.get(i);

				List<WebElement> tdColumnObj = eachRowObj.findElements(By.tagName("td"));
				for(int j=0;j<tdColumnObj.size();j++) {
					WebElement eachcellObj = tdColumnObj.get(j);

					if(!(eachcellObj.getAttribute("class").equals("wk"))) {
						if(eachcellObj.getText().equals(userinputdateinString)) {
							eachcellObj.click();
						}
					}
				}
			}
		}

		else {
			while(!(yearElement.getText().contains(userinputyearinString))) {

				System.out.println(yearElement.getText());
				moveForwardSelectYear.click();
				Thread.sleep(2000);
			}

			if(userInputMonth<m) {

				while(!(yearElement.getText().contains(userInputMonthString))) {

					System.out.println(yearElement.getText());
					moveBackSelectMonth.click();
					Thread.sleep(2000);

				}
			}

			else {
				while(!(yearElement.getText().contains(userInputMonthString))) {

					System.out.println(yearElement.getText());
					moveForwardSelectMonth.click();
					Thread.sleep(2000);
				}
			}

			/**for body */

			WebElement tbodyobj = tableobj.findElement(By.tagName("tbody"));
			//System.out.println(tbodyobj.getText());
			List<WebElement> trRowslistObj = tbodyobj.findElements(By.tagName("tr"));
			for(int i=0;i<trRowslistObj.size();i++) {
				WebElement eachRowObj= trRowslistObj.get(i);

				List<WebElement> tdColumnObj = eachRowObj.findElements(By.tagName("td"));
				for(int j=0;j<tdColumnObj.size();j++) {
					WebElement eachcellObj = tdColumnObj.get(j);

					if(!(eachcellObj.getAttribute("class").equals("wk"))) {
						if(eachcellObj.getText().equals(userinputdateinString)) {
							eachcellObj.click();
						}
					}
				}
			}
		}

	}
}















