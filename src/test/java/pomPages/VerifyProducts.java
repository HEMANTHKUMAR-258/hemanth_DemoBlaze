package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExplicitCode;

public class VerifyProducts {
	WebDriver dr;
	ExplicitCode ec;
public VerifyProducts(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
By Cart=By.xpath("//ul[@class='navbar-nav ml-auto']//li[4]");
By Firstproduct=By.xpath("//tbody[@id='tbodyid']//tr[1]//td[2]");
By Secondproduct=By.xpath("//tbody[@id='tbodyid']//tr[2]//td[2]");
public void clickcart() {              //click the cart
	 WebElement a=ec.clickable(Cart, 20);
	 a.click();
	 ec.Screenshot();
}
public String FP() {                   //getting text from first product
	 WebElement a=ec.waitelement(Firstproduct, 20);
	 String s=a.getText();
	 return s;
}
public String SP() {                 //getting text from second product
	 WebElement a=ec.waitelement(Secondproduct, 20);
	 String s=a.getText();
	 return s;
}
}
