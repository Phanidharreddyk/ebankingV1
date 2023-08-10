package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLS {
	
	@DataProvider(name = "data")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException
	{
		
		String sheetName = m.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		//System.out.println(rows+" "+cols);
		
		DataFormatter format = new DataFormatter();
		
		String[][] data = new String[rows][cols];
		
		for(int i=1;i<=rows;i++) {
			for(int j=0 ;j<cols;j++) {
				
				data[i-1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return data;
		
	}
}
