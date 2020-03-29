package TestNg;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExplicitCode;
import pomPages.LaptopVerification;
import pomPages.VerifyProducts;
import pomPages.addToCart;
import pomPages.logInPage;
import pomPages.signUpPage;


public class TestNgForChrome extends ExplicitCode{//here we extends explicit code for acquiring properties  and variables of explicit code
	WebDriver dr;
	logInPage lp;
	addToCart ac;
	signUpPage sp;
	VerifyProducts vp;
	LaptopVerification lv;
	@BeforeMethod
	public void LB() {
		launchbrowser("chrome");
	}
	@BeforeClass
	public void GE() {
		getExcel("Sheet1");
	}
	@Test(priority=0,dataProvider="register")
	  public void signUp(String username,String password) {
		 sp=new signUpPage(dr);//object creation
		 sp.signUp(username,password);//calling signup method using object
		
			
	  }
	@Test(priority=1,dataProvider="register")
	  public void logIn(String username,String password) {
	
		 lp=new logInPage(dr);//object creation
			lp.LogIn(username, password);//calling login method using object
			String r=lp.verifyLogIn();
		Assert.assertTrue(r.contains(username));//verifying the successful login
	  }
	@Test(priority=2)
	public void add(){
		ac=new addToCart(dr);//object creation
		ac.AddtoCart();//calling addtocart method by using object
		vp=new VerifyProducts(dr);//object creation
		vp.clickcart();//calling verify products by using method
		String r=vp.FP();
		String r1=vp.SP();
		Assert.assertTrue(r.contains("Samsung"));//verifying the product
		Assert.assertTrue(r1.contains("Nokia"));//verifying the product
	}
	@Test(priority=3)
	public void LaptopVerify() {
		lv=new LaptopVerification(dr);//object creation
		lv.ClickLaptop();//calling laptop verification by using object
		String s=lv.verifylaptops();
		Assert.assertTrue(s.contains("Laptop"));//verifying the laptop
	}
	
	
	 @DataProvider(name="register")
	  public String[][] register(){
		   return testdata;
	  }
	 
}
