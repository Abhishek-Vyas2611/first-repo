package com.testing;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Testing3 {
	SoftAssert softAssert = new SoftAssert();
	@Test(priority=1)
  public void homeTest() {
	  System.out.println("I am in home test");
	  System.out.println("Before assertion");
	  Assert.assertTrue(4>3, "Verifing Element");
	  System.out.println("After Assertion");
	  Assert.assertEquals("abc", "abc");
  }
@Test (priority=2, dependsOnMethods="homeTest", groups= {"smoke"})
  public void maintest() {
	  System.out.println("I am in main test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(3>2, "Verifing Element");
	  System.out.println("After Assertion");
	  softAssert.assertAll();  //similar to error collector in Junit
}

@Test (priority=3, dependsOnMethods="maintest", groups = {"smoke","sanity"})
public void endtest() {
	  System.out.println("I am in end test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(33>3, "Verifing Element");
	  System.out.println("After Assertion");
	  softAssert.assertAll();
	  Assert.assertEquals("abc", "abc");
	  System.out.println("after second assertion");
	  softAssert.assertAll();

}  
}
  



