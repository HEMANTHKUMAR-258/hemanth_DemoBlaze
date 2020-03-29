package pomPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExplicitCode;

public class signUpPage {
	WebDriver dr;
	ExplicitCode ec;
	
	//constructor
public signUpPage(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
//xpaths for signup
By signup=By.xpath("//ul[@class='navbar-nav ml-auto']//li[8]//a");
By username=By.xpath("//input[@id='sign-username']");
By Password=By.xpath("//input[@id='sign-password']");
By signBtn=By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
//pom methods for xpath
public void sendKeysUsername(String q) {
	 WebElement a=ec.waitelement(username, 20);
	 a.sendKeys(q);
}
public void clicksignup() {
	 WebElement a=ec.clickable(signup, 20);
	 a.click();
}
public void sendKeyspassword(String q) {
	 WebElement a=ec.waitelement(Password, 20);
	 a.sendKeys(q);
}
public void clicksignbtn() {
	 WebElement a=ec.clickable(signBtn, 20);
	 a.click();
}
public void alert() 
{
	try {
  WebDriverWait  wait=new WebDriverWait(dr,20);
  wait.until(ExpectedConditions.alertIsPresent());
 
 Alert alt=dr.switchTo().alert();
  alt.accept();
	}catch(Exception e) {
		System.out.println("not clicked");
	}
	 }
//method for signup
public void signUp(String username,String password) {
	this.clicksignup();
	this.sendKeysUsername(username);
	this.sendKeyspassword(password);
	this.clicksignbtn();
	ec.Screenshot();
	this.alert();
}
}
