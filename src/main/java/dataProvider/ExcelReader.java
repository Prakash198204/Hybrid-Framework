package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static XSSFWorkbook wb;

	public static Object[][] getdatafromsheet(String sheetName) {

		System.out.println("**************** Loading data from excel *****************");

		Object[][] arr = null;

		try {
			// load excel
			wb = new XSSFWorkbook(
					new FileInputStream(new File(System.getProperty("user.dir") + "/Testdata/TestData.xlsx")));
			// load sheet
			XSSFSheet sh1 = wb.getSheet(sheetName);
			//get rows
			int row = sh1.getPhysicalNumberOfRows();
			//get columns
			int col = sh1.getRow(0).getPhysicalNumberOfCells();
			//create array based on rows and columns from excel
			arr = new Object[row-1][col];
			
			// transport data from excel to 2D object array
			for (int i = 1; i < row; i++) {

				for (int j = 0; j < col; j++) {

					arr[i-1][j] = getdata(sheetName, i, j);
					
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File could not find " + e.getMessage());
		} catch (IOException e) {
			System.out.println("File could not load " + e.getMessage());
		}
		
		return arr;
	}
	
	public static String getdata(String sheetName, int row, int col) {
		
		XSSFCell cell= wb.getSheet(sheetName).getRow(row).getCell(col);
		String data="";
		
		if(cell.getCellType()==CellType.STRING) {
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC){
			double doublevalue = cell.getNumericCellValue();
			data=String.valueOf(doublevalue);
			
		}
		else {
			data="";
		}
		return data;
	}
	
	

}
