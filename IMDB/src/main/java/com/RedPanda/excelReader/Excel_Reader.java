package com.RedPanda.excelReader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	//public Excel_Reader(){}
	
	public Excel_Reader(String path){
		this.path=path;
		try {
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[][] getDataFromSheet(String sheetName,String ExcelPath){
		String dataSets[][]=null;
		try {
			sheet=workbook.getSheet(sheetName);
			int totalRow=sheet.getLastRowNum()+1;
			System.out.println("Total Row="+totalRow);
			int totalColumn=sheet.getRow(0).getLastCellNum();
			System.out.println("Total Column="+totalColumn);
			dataSets=new String[totalRow-1][totalColumn];
			
			for(int i=1;i<totalRow;i++) {
				XSSFRow rows=sheet.getRow(i);
				
				for(int j=0;j<totalColumn;j++) {
					XSSFCell cell=rows.getCell(j);
					if(cell.getCellType()==cell.CELL_TYPE_STRING) {
						dataSets[i-1][j]=cell.getStringCellValue();
					}
					else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
					{
						String cellText=String.valueOf(cell.getNumericCellValue());
						dataSets[i-1][j]=cellText;
					}
					else
					{
						dataSets[i-1][j]=String.valueOf(cell.getBooleanCellValue());
					}
				}
				
			}
			return dataSets;
		}
		catch(Exception e) {
			e.printStackTrace();
			return dataSets;
		}
		}
		
	public String getCellData(String sheetName,String colName,int rowNum) {
		try {
			int colNum=0;
			int index=workbook.getSheetIndex(sheetName);
			sheet=workbook.getSheetAt(index);
			XSSFRow row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().equals(colName)){
					colNum=i;
					break;
				}
				
			}
			row=sheet.getRow(rowNum-1);
			XSSFCell cell=row.getCell(colNum);
			
			if(cell.getCellType()==cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==cell.CELL_TYPE_BLANK){
				return "";
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	}
	

