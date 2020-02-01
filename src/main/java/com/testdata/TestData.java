package com.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.TestUtil.TestUtil;


public class TestData {

	public static org.apache.poi.ss.usermodel.Sheet Sheet;
	public static Row row;
	public static org.apache.poi.ss.usermodel.Cell cell;
	
	public static Object[][] getData (String sheetname) throws IOException{
		
		String [][] arr;
		File file=new File(TestUtil.SHEETPATH);
		FileInputStream fis= new FileInputStream(file);
		Workbook workbook=null;
		String filenamextension=TestUtil.filename.substring(TestUtil.filename.indexOf("."));
		if (filenamextension.equalsIgnoreCase(".xlsx")){
			
			workbook= new XSSFWorkbook(fis);
			
		}else if(filenamextension.equalsIgnoreCase(".xls")){
			workbook= new HSSFWorkbook(fis);
		}
		
		Sheet=workbook.getSheet(sheetname);
		int Totalrows=Sheet.getLastRowNum();
		int Totalcols=Sheet.getRow(0).getLastCellNum();
		System.out.println("TotalRows:"+Totalrows);
		System.out.println("TotalCols:"+Totalcols);
		
		arr= new String[Totalrows-1][Totalcols];
		int ci=0;
		int cj=0;
		for (int i=1; i<2; i++, ci++){
			
			for (int j=0; j<Totalcols; j++, cj++){
				
				arr[ci][cj]=getcelldata(i,j);
				System.out.println(arr[ci][cj]);
			}
		}
		
		return arr;
		
		
		
	}
	
	public static String getcelldata(int row, int col){
		
		
		cell=Sheet.getRow(row).getCell(col);
		int datatype=cell.getCellType();
		if (datatype==cell.CELL_TYPE_NUMERIC){
			
			
			cell.setCellType(cell.CELL_TYPE_STRING);
			String cell1=cell.getStringCellValue();
			return cell1;
			
			
		}else{
			
			String cell1=cell.getStringCellValue();
			return cell1;
		}
		
		
		
		
		
		
	}
}
