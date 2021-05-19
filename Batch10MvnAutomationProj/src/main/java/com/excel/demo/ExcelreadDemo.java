package com.excel.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelreadDemo {
	
	public static void main(String[] args) {
		
		String filePath = "/Users/karthikreddy/eclipse-workspace/Batch10MvnAutomationProj/src/main/resources/testData.xls";
		File file = new java.io.File(filePath);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = Workbook.getWorkbook(fis);
			Sheet sh = workbook.getSheet(0);
			int rows = sh.getRows();
			int cols = sh.getColumns();
			
			for(int r=0;r<rows;r++) {
				System.out.println("Row: "+r);
				for (int c = 0; c < cols; c++) {
					System.out.println("Column: "+c);
						Cell cell = sh.getCell(c, r);
						System.out.println(cell.getContents());
				}	
			}
			
			workbook.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
