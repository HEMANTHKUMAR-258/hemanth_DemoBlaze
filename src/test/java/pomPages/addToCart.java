package pomPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExplicitCode;

public class addToCart {
	WebDriver dr;
	ExplicitCode ec;
	//constructor
public addToCart(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
//xpath for add to cart
By Productclick =By.xpath("//div[@class='col-lg-9']//div//div[1]//h4//a");
By ClickAdd=By.xpath("//a[@class='btn btn-success btn-lg']");
By HomeClick=By.xpath("//ul[@class='navbar-nav ml-auto']//li[1]");
By ProductTwo=By.xpath("//div[@class='col-lg-9']//div//div[2]//h4//a");
//pom methods for xpath
public void clickProduct() {
	WebElement we= ec.clickable(Productclick, 20);
	we.click();
}
public void clickadd() {
	WebElement we= ec.clickable(ClickAdd, 20);
	we.click();
}
public void clickhome() {
	WebElement we= ec.clickable(HomeClick, 20);
	we.click();
}
public void producttwo() {
	WebElement we= ec.clickable(ProductTwo, 20);
	we.click();
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
//method for addtocart
public void AddtoCart() {
	this.clickProduct();
	this.clickadd();
	ec.Screenshot();
	this.alert();
	this.clickhome();
	this.producttwo();
	ec.Screenshot();
	this.clickadd();
	this.alert();
	this.clickhome();
}
}
