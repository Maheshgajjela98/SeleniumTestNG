package datadriventesting;
	import java.io.File;
	import java.io.FileInputStream;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtil1 {

		public static Object[][] getLoginData() throws Exception {
			String excelPath = System.getProperty("user.dir")
			        + "/src/test/resources/TestData/Book1.xlsx";

			File file = new File(excelPath);


		    FileInputStream fis = new FileInputStream(file);
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheet("Sheet1");
		    
		    int rows = sheet.getLastRowNum();
		    int cols = 2; // we know only username & password

		    Object[][] data = new Object[rows][cols];

		    for (int i = 1; i <= rows; i++) {
		        for (int j = 0; j < cols; j++) {
		            data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
		        }
		    }


		    workbook.close();
		    return data;
		}
	}

