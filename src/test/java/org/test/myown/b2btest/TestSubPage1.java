package org.test.myown.b2btest;

import org.testng.annotations.Test;

public class TestSubPage1 {
	
	@Test(groups={"regressiontest"})
	public void subpageMethod1(){
		System.out.println("subpagemethod1");
	}
	@Test(groups={"regressiontest"})
	public void subpageMethod2(){
		System.out.println("subpagemethod2");
	}
	@Test(groups={"smoketest"})
	public void subpageMethod3(){
		System.out.println("smoketest  ******* subpagemethod3");
	}
	
}
