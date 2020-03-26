package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Excel_Utilities.getexcel;

public class ExplicitCode extends getexcel{
	protected static WebDriver dr;
	  static int counter=1;
//	  Logger log;
//public ExplicitCode(WebDriver dr) {
//	this.dr=dr;
////	log= Logger.getLogger("devpinoyLogger");
//}
//public void logger1(String msg) {
//	log.debug(msg);
//}
public WebElement waitelement(By Locator,int timeout) {
	WebElement e=null;
	try {
	WebDriverWait wait= new WebDriverWait(dr,timeout);
	 e=wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	System.out.println("element located");

	}catch(Exception e1){
//		this.logger1("Exception in waitelement");
	  System.out.println("element not found"+e1);	
	}
return e;	
}
public WebElement clickable(By Locator, int timeout) {
	WebElement e=null;
	try {
		WebDriverWait wait = new WebDriverWait(dr,timeout);
		e= wait.until(ExpectedConditions.elementToBeClickable(Locator));
		System.out.println("element located");
		return e;
		}catch(Exception e1){
//			this.logger1("Exception in the clickable");
		  System.out.println("element not found"+e1);	
		}
	return null;
}
public void Screenshot() {
	String path="src\\test\\resources\\testdata\\Screenshots";
	String filename=counter+".png";
	File f1=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	File f2= new File(path+filename);
	try {
		FileUtils.copyFile(f1, f2);
	} catch (IOException e) {
		// TODO Auto-generated catch block
//		this.logger1("IOException in the screenshot");
		System.out.println(counter +"failed");
		e.printStackTrace();
	}
	counter ++;
}
public static WebDriver launchbrowser(String browser) {
String s="src\\test\\resources\\drivers\\chromedriver_v79.exe";
if(browser.contains("chrome")) {
	System.setProperty("webdriver.chrome.driver", "chromedriver_v79.exe");
	dr= new ChromeDriver();
}else if(browser.contains("firefox")) {
	System.setProperty("webdriver.gecko.driver","geckodriver_v75.exe");
    dr=new FirefoxDriver();
}
dr.get("https://demoblaze.com/");
dr.manage().window().maximize();
dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

return dr;	
}
}

