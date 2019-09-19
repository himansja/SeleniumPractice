package testNG_scenarios_dummytestcases;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelReading;

public class DataProviders {
	
	@Test(dataProvider = "inputdata", description= "Sheet2")
public void loginFunction(String TC_ID, LinkedHashMap<String, String> testCaseInputData) {
		
		System.out.println(TC_ID);
		System.out.println(testCaseInputData.get("UserName"));
		System.out.println(testCaseInputData.get("TestDescription"));
	}
	
	
	
	@DataProvider(name = "inputdata")
	public static Object[][] data(Method m){
		
		/**using reflexion api to read sheetname from parameter level*/
		String sheetname = m.getAnnotation(Test.class).description();
		
		/**Reading data from excel */
		ExcelReading e = new ExcelReading();
		e.excelReading();
		LinkedHashMap<String, LinkedHashMap<String, String>> sheetdateMap=e.getValueBySheetName(sheetname);
		//System.out.println(sheetdateMap);
		
		Object[][] data= new Object[sheetdateMap.size()][2];
		
		Iterator<String> itr=sheetdateMap.keySet().iterator();
		
		int counter=0;
		while(itr.hasNext()) {
			String TC_ID=itr.next();
			data[counter][0]=TC_ID;
			data[counter][1]=sheetdateMap.get(TC_ID);
			counter++;
		}
		
		return data;
	
	}
	
	
}
