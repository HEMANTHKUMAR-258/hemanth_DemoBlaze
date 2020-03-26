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
public addToCart(WebDriver dr) {
	this.dr=dr;
	ec= new ExplicitCode();
	
}
By Productclick =By.xpath("//div[@class='col-lg-9']//div//div[1]//h4//a");
By ClickAdd=By.xpath("//a[@class='btn btn-success btn-lg']");
By HomeClick=By.xpath("//ul[@class='navbar-nav ml-auto']//li[1]");
By ProductTwo=By.xpath("//div[@class='col-lg-9']//div//div[2]//h4//a");
public void clickProduct() {                    //click the product
	WebElement we= ec.clickable(Productclick, 20);
	we.click();
}
public void clickadd() {                 //adding the product
	WebElement we= ec.clickable(ClickAdd, 20);
	we.click();
}
public void clickhome() {               //click the Home  
	WebElement we= ec.clickable(HomeClick, 20);
	we.click();
}
public void producttwo() {             //click the second product  
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
public void AddtoCart() {   //calling all functions
	this.clickProduct();
	this.clickadd();
	ec.Screenshot();        //calling the screenshot method
	this.alert();
	this.clickhome();
	this.producttwo();
	ec.Screenshot();
	this.clickadd();       //calling the screenshot method  
	this.alert();
	this.clickhome();
}
}
