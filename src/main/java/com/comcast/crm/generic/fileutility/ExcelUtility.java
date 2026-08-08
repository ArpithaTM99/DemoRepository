package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;		
	}
	
	//Method to Count the Row 
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;	
	}
	
	//Method to add/Create cell
	public void setDataIntoExcel(String sheetNmae, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetNmae).getRow(rowNum).createCell(cellNum);
		FileOutputStream fos = new FileOutputStream("./testData/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
