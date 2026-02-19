package datadriventesting;

import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getLoginData() throws Exception {

        InputStream is = ExcelUtil.class
                .getClassLoader()
                .getResourceAsStream("TestData/Book1.xlsx");

        if (is == null) {
            throw new RuntimeException(
                "Excel file NOT found in src/test/resources/TestData/Book1.xlsx"
            );
        }

        XSSFWorkbook workbook = new XSSFWorkbook(is);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();
        int cols = 2; // 🔒 HARD LOCK (THIS FIXES EVERYTHING)

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] =
                        sheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        return data;
    }
}
