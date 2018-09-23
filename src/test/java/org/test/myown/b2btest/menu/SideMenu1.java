package org.test.myown.b2btest.menu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners()
@Test(groups={"functionaltest"})
public class SideMenu1 {
	@Parameters({"first_name"})
	@Test(groups={"regressiontest"})
	public void sideMenuMethod1(String fname){
		System.out.println("sideMenuMethod1 _______ "+fname);
	}
	@Parameters({"first_name"})
	@Test(groups={"regressiontest"})
	public void sideMenuMethod2(String firstname){
		System.out.println("sideMenuMethod2  "+firstname);
	}
	
	@Test(groups={"regressiontest"},dataProvider="test1")
	public void sideMenuMethod3(String n1, int n2){
		System.out.println("sideMenuMethod3333333333333"+"    "+n1 +"  "+n2);
	}
	@Test(groups={"smoketest"})
	public void sideMenuMethod4(){
		System.out.println("sideMenuMethod44444" );
	}
	@DataProvider(name="test1")
	public Object[][] createData(){
		return new Object[][]{
			{"testuser1", new Integer(123)},
			{"testuser2", new Integer(234)}
		};
	}
}
