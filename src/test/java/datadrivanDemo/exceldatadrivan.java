package datadrivanDemo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class exceldatadrivan {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	//	XSSFWorkbook workbook;
		XSSFSheet excelsheet;
		XSSFRow row;
		XSSFCell cell;
		File excelfile = new File("C:\\testdata.xlsx");
		FileInputStream fis=new FileInputStream(excelfile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		excelsheet=workbook.getSheetAt(0);
		int ttlrow=excelsheet.getLastRowNum()+1;
		int ttlcell=excelsheet.getRow(0).getLastCellNum();
		for(int currentrow=0;currentrow<ttlrow;currentrow++)
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys(excelsheet.getRow(currentrow).getCell(0).toString());
			driver.findElement(By.id("password")).sendKeys(excelsheet.getRow(currentrow).getCell(1).toString());
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(3000);
			driver.quit();
		}
		
		
	}

}
