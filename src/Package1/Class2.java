package Package1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class2 {
	public String extractDataWithSelenium(String url) throws IOException{ 
		
		// TODO Auto-generated method stub*/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amarp\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		 driver.get("http://cogenglab.csd.uwo.ca/rushdi.htm"); 
	      
		 File myObj = new File("D:\\destfile.txt");
	      
	      String output = driver.findElement(By.xpath("//*[@id='content']")).getText();
	     
	      //File DestFile= new File("D:\\destfile");
	      FileWriter myWriter= new FileWriter("destfile");
	      myWriter.write(output);
	      myWriter.close();
		return output;
	}
	  public static void main(String[] args) throws IOException{ 
	      Class2 test = new Class2(); 
	      String webData = test.extractDataWithSelenium
	        ("http://cogenglab.csd.uwo.ca/rushdi.htm"); 
	  }
}
