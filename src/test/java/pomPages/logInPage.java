package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExplicitCode;

public class logInPage {
	WebDriver dr;
	ExplicitCode ec;
	//constructor
public logInPage(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
//xpaths for log in page
By login=By.xpath("//a[@id='login2']");
By username=By.xpath("//input[@id='loginusername']");
By password=By.xpath("//input[@id='loginpassword']");
By logInBtn=By.xpath("//body[@class='modal-open']/div[3]/div[1]/div/div[3]/button[2]");
By verify=By.xpath("//ul[@class='navbar-nav ml-auto']//li[7]//a");
//pom methods for xpaths
public void click_login()
{
	WebElement we_login=ec.clickable(login, 40);
	we_login.click();
}

public void set_loginusr(String lu)
{
	WebElement we_lu=ec.waitelement(username, 40);
	we_lu.sendKeys(lu);
}

public void set_loginpwd(String lp)
{
	WebElement we_pwd=ec.waitelement(password, 40);
	we_pwd.sendKeys(lp);
}

public void login_btn()
{
	WebElement we_lbtn=ec.clickable(logInBtn, 40);
	we_lbtn.click();
}
public String verifyLogIn() {
	WebElement we_vli=ec.waitelement(verify, 40);
String s=we_vli.getText();
return s;
}
//method for login
public void LogIn(String username,String Password) {
	this.click_login();
	this.set_loginusr(username);
	this.set_loginpwd(Password);
	this.login_btn();
	ec.Screenshot();
}
}
