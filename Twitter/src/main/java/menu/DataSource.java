package menu;

import databases.ConnectToSqlDB;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

    public static List<String> getSearchList(){
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("AlJazeera");
        itemsList.add("Wiz Khalifa");
        itemsList.add("iPhone");
        itemsList.add("Stevie Wonder");
        itemsList.add("Maggi Noodles");
        itemsList.add("Halal Guys");
        itemsList.add("Donald Trump");
        itemsList.add("Brooklyn Bridge");

        return itemsList;
    }

    //Database

    public static List<String> retrieveListFromDb()throws Exception{
        List<String> listFromDb = new ArrayList<>();
        listFromDb = connectToSqlDB.readDataBase("ItemList", "items");
        return listFromDb;
    }


    //Excel

    public void readFile(String filePath, String fileName, String sheetName) throws IOException {

        //Create an object of File class to open xlsx file

        File file = new File(filePath + "/" + fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook ahmedsExcel = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if (fileExtensionName.equals(".xlsx")) {

            //If it is xlsx file then create object of XSSFWorkbook class

            ahmedsExcel = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if (fileExtensionName.equals(".xls")) {

            //If it is xls file then create object of HSSFWorkbook class

            ahmedsExcel = new HSSFWorkbook(inputStream);

        }

        //Read sheet inside the workbook by its name

        Sheet mySheet = ahmedsExcel.getSheet(sheetName);

        //Find number of rows in excel sheet

        int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
        System.out.println("Num of rows: " + rowCount);

        //Create a loop over all the rows of excel file to read it

        for (int i = 0; i < rowCount+1; i++) {

            Row row = mySheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console

                System.out.print(row.getCell(j).getStringCellValue() + "|| ");

            }

            System.out.println();
        }

    }

    //  To Write On Excel
    public void writeExcel(String filePath, String fileName, String sheetName, String[]dataToWrite) throws IOException{

        //Create an object of File class to open xlsx file

        File file = new File(filePath + "/" + fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook sheetTitle = null;

        //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class

            sheetTitle = new XSSFWorkbook(inputStream);
        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            sheetTitle = new HSSFWorkbook(inputStream);
        }
        //Read excel sheet by sheet name

        Sheet mySheet = sheetTitle.getSheet(sheetName);

        //Get the current count of rows in excel file

        int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();

        //Get the first row from the sheet

        Row row = mySheet.getRow(0);

        //Create a new row and append it at last of sheet

        Row newRow = mySheet.createRow(rowCount+1);

        //Create a loop over the cell of newly created Row

        for(int j = 0; j < row.getLastCellNum(); j++){

            //Fill data in row

            Cell cell = newRow.createCell(j);

            cell.setCellValue(dataToWrite[j]);

        }

        //Close input stream

        inputStream.close();

        //Create an object of FileOutputStream class to create write data in excel file

        FileOutputStream outputStream = new FileOutputStream(file);

        //write data in the excel file

        sheetTitle.write(outputStream);

        //close output stream

        outputStream.close();

    }



//    Main function is calling readExcel function to read data from excel file

    public static void main(String[] args) throws IOException {

        //Create an object of ReadGuru99ExcelFile class

        DataSource objExcelFile = new DataSource();

        //Call read file method of the class to read data

        objExcelFile.readFile("/Users/isti/Downloads/","excelexample.xlsx","mySheet");

    }

}
