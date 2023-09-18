package WPPOOL.WPPOOL;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.cdimascio.dotenv.Dotenv;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WpDarkMode extends BaseDriver{
	String url="http://localhost/wordpress/wp-login.php?";
	
	@Test
	
	public void automation() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(1000);
		 Dotenv dotenv = Dotenv.load();
		 String Uname= dotenv.get("USER");
		 String Upass = dotenv.get("PASS");   // word press credentials from 
		 
		
		 WebElement user =driver.findElement(By.id("user_login"));
		 
		 user.sendKeys(Uname);
		 WebElement pass =driver.findElement(By.id("user_pass"));
		 pass.sendKeys(Upass);
		 WebElement btn =driver.findElement(By.id("wp-submit"));
		 btn.click();
		 
		 
		 
		 
		// login in wordpress workspace 
		 
		 WebElement plug=driver.findElement(By.xpath("//*[@id=\"menu-plugins\"]/a/div[3]"));
		 plug.click();
		 WebElement addplug=driver.findElement(By.xpath("//*[@id=\"menu-plugins\"]/ul/li[3]/a"));
		 addplug.click();
		 Thread.sleep(2000);
//		 
		 
		 WebElement searchplug=driver.findElement(By.id("search-plugins"));
		 searchplug.sendKeys("WP Dark Mode");
		 searchplug.submit();
		 Thread.sleep(1000);
	 
		 WebElement activate =driver.findElement(By.xpath("//*[@id=\"the-list\"]/div[1]/div[1]/div[2]/ul/li[1]/a"));
		 activate.click();
		 Thread.sleep(10000);	

		 
		 WebElement BackndDrkmode=driver.findElement(By.xpath("//*[@id=\"wp_dark_mode_general\"]/form/table/tbody/tr[2]/td/fieldset/label/p"));
		 if(BackndDrkmode.isEnabled()) {
			 System.out.println("Button is enable");
			 
		 }else {
			 
			 BackndDrkmode.click();
			 Thread.sleep(1000);
			 
			 
		 }
		 
		 WebElement savebgdark = driver.findElement(By.id("save_settings"));  // for save Enable backend darkmode
		 savebgdark.click();
		
		 
		 WebElement NDashboard = driver.findElement(By.xpath("//*[@id=\"menu-dashboard\"]/a/div[3]"));
		 NDashboard.click();
		 Thread.sleep(1000);
		 driver.navigate().back();
		 	 
		 WebElement switchstng = driver.findElement(By.id("wp_dark_mode_switch-tab"));
		 switchstng.click();
		 Thread.sleep(1000);
		
		 
		 WebElement sw = driver.findElement(By.xpath("//*[@id=\"wp_dark_mode_switch\"]/form/table/tbody/tr[2]/td/fieldset/label[2]/img"));
		 sw.click();
		 Thread.sleep(1000);
		 
		 WebElement custompos =driver.findElement(By.name("wp_dark_mode_switch[switcher_position]"));
		 
		 Select select =new Select(custompos);
		 select.selectByValue("left_bottom");
		 Thread.sleep(1000);
		 WebElement saveswitch =driver.findElement(By.name("save_settings"));
		 saveswitch.click();
		 
		 Thread.sleep(1000);
		 
//		save_settings
		 
		 
	
		 
		 
		
		 
		 
		 
//		 
		
		 
//		 
//		 WebElement agplug=driver.findElement(By.xpath("//*[@id=\"menu-plugins\"]/ul/li[2]/a"));
//		 agplug.click();
//		 Thread.sleep(2000);
//		 
//		 WebElement activate=driver.findElement(By.className("edit"));
//		 activate.click();
//		 Thread.sleep(1000);
		 
		
		 
		
		 
		 
		
		 
		
		 

		 
		 
		
		
		 
		 
		 
		
		
		
	}
	

}
