package sobha.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	public static String[][] locate(String path, String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);

		// to get total number of rows
		int rowcount = sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] data = new String[rowcount][colcount];
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				System.out.println(data[i][j]);
			}
		}

		return data;

	}

}
