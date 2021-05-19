package com.excel.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelWriteDemo {
	
	public static void main(String[] args) {
		
		String filePath = "/Users/karthikreddy/eclipse-workspace/Batch10MvnAutomationProj/src/main/resources/testData.xls";
		File file = new java.io.File(filePath);
		
		FileOutputStream fos = null;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		
		try {
			fos = new FileOutputStream(file);
			
			workbook = Workbook.createWorkbook(fos);
			sheet = workbook.createSheet("Credentials", 0);
			
			Label unameHdr = new Label(0, 0, "UserName");
			Label pwdHdr = new Label(1, 0, "Password");
			Label tstuser1 = new Label(0, 1, "Karthik");
			Label tstuser2 = new Label(0, 2, "Kiran");
			Label tstuser3 = new Label(0, 3, "Priya");
			Label tstuser4 = new Label(0, 4, "Javed");
			Label tstpwd1 = new Label(1, 1, "test123");
			Label tstpwd2 = new Label(1, 2, "test234");
			Label tstpwd3 = new Label(1, 3, "test345");
			Label tstpwd4 = new Label(1, 4, "test238");
			
			
			sheet.addCell(unameHdr);
			sheet.addCell(pwdHdr);
			sheet.addCell(tstuser1);
			sheet.addCell(tstuser2);
			sheet.addCell(tstuser3);
			sheet.addCell(tstuser4);
			sheet.addCell(tstpwd1);
			sheet.addCell(tstpwd2);
			sheet.addCell(tstpwd3);
			sheet.addCell(tstpwd4);
			
			workbook.write();
			workbook.close();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
