package flipkart.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readXLSXdata {

	 public static void readingRows() throws Exception {
	      String excelPath = System.getProperty("user.dir") + "\\resources\\testdata.xlsx";
	      XSSFWorkbook workbook = new XSSFWorkbook();
	      XSSFSheet sheet = workbook.getSheet("Login");
	      int rowCount = sheet.getPhysicalNumberOfRows();
	      System.out.println("No. of Rows " + rowCount);
	   }

	   public String readingData(int row_num, int cell_num) throws Exception {
	      File file = new File(System.getProperty("user.dir") + "\\resources\\testdata.xlsx");
	      FileInputStream inputStream = new FileInputStream(file);
	      XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	      XSSFSheet sheet = workbook.getSheet("Login");
	      String value = sheet.getRow(row_num).getCell(cell_num).getStringCellValue();
	      return value;
	   }
}
