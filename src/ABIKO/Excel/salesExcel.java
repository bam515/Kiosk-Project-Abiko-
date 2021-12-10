package ABIKO.Excel;

import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class salesExcel {
	
	public salesExcel() {
		String version = "xlsx";
		
		Workbook workbook = createWorkbook(version);
		
		Sheet sheet = workbook.createSheet("Sales by date");
		
		Cell cell = getCell(sheet, 0, 0);
		cell.setCellValue("Order Table");
		
		cell = getCell(sheet, 0, 1);
		cell.setCellValue("ID");
		
		cell = getCell(sheet, 0, 2);
		cell.setCellValue("ORDER ID");
		
		cell = getCell(sheet, 0, 3);
		cell.setCellValue("ITEM");
		
		cell = getCell(sheet, 0, 4);
		cell.setCellValue("PRICE");
		
		cell = getCell(sheet, 0, 5);
		cell.setCellValue("COUNT");
		
		cell = getCell(sheet, 0, 6);
		cell.setCellValue("TIME");
		
		cell = getCell(sheet, 2, 1);
	}
	
	public Workbook createWorkbook(String version) {
		
		if ("xls".equals(version)) {
			return new HSSFWorkbook();
		} else if ("xlsx".equals(version)) {
			return new HSSFWorkbook();
		}
		throw new NoClassDefFoundError();
	}
	
	public Row getRow(Sheet sheet, int rownum) {
		Row row = sheet.getRow(rownum);
		if (row == null) {
			row = sheet.createRow(rownum);
		}
		return row;
	}
	
	public Cell getCell(Row row, int cellnum) {
		Cell cell = row.getCell(cellnum);
		if (cell == null) {
			cell = row.createCell(cellnum);
		}
		return cell;
	}
	
	public Cell getCell(Sheet sheet, int rownum, int cellnum) {
		Row row = getRow(sheet, rownum);
		return getCell(row, cellnum);
	}
	
	public void writeExcel(Workbook workbook, String filepath) {
		try (FileOutputStream stream = new FileOutputStream(filepath)) {
			workbook.write(stream);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new salesExcel();
	}
}
