package org.test.myown.b2btest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ASKHomePage{
	WebDriver driver;
	private ASKWebDriver askWebDriver;
	public  ASKHomePage(){
		askWebDriver= new ASKWebDriver();
	}
	public void homePage(){
		try {
			String[] brw={askWebDriver.props.getProperty("BROWSER"),"firefox"};
			driver = askWebDriver.invokeBrowserAndURL(brw,askWebDriver.props.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.name("q")).sendKeys("java");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void resultNewPage(){
		System.out.println("Result News Page");
		driver.findElement(By.xpath("//div[@id='hdtb-msb-vis']/div[2]/a")).click();

	}
	
	public void resultMapPage(){
		System.out.println("Result Map Page");
		driver.findElement(By.xpath("//div[@id='hdtb-msb-vis']/div[3]/a")).click();

	}
	public void toClose() throws InterruptedException{
		Thread.sleep(10000);
		askWebDriver.quitWebDriver();
	}
	
//	public static void main(String ag[]) throws InterruptedException{
//		ASKHomePage pg = new ASKHomePage();
//		pg.homePage();
//		pg.toClose();
//	}
}
