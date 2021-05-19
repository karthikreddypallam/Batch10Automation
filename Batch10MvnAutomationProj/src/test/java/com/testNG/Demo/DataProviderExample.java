package com.testNG.Demo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.openMRS.pages.LoginPage;
import com.openMRS.tests.BaseTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProviderExample extends BaseTest {
	
	//Data Provider and Data Consumer
	
	@Test(dataProvider="testDataFromExcel")
	public void testLogin(String user, String pass) {
		LoginPage login = new LoginPage(driver);
		login.login(user, pass);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] testData() {
		Object[][] data = new Object[2][2];
		
		data[0][0] = "Karthik";
		data[0][1] = "testPwd1";
		data[1][0] = "Kiran";
		data[1][1] = "testPwd2";
		return data;
	}
	
	@DataProvider
	public Object[][] testDataFromExcel() {
		Object[][] data = null;
		String filePath = "/Users/karthikreddy/eclipse-workspace/Batch10MvnAutomationProj/src/main/resources/testData.xls";
		File file = new java.io.File(filePath);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = Workbook.getWorkbook(fis);
			Sheet sh = workbook.getSheet(0);
			int rows = sh.getRows();
			int cols = sh.getColumns();
			data = new Object[rows][cols];
			for(int r=0;r<rows;r++) {
				System.out.println("Row: "+r);
				if(r>0) {
					for (int c = 0; c < cols; c++) {
						System.out.println("Column: "+c);
						Cell cell = sh.getCell(c, r);
						System.out.println(cell.getContents());
						data[r][c] = cell.getContents();
					}
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
		
		return data;
	}

}
