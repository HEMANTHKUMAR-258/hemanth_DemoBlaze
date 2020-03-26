package TestNg;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExplicitCode;
import pomPages.VerifyProducts;
import pomPages.addToCart;
import pomPages.logInPage;
import pomPages.signUpPage;


public class TestNgForFirefox extends ExplicitCode{
	WebDriver dr;
	logInPage lp;
	addToCart ac;
	signUpPage sp;
	VerifyProducts vp;
	@BeforeMethod
	public void LB() {
		launchbrowser("chrome");
	}
	@BeforeClass
	public void GE() {
		getExcel("Sheet1");
	}
	@Test(priority=0,dataProvider="register")
	  public void f(String s,String p1) {
		 sp=new signUpPage(dr);
		 sp.signUp(s,p1);
		 lp=new logInPage(dr);
			lp.LogIn(s, p1);
			
	  }
	@Test(priority=1)
	public void add(){
		ac=new addToCart(dr);
		ac.AddtoCart();
		vp=new VerifyProducts(dr);
		vp.clickcart();
		String r=vp.FP();
		String r1=vp.SP();
		Assert.assertTrue(r.contains("Samsung"));
		Assert.assertTrue(r1.contains("Nokia"));
	}
	
	 @DataProvider(name="register")
	  public String[][] register(){
		   return testdata;
	  }
}
