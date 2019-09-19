package SoniSelenium.SeleniumClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PracticeExcelReading {

	public static void main(String[] args) {

		LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>> map3;
		
		/**Setting and printing FilePath */
		String ProjectPath = System.getProperty("user.dir");
		String FilePath=  ProjectPath + "\\\\TestData\\\\IPT1.xlsx" ;
		System.out.println("FilePath "+FilePath); /**Printing file path */

		File file = new File(FilePath);
		try {
			map3 = new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>>();
			FileInputStream FIS = new FileInputStream(file);
			Workbook workbook = null ;
			if(FilePath.contains(".xlsx")) {
				workbook = new XSSFWorkbook(FIS);
			}

			else if(FilePath.contains(".xls")) {
				workbook = new HSSFWorkbook(FIS);
			}

			int numOfSheets = workbook.getNumberOfSheets();
			System.out.println("Number of sheets this woorkbook has " +numOfSheets);              /**Printing number of spreadsheets any workbook have*/
			//System.out.println(workbook.getSheetName(1)); /**Printing sheet name at given index*/

			for(int i=0;i<numOfSheets;i++) {  /** Loop to get sheets */
				LinkedHashMap<String,LinkedHashMap<String,String>> map2 = new LinkedHashMap<String,LinkedHashMap<String,String>>();
				Sheet sheets = workbook.getSheetAt(i); /**Creating object of the sheets */
				int numOfRows =sheets.getPhysicalNumberOfRows();
				System.out.println("number of active rows " +workbook.getSheetName(i)+ " has  " +numOfRows); /** Number of Active rows any sheet has */

				for (int j=0;j<numOfRows;j++) {  /** Loop to get rows */

					LinkedHashMap<String,String> map1 = new LinkedHashMap<String,String>();
					int ExecutionFlagCellNumber =0;
					Row headerRow = sheets.getRow(0);/**Creating header row object */
					int numOfCellinHeaderRow = headerRow.getPhysicalNumberOfCells(); /**number of cell in the row*/
					for (int m=0;m<numOfCellinHeaderRow;m++) {
						if(headerRow.getCell(m).toString().equalsIgnoreCase("ExecutionFlag")) {
							ExecutionFlagCellNumber = m;
							break;
						}
					}

					Row row = sheets.getRow(j); /**Creating object of the row */
					int numOfCell = row.getPhysicalNumberOfCells();
					//System.out.println("Number of cell in rows "+j+ " of " +workbook.getSheetName(i)+ " " +numOfCell);
					if(row.getCell(ExecutionFlagCellNumber).toString().equals("Y")) {
						for(int k=0;k<numOfCell;k++) { /** Loop to get cell or column */

							Cell cell = row.getCell(k); /**Creating object of the Cell */
							//System.out.println(cell.toString()); /**Printing value of the Cell*/
							String keyofHeader = headerRow.getCell(k).toString();
							String valueofCell = cell.toString();
							map1.put(keyofHeader, valueofCell);

						} //System.out.println(map1);

						String rowKey = row.getCell(0).toString();
						map2.put(rowKey, map1);
					} 
				}  
				//System.out.println(map2);
				String SheetKey = workbook.getSheetName(i).toString();
				//System.out.println(SheetKey);
				map3.put(SheetKey, map2);
			} 

			 System.out.println(map3);

		} 
		catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
