package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExplicitCode;

public class logInPage {
	WebDriver dr;
	ExplicitCode ec;
public logInPage(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
By login=By.xpath("//a[@id='login2']");
By username=By.xpath("//input[@id='loginusername']");
By password=By.xpath("//input[@id='loginpassword']");
By logInBtn=By.xpath("//body[@class='modal-open']/div[3]/div[1]/div/div[3]/button[2]");
public void click_login()               //click the login 
{
	WebElement we_login=ec.clickable(login, 40);
	we_login.click();
}

public void set_loginusr(String lu)     //click the username & passing the sendkeys
{
	WebElement we_lu=ec.waitelement(username, 40);
	we_lu.sendKeys(lu);
}

public void set_loginpwd(String lp)     //click the password & passing the sendkeys
{
	WebElement we_pwd=ec.waitelement(password, 40);
	we_pwd.sendKeys(lp);
}

public void login_btn()                //click the loginbutton
{
	WebElement we_lbtn=ec.clickable(logInBtn, 40);
	we_lbtn.click();
}
public void LogIn(String username,String Password) { //passing arguments,calling all functions
	this.click_login();
	this.set_loginusr(username);
	this.set_loginpwd(Password);
	this.login_btn();
	ec.Screenshot();                                 //calling screenshot method
}
}
