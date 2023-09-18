package WPPOOL.WPPOOL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.cdimascio.dotenv.Dotenv;

public class install extends BaseDriver {
	String url="http://localhost/wordpress/wp-login.php?";
	@Test
	public void wpinstall() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		
		driver.get(url);
		 Dotenv dotenv = Dotenv.load();
		 String Uname= dotenv.get("USER");
		 String Upass = dotenv.get("PASS");
         WebElement user =driver.findElement(By.id("user_login"));
		 
		 user.sendKeys(Uname);
		 WebElement pass =driver.findElement(By.id("user_pass"));
		 pass.sendKeys(Upass);
		 
		 
		 WebElement btn =driver.findElement(By.id("wp-submit"));
		 btn.click();
		 
		 WebElement plug=driver.findElement(By.xpath("//*[@id=\"menu-plugins\"]/a/div[3]"));
		 plug.click();
		 
		 WebElement addplug=driver.findElement(By.xpath("//*[@id=\"menu-plugins\"]/ul/li[3]/a"));
		 addplug.click();

		 WebElement searchplug=driver.findElement(By.id("search-plugins"));
		 searchplug.sendKeys("WP Dark Mode");
		 searchplug.submit();
		 Thread.sleep(1000);
		 
		 WebElement install =driver.findElement(By.xpath("//*[@id=\"the-list\"]/div[1]/div[1]/div[2]/ul/li[1]/a"));
		 install.click();
		 Thread.sleep(10000);	
//		 Alert alert=driver.switchTo().alert();
//		 alert.accept();
		 System.out.println("plugin install successfully");
		 
		
	}
	

}
