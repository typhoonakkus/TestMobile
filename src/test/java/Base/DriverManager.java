package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import Utility.Util;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	protected static AndroidDriver driver;
	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
			
	@BeforeTest
	public static void CreateDriver() throws MalformedURLException {
		System.out.println("Driver Yaratiliyor************");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.get(Util.properties("config", "Applink"));

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("automationName","UiAutomator2");
		dc.setCapability("platformName","Android");
		//dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("deviceName","51515151515");
		dc.setCapability("app","apk");

		URL remoteUrl = new URL ("http://127.0.0.1:4723");
		System.out.println("Start Driver !!!************");
		driver = new AndroidDriver(remoteUrl, dc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		webDriver.set(driver);
		//.implicitlyWait(Integer.parseInt((Util.properties("config", "ImplicitWait"))), TimeUnit.SECONDS);
		
	}

	@AfterTest
	public synchronized void afterSuite() {
		System.out.println("Driver kapaniyor************");
		webDriver.get().close();
		webDriver.get().quit();		
	}

}
