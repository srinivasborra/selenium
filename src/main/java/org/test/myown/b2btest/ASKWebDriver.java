package org.test.myown.b2btest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriverService;


public class ASKWebDriver {
	private WebDriver driver;
	public static Properties props;
	private static ChromeDriverService chromeService;
	private static GeckoDriverService fireFoxService;
	private static SafariDriverService safariService;
	static {
        loadProperties();
    }
	public WebDriver invokeBrowserAndURL(String[] browser, String url) throws Exception {
		String[] brw = {"chrome","firefox"};
		if(brw[0].equals("chrome")){
			chromeService = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(props.getProperty("CHROMEPATH"))).usingAnyFreePort().build();
			chromeService.start();
			DesiredCapabilities ch=DesiredCapabilities.chrome();
			ch.acceptInsecureCerts();
			ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new RemoteWebDriver(chromeService.getUrl(), ch);
			
			driver.get(url);
		}
		if(brw[1].equals("firefox")){
			fireFoxService = new GeckoDriverService.Builder()
					.usingDriverExecutable(new File(props.getProperty("GECOPATH"))).usingAnyFreePort()
					.build();
			fireFoxService.start();
			driver = new RemoteWebDriver(fireFoxService.getUrl(), DesiredCapabilities.firefox());
			driver.get(url);
		}
//		String brw = browser.toLowerCase();
//		switch (brw) {
//		case "chrome":
//			chromeService = new ChromeDriverService.Builder()
//					.usingDriverExecutable(new File(props.getProperty("CHROMEPATH"))).usingAnyFreePort().build();
//			
//			chromeService.start();
//			DesiredCapabilities ch=DesiredCapabilities.chrome();
//			ch.acceptInsecureCerts();
//			ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//			ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			driver = new RemoteWebDriver(chromeService.getUrl(), ch);
//			
//			driver.get(url);
//			break;
//		case "firefox":
//			fireFoxService = new GeckoDriverService.Builder()
//					.usingDriverExecutable(new File(props.getProperty("GECOPATH"))).usingAnyFreePort()
//					.build();
//			fireFoxService.start();
//			driver = new RemoteWebDriver(fireFoxService.getUrl(), DesiredCapabilities.firefox());
//			driver.get(url);
//			break;
//		case "safari":
//			safariService= new SafariDriverService.Builder().usingDriverExecutable(new File(props.getProperty("SAFARIPATH"))).usingAnyFreePort().build();
//			safariService.start();
//			driver = new RemoteWebDriver(safariService.getUrl(), DesiredCapabilities.safari());
//			driver.get(url);
//			break;
//		default:
//			System.out.println("Please initiate Browser");
//		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
public synchronized static Properties loadProperties(){
	props = new Properties();
	FileInputStream fis = null;
	try {
		String path = new File(".").getCanonicalPath();
		 fis = new FileInputStream(path+"/target/classes/utils/application.properties");
		props.load(fis);
		//browser = props.getProperty("BROWSER");
		return props;
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
			try{
				if(fis != null){
					fis.close();
				}
			}catch(Exception e){
				
			}
	}
	return props;
}
	public void closeWebDriver() {
		if (driver != null)
			driver.close();
	}

	public void quitWebDriver() {
		if (driver != null)
			driver.quit();
	}
}
