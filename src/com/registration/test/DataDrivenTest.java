package com.registration.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	private static XSSFWorkbook ExcelBook;
	private static XSSFSheet ExcelSheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void setExcelPath(String File, String Sheetname) throws Exception{
		try{
			FileInputStream input = new FileInputStream(File);
			ExcelBook=new XSSFWorkbook(input);
			ExcelSheet=ExcelBook.getSheet(Sheetname);
		} catch(Exception e){
			throw e;
		}
	}
	
	public static String getExcelData(int Rownum, int Colnum) throws Exception{
		try{
			cell=ExcelSheet.getRow(Rownum).getCell(Colnum);
			String Cellvalue = cell.getStringCellValue();
			return Cellvalue;
		} catch(Exception e){
			return "";
		}
	}
	
	public static void SetExcelData(int Rownum, int Colnum, String result) throws Exception{
		try{
			row=ExcelSheet.getRow(Rownum);
			cell=row.getCell(Colnum, Row.RETURN_BLANK_AS_NULL);
			if(cell==null){
				cell=row.createCell(Colnum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			 
			FileOutputStream out = new FileOutputStream("C://Selenium//jenkindemo//src//TestData//TestData.xlsx");
			ExcelBook.write(out);
			out.flush();
			out.close();
			
		} catch(Exception e){
			throw e;
		}
	}
	
	
}
