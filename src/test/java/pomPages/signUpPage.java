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
public signUpPage(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
By signup=By.xpath("//ul[@class='navbar-nav ml-auto']//li[8]//a");
By username=By.xpath("//input[@id='sign-username']");
By Password=By.xpath("//input[@id='sign-password']");
By signBtn=By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
public void sendKeysUsername(String q) {    //click the username & passing the sendkeys
	 WebElement a=ec.waitelement(username, 20);
	 a.sendKeys(q);
}
public void clicksignup() {                 //click the signup button
	 WebElement a=ec.clickable(signup, 20);
	 a.click();
}
public void sendKeyspassword(String q) {    //click the password & passing the sendkeys
	 WebElement a=ec.waitelement(Password, 20);
	 a.sendKeys(q);
}
public void clicksignbtn() {               //click the signupbutton
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
public void signUp(String username,String password) {  //passing arguments ,calling all functions
	this.clicksignup();
	this.sendKeysUsername(username);
	this.sendKeyspassword(password);
	this.clicksignbtn();
	ec.Screenshot();                                  //calling screenshot method
	this.alert();
}
}
