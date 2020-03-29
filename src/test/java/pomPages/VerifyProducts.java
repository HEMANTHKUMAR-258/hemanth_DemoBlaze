package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExplicitCode;

public class VerifyProducts {
	WebDriver dr;
	ExplicitCode ec;
	//constructor
public VerifyProducts(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
//xpath for verify products
By Cart=By.xpath("//ul[@class='navbar-nav ml-auto']//li[4]");
By Firstproduct=By.xpath("//tbody[@id='tbodyid']//tr[1]//td[2]");
By Secondproduct=By.xpath("//tbody[@id='tbodyid']//tr[2]//td[2]");
//pom methods for xpaths
public void clickcart() {
	 WebElement a=ec.clickable(Cart, 20);
	 a.click();
	 ec.Screenshot();
}
public String FP() {
	 WebElement a=ec.waitelement(Firstproduct, 20);
	 String s=a.getText();
	 return s;
}
public String SP() {
	 WebElement a=ec.waitelement(Secondproduct, 20);
	 String s=a.getText();
	 return s;
}
}
