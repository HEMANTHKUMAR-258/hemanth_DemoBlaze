package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExplicitCode;

public class LaptopVerification {
	WebDriver dr;
	ExplicitCode ec;
	//constructor
public LaptopVerification(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
//xpath for laptop verification
By laptops=By.xpath("//div[@class='list-group']//a[3]");
By verify=By.xpath("//*[@id=\"article\"]");
//pom methods for xpath
public void ClickLaptop()
{
	WebElement we_lbtn=ec.clickable(laptops, 40);
	we_lbtn.click();
}
public String verifylaptops() {
	WebElement we_vli=ec.waitelement(verify, 40);
String s=we_vli.getText();
return s;
}
}
