package ExcelUtils;

import jdk.dynalink.beans.StaticClass;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReadWrite {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelReadWrite(String excelPath, String sheetName) {
        try {
         String projectPath = System.getProperty("user.dir");
            System.out.println(projectPath);
        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

    }
    public static void main(String[] args) {
        //getRowCount();
        //getCellData();

    }
    public int getRowCount(){


        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of rows = "+rowCount);
        return rowCount;

    }
    public static void getCellData(int rowNum, int colNum){

            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
            System.out.println("Cell Value is= "+value);
    }
}
