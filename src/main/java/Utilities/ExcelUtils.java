package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
static XSSFWorkbook w;
static XSSFSheet s;
	public static void SetupExcel(String filepath,String sheet) throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		w = new XSSFWorkbook(fis);
		s = w.getSheet(sheet);		
	}
	
	public static String getCellData(int r, int c) {
		String data = s.getRow(r).getCell(c).toString();
		return data;
	}
	
	public static int getRowCount() {
		int count = s.getPhysicalNumberOfRows();
		return count;
	}
}
