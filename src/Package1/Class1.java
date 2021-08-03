package Package1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.apache.commons.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;



public class Class1 {
	
	public String extractDataWithSelenium(String url){ 
	
		// TODO Auto-generated method stub*/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amarp\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		 driver.get("http://cogenglab.csd.uwo.ca/rushdi.htm"); 
	      WebElement webElement = driver.findElement(By.xpath("//*[@id='content']")); 
	      System.out.println(webElement.getText()); 
	        
	      return webElement.getText();
	      
	      /*String output = driver.findElement(By.xpath("//*[@id='content']")).getText();
	      File DestFile= new File("D:\\destfile");
	      FileUtils.writeStringToFile(DestFile, output);
	      driver.close();
		return output;*/

		
	}
}
