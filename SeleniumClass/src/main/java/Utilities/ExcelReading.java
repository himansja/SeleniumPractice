package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String, String>>> map3 ;

	public LinkedHashMap<String, LinkedHashMap<String, String>> getValueBySheetName(String sheetName) {

		return map3.get(sheetName);


	}
	public LinkedHashMap<String,String> getValueByTcId(String SheetName, String testCaseID) {

		return map3.get(SheetName).get(testCaseID);

	}
	public String getValueByColName(String SheetName, String testCaseID, String Row) {
		return map3.get(SheetName).get(testCaseID).get(Row);

	}


	public void excelReading() {

		/**Setting path of the file */

		String projectPath =System.getProperty("user.dir");
		String testDataFilePath = projectPath+ "\\TestData\\IPT.xlsx";
		System.out.println("Path of my test file =" +testDataFilePath);

		/** Creating object of a file and passing argument as the path of the file */

		File f = new File(testDataFilePath);

		try {

			map3 = new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String, String>>>();

			/** Creating object of input reader class  and passing the argument as object if File class or type*/
			FileInputStream readFile = new FileInputStream(f);

			/**Creating object reference of Workbook interface */
			Workbook workbook = null;

			if(testDataFilePath.contains(".xlsx")) {
				workbook = new XSSFWorkbook(readFile);
			}

			else if(testDataFilePath.contains(".xls")) {
				workbook = new HSSFWorkbook(readFile);
			}

			/**Printing number of sheet excel file has */
			int noOfSheets = workbook.getNumberOfSheets();
			System.out.println("Number of Sheets "+noOfSheets);


			/**Printing sheet name of excel workbook */
			for(int i= 0;i<workbook.getNumberOfSheets();i++) {
				LinkedHashMap<String, LinkedHashMap<String, String>> map2 = new LinkedHashMap<String,LinkedHashMap<String,String>>();
				
				/**Printing sheetname of the workbook*/
				//System.out.println(workbook.getSheetName(i));

				
				/** selecting any sheet of the workbook */
				String SheetsName = workbook.getSheetName(i);
				//if(workbook.getSheetName(i).equalsIgnoreCase("Sheet6")) {

				/**Creating object of the sheet */
				Sheet worksheet = workbook.getSheetAt(i);
				
				/**Printing number of Active rows in a sheet */
				System.out.println("Number of rows in my sheet " +worksheet.getPhysicalNumberOfRows());

				Row HeaderObj = worksheet.getRow(0);
				int executionCellNumber = 0;
				for(int m=0;m<HeaderObj.getPhysicalNumberOfCells();m++) {
					if(HeaderObj.getCell(m).toString().equalsIgnoreCase("ExecutionFlag")) {
						executionCellNumber = m;
						break;
					}
				}


				for(int j=0; j<worksheet.getPhysicalNumberOfRows();j++) {

					LinkedHashMap<String, String> map1 = new LinkedHashMap<String,String>();
					/** Creating object of the Row of the selected sheet */
					Row worksheetRow = worksheet.getRow(j);
					//System.out.println(worksheetRow.getPhysicalNumberOfCells());
					if(worksheetRow.getCell(executionCellNumber).toString().equalsIgnoreCase("Y")) {

						for(int k =0; k<worksheetRow.getPhysicalNumberOfCells();k++) {

							/**Creating object of the Cell */
							Cell cell = worksheetRow.getCell(k);
							String Key = HeaderObj.getCell(k).toString();
							String value = cell.toString();
							map1.put(Key, value);
						}	

						//System.out.println(map1);
						String uniqueTCID = worksheetRow.getCell(0).toString();
						map2.put(uniqueTCID, map1);
					}

				}
				//System.out.println(map2);
				map3.put(SheetsName, map2);
				//}
			}
			//System.out.println(map3);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
