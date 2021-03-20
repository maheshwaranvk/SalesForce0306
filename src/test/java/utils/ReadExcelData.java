package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.ProjectSpecificMethods;

public class ReadExcelData{

	
	public String[][] readExcelSheet(String name) throws IOException {
	
	
		
		XSSFWorkbook xw = new XSSFWorkbook("./data/"+name+".xlsx");
		
		XSSFSheet sheet = xw.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		
		short columnCount = sheet.getRow(0).getLastCellNum();
		
		String [][] data = new String[rowCount][columnCount];
		
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
xw.close();

return data;
	}
}
