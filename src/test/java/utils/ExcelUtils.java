package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {
	
	public static Object[][] readExcel(String filePath, String sheetName) {
		try (FileInputStream file = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(file)) {
			
			Sheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			Object[][] data = new Object[rows - 1][cols];
			for(int i = 1; i<rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < cols; j++) {
					data[i-1][j] = row.getCell(j).getStringCellValue();
				}
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return new Object[0][0];
		}
	}

}
