package WPPOOL.WPPOOL;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.Scanner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	
	WebDriver driver=null;
    @BeforeSuite
	public void start() {
    	System.out.println("Enter The Browser name chrome/Edge ");
    	
    	Scanner myObj = new Scanner(System.in);
    	String bname  = myObj.nextLine();
    	
    	
    	
		String browser=System.getProperty("browser", bname); //initialize the browser here
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup(); //chrome driver setup here
			
			driver=new ChromeDriver();
		}
		else if (browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();   //edge driver setup here
			driver=new EdgeDriver();
			
			
		}
	}
	@AfterSuite
  public void close() {    //method for driver close 
	  driver.close();
  }

}
