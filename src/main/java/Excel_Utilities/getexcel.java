package Excel_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getexcel {
	public static String[][] testdata;
	public static int rownum;
	public static String filename="src\\test\\resources\\testdata\\Demo.xlsx";
   public static void getExcel(String sheet){
	   testdata= new String[3][2];
	  	   File f= new File(filename);
	  	   for(int rownum=0;rownum<3;rownum++){
	   try {
		FileInputStream fis= new FileInputStream(f);
		XSSFWorkbook w=new XSSFWorkbook(fis);
		XSSFSheet s=w.getSheet(sheet);
		XSSFRow r=s.getRow(rownum);
		for(int col=0;col<2;col++){
		XSSFCell c=r.getCell(col);
		testdata[rownum][col]=c.getStringCellValue();
		System.out.println(testdata[rownum][col]);
		}
	    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  	   }
	  	   
   
	  
   }
//   public static void main(String[] args) {
//	   getexcel g= new getexcel();
//	   g.getExcel("Sheet1");	   }
   
}

