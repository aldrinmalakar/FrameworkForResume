package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import static utilities.WriteExcelFile.*;

public class ReadExcelFile {

    public static final String FILE_PATH = "../Guru99BankingPortal/src/main/resources/customerID.xlsx";

    public static void main(String[] args) {
    writeExcel();
    }
    public static void writeExcel(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet =  workbook.createSheet("customerID");

        Object[][] customerDetail={
                {"Customer Name", "Customer ID"},
                {"Aldrin Malakar","84996587"},
                {"Shaila Hasib","7489965"}
        };

        int rowNum =0;
        System.out.println("Excel File is created.");
        for (Object[] csDtls : customerDetail){
            Row row = sheet.createRow(rowNum);
            int colNum =0;
            for(Object field:csDtls){
                Cell cell = row.createCell(colNum++);
                if (field instanceof String){
                    cell.setCellValue((String)field);
                } else if (field instanceof Integer){
                    cell.setCellValue((Integer)field);
                }
            }
        }

        try{
            FileOutputStream out = new FileOutputStream(FILE_PATH);
            workbook.write(out);
            workbook.close();
        }catch (FileNotFoundException fn){
            System.out.println("File Not Found In The System");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception.");
        }

    }
}
