package SoniSelenium.SeleniumClass;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;



public class calendar {

	
	public static void main(String[] args) throws ParseException {
			
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(year);
		
		   Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse("Janurary");
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(date);
		    int month = cal.get(Calendar.MONTH);
		    int m = month+1;
		    System.out.println(m);
		    
		    /** to conver int mobth to String month */
		    
		   String monthString = new DateFormatSymbols().getMonths()[1];
		   System.out.println(monthString);
		    
	}
}
