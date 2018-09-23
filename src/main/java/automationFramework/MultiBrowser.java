package automationFramework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
	public WebDriver driver;
	private static ChromeDriverService chromeService;
	private static GeckoDriverService fireFoxService;
	  @Parameters("browser")

	  @BeforeClass

	  // Passing Browser parameter from TestNG xml

	  public void beforeTest(String browser) throws IOException {

	  // If the browser is Firefox, then do this

	  if(browser.equalsIgnoreCase("firefox")) {

		  fireFoxService = new GeckoDriverService.Builder()
					.usingDriverExecutable(new File("/Users/nagaborra/Downloads/gecko/geckodriver")).usingAnyFreePort().build();
			try {
				fireFoxService.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver = new RemoteWebDriver(fireFoxService.getUrl(), DesiredCapabilities.firefox());
			//driver.get(url);
			
		//  driver = new FirefoxDriver();

	  // If browser is IE, then do this	  

	  }
      if (browser.equalsIgnoreCase("ie")) { 

		  // Here I am setting up the path for my IEDriver

		  chromeService = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("/usr/local/bin/chromedriver")).usingAnyFreePort().build();
			chromeService.start();
			DesiredCapabilities ch=DesiredCapabilities.chrome();
			ch.acceptInsecureCerts();
			ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new RemoteWebDriver(chromeService.getUrl(), ch);

		 // driver = new InternetExplorerDriver();

	  } 

	  // Doesn't the browser type, lauch the Website

	  driver.get("http://www.store.demoqa.com"); 

	  }

	  // Once Before method is completed, Test method will start

	  @Test 
	  public void login() throws InterruptedException {

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

	    driver.findElement(By.id("log")).sendKeys("testuser_1");

	    driver.findElement(By.id("pwd")).sendKeys("Test@123");

	    driver.findElement(By.id("login")).click();

		}  

	  @AfterClass 
	  public void afterTest() {

			driver.quit();

		}
}
