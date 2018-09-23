package org.test.myown.b2btest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestHomePage {
	ASKHomePage ahp = null;
	
	@BeforeClass
	public void testBeginTests(){
		System.out.println("Begin tests......step1");
		ahp = new ASKHomePage();
	}
	@Test(groups={"regressiontest"}, priority=1)
	public int testHomePage(){
		System.out.println("HOme page started--regressiontest");
		ahp.homePage();
		return 100;
	 	
	}
	
	@Test(groups={"regressiontest"}, priority=2)
	public void testNewsLink(){
		System.out.println("HOme page testNewsLink");
	//	ahp.resultNewPage();
	}
	
	@Test(groups={"smoketest"}, priority=3)
	public void testMapLink(){
		System.out.println("smoketest****** testMapLink");
	//	ahp.resultMapPage();
	}
	@Test(groups={"smoketest"}, priority=4)
	public void testMethod(){
		System.out.println("smoketest ******** page testMethod");
		//ahp.resultMapPage();
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException{
		System.out.println("HOme page closeBrowser");
		//ahp.toClose();
	}
}
