package com.liveproject.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {

	// Test Data driven Excel file path
	public static String path = System.getProperty("user.dir") + "//src//test//resources//TestData//TestData.xlsx";

	// instance Variable
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook wb = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	// contrutor
	public ExcelLibrary() {

		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook();
			sheet = wb.getSheetAt(0);
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	// find whether sheets exists
	public boolean isSheetExist(String sheetName) {
		int index = wb.getSheetIndex(sheetName);
		if (index == -1) {
			index = wb.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}
	// returns the row count in a sheet by sheet name
	public int getRowcount(String sheetname) {

		int sheetIndex = wb.getSheetIndex(sheetname);

		if (sheetIndex == -1) {

			return 0;
		} else {
			sheet = wb.getSheetAt(sheetIndex);
			int lrowCount = sheet.getLastRowNum() + 1;
			return lrowCount;
		}

	}

	public int getColcount(String sheetname) {
		if (!isSheetExist(sheetname))
			return 0;
		int sheetIndex = wb.getSheetIndex(sheetname);

		if (sheetIndex == -1) {

			return 0;
		} else {
			sheet = wb.getSheetAt(sheetIndex);
			int lrowCount = sheet.getLastRowNum() + 1;
			return lrowCount;
		}

	}

	public String getCellData(String sheetname, String colname, int rownum) {

		try {
			if (rownum <= -1) {
				return "";
			}

			int shIndex = wb.getSheetIndex(sheetname);
			int col_Num = -1;

			if (shIndex == -1) {
				return "";
			}

			sheet = wb.getSheetAt(shIndex);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colname.trim())) {
					col_Num = i;
				}
			}
			if (col_Num == -1) {
				return "";
			}
		} catch (Exception e) {

		}

		return colname;

	}

}
