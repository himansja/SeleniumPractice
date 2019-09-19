package SoniSelenium.SeleniumClass;

import Utilities.ExcelReading;

public class ExcelReadingClass {

	
	public static void main(String[] args)  {

		ExcelReading e = new ExcelReading();
		e.excelReading();
		System.out.println(e.getValueBySheetName("Sheet6"));

	}

}
