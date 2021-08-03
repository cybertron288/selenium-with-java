package Package1;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;


import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class top100 {

	
	 public void writeExcel(String[] dataToWrite) throws IOException{

		 	File file = new File ("D:\\FirstProject\\testFile.xlsx");
	        FileInputStream inputStream = new FileInputStream(file);
	        Workbook blankWorkbook = null;
	        String fileExtensionName = "testFile.xlsx".substring("testFile.xlsx".indexOf("."));
	        
	        if(fileExtensionName.equals(".xlsx")){

	            //If it is xlsx file then create object of XSSFWorkbook class

	        	blankWorkbook = new XSSFWorkbook(inputStream);

	            }

	            //Check condition if the file is xls file

	            else if(fileExtensionName.equals(".xls")){

	                //If it is xls file then create object of XSSFWorkbook class

	            	blankWorkbook = new HSSFWorkbook(inputStream);

	            	
	            }    
	      //Read excel sheet by sheet name    

	        Sheet sheet = blankWorkbook.getSheet("Sheet1");

	        //Get the current count of rows in excel file

	        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

	        //Get the first row from the sheet

	        Row excelRow = sheet.getRow(0);

	        //Create a new row and append it at last of sheet

	        Row newRow = sheet.createRow(rowCount+1);

	        //Create a loop over the cell of newly created Row
	        
	        int p = 0;
	        for (String result: dataToWrite) {
	        	
	        	Cell cell = newRow.createCell(p);
	        	
	        	cell.setCellValue(result);
	      
	        	p++;
	        
	        }

//	        for(int j = 0; j < excelRow.getLastCellNum(); j++){
//
//	            //Fill data in row
//
//	            Cell cell = newRow.createCell(j);
//
//	            cell.setCellValue(dataToWrite[j]);
//
//	        }
	           
	        //Close input stream

	        inputStream.close();

	        //Create an object of FileOutputStream class to create write data in excel file

	        FileOutputStream outputStream = new FileOutputStream(file);

	        //write data in the excel file

	        blankWorkbook.write(outputStream);

	        //close output stream

	        outputStream.close();
	    	
	        }
		
	    

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
		
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi6\\Downloads\\chromedriver.exe");
	    	ChromeDriver driver = new ChromeDriver();
	    	
	        driver.get("https://www.mlb.com/prospects/top100/");   
	        
	        //String output = driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td[1]").getText();
	        //System.out.print(driver.findElementsByXPath("//*[@id=\\\"root\\\"]/div/div/div[3]/table/tbody/tr[1]/td").size());
	        
	        List  col = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td"));
	        System.out.println("No of cols are : " +col.size());

	        List  row = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr"));
	        System.out.println("No of rows are : " +row.size());
	        
	        
	        
	        
//	        driver.findElement(By.cssSelector(".sc-VigVT")).click();
	        
//	        driver.findElement(By.cssSelector(".bio-tab__statValue")).getText();
//	        List<WebElement> results = driver.findElements(By.cssSelector(".bio-tab__statValue"));
//	        for (WebElement result: results) {
//	            String innerhtml = result.getAttribute("innerHTML");
//	            System.out.println("Available openings  are" + innerhtml);
//	        }
	       
//	        List<WebElement> results = driver.findElements(By.cssSelector(".sc-VigVT"));
//	        for (WebElement result: results) {
//	            String innerhtml = result.getAttribute("innerHTML");
//	            System.out.println("Available openings  are" + innerhtml);
//	        }
	        
//	        String clickOpen = driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[2]/div/div[3]/div/ul[1]/li[1]/div[2]").getText();
//	        
//	        System.out.println(driver.findElement(By.cssSelector(".bio-tab__statValue")).getText());
	        
//	        Object obj = new Object();
	        
	        Thread.sleep(1000);
//	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/button")).click();
//	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/button")).click();
	        
	        
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr[1]/td")).click();
	       
	        for (int j =1; j<=row.size(); j++) 
	        {

		        
	        	ArrayList<String> rowAry = new ArrayList<String>();
	        	
		        for (int i =1; i<=col.size(); i++)
		        {
		        String output = driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr["+j+"]/td["+i+"]").getText();
		        
		        
		        
		        rowAry.add(output);
		        
		        }
//		        System.out.println("main page output: " + rowAry);
		        
		        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/table/tbody/tr["+j+"]/td")).click();
		
		 
		        
		        
		        driver.findElement(By.cssSelector(".bio-tab__statValue")).getText();
		        
		        List<WebElement> head = driver.findElements(By.cssSelector(".bio-tab__statName"));
		        List<WebElement> data = driver.findElements(By.cssSelector(".bio-tab__statValue"));
		        
		        
		        ArrayList<String> headArray = new ArrayList<String>();
		        for (WebElement result: head) {
		            String headFor = result.getAttribute("innerHTML");
		          
		            headArray.add(headFor);

		        }
//		        System.out.println("Available Heads are:  " + headArray);
		        
		        
		        ArrayList<String> dataArray = new ArrayList<String>();
		        for (WebElement result: data) {
		        	
		        	String dataFor = result.getAttribute("innerHTML");
			          
		        	dataArray.add(dataFor);
		        
		        }
//		        System.out.println("Available Heads are:  " + dataArray);
		        
		        
		        ArrayList<String> finalMapedArray = new ArrayList<String>();
		        
		       
		        for (int n=1; n<headArray.size(); n++ ) {
		        	ArrayList<String> mapedArray = new ArrayList<String>();
		        	mapedArray.add(headArray.get(n));
		        	mapedArray.add(dataArray.get(n));
//		        	System.out.println("Available Heads are:  " + mapedArray.get(0));
		        	
		        	if(mapedArray.contains("TWITTER")) {
		        		System.out.println("TWITTER Condition");
		        	} else {
		        		finalMapedArray.add(mapedArray.get(1));
		        	};
//		        	finalMapedArray.add(dataArray.get(n));
		        }
		        
		        System.out.println("All Rows are:  " + finalMapedArray);
		        
		        
		        
		        
//		        System.out.println(rowAry);
		        
//		        Timer timer = new Timer();
//		        timer.schedule(new TimerTask() {
//		        	  @Override
//		        	  public void run() {
//		        		  
//		        	  }
//		        	}, 5000);
		        
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[2]/button")).click();
		        Thread.sleep(2000);
		        
		        
		        
		        
		        
		        
		        String [] singleRowArray = finalMapedArray.toArray(new String[finalMapedArray.size()]);      
//		        System.out.println(Arrays.toString(singleRowArray)); 
		        //Create an object of current class
		        top100 objExcelFile = new top100();
		        //Write the file using file name, sheet name and the data to be filled
		        objExcelFile.writeExcel(singleRowArray);


//		        Thread.sleep(6000);
		        
		               
		    }

	    
	}   
	}


