package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;



public class Util extends DriverManager {
	
	public enum TimeOut {

	    LOW(5),

	    MIDDLE(10),

	    HIGH(15),

	    CUSTOM_MAX(60);

	    private final int value;

	  public int getValue() {

	        return value;

	    }
	    // enum constructor - cannot be public or protected

	    private TimeOut(int value) {

	        this.value = value;

	    }
	}

	
	   public static void clickFunction(MobileElement clickElement , TimeOut timeOut){
		   try {
		   System.out.println("Start click element !!! ********* ");
		   	WebDriverWait wait = new WebDriverWait(webDriver.get(), timeOut.value);
	        wait.until(ExpectedConditions.elementToBeClickable(clickElement));

	        clickElement.click();
	        System.out.println("Element is clicked succesfuly !!! *********"+clickElement);
			   Allure.addAttachment("Click is Success","Succes"+clickElement);
		   } catch(Exception e) {
			   System.out.println("Element is not clicked succesfuly !!! ********* " +e);
			   Allure.addAttachment("Click is Failed","Failed");
		   }
	    }

	    public static void sendKeysFunction(MobileElement sendKeysElement, String value, TimeOut timeOut){
	    	try {
	    	System.out.println("Start sendKeys Text !!! ********* ");
	    	WebDriverWait wait = new WebDriverWait(webDriver.get(), timeOut.value);
	        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
			sendKeysElement.clear();
	        sendKeysElement.sendKeys(value);
	        System.out.println("Text is sendKeys succesfuly !!! ********* "+sendKeysElement);
				Allure.addAttachment("SendKeys is Success","Succes"+sendKeysElement);
	    	}catch(Exception e){
	    		System.out.println("Text is not sendKeys !!! ********* " +e);
				Allure.addAttachment("SendKeys is Failed","Failed");
	    	}
	    }
		public static void waitUntilElementInvisible(WebElement invisibleElement , TimeOut timeOut) {

		try {

			System.out.println("Start wait element to be invisible!!! ************");
			WebDriverWait wait = new WebDriverWait(webDriver.get(), timeOut.value);
			wait.until(ExpectedConditions.invisibilityOf(invisibleElement));
			System.out.println("Element invisible now!!! **************** INVISIBLE_ELEMENT:" + invisibleElement);


		}catch (Exception e) {

			System.out.println("Element is not invisible!!! ************");
			Allure.addAttachment("Invisibility is Failed", "Failed");
			}

	}

	public void scrollUntilElementVisible(WebElement element) throws InterruptedException  {

		((JavascriptExecutor) webDriver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}
	public void moveToElement(WebElement element) {

		Actions actions = new Actions(webDriver.get());
		actions.moveToElement(element);
		actions.perform();
		System.out.println("Move to element !!! **************");
	}

	public void fileUpload(String filePath) {

		try {
			System.out.println("Start File Upload !!! **************");
			File uploadFile = new File(filePath);

			WebElement fileInput = webDriver.get().findElement(By.cssSelector("input[type=file]"));
			fileInput.sendKeys(uploadFile.getAbsolutePath());
			System.out.println("File Upload Successfully!!! **************" + fileInput + "///" + filePath);
			Allure.addAttachment("File upload is successful", "Success" + fileInput + "///" + filePath);
		} catch ( Exception e) {

			System.out.println("File upload is not successfully!!! *************" + e);
			Allure.addAttachment("File upload is Failed", "Failed");
		}
	}

	static FileReader reader;
	static Properties p;

	public static byte[] takeScreenShot() {
		return ((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES);
	}

	public static String properties(String fileName, String value) {
		String propValue = null;
		try {
			reader = new FileReader("AppConfig" + "//" + fileName + ".properties");
			p = new Properties();
			p.load(reader);
			propValue = p.getProperty(value);
		} catch (FileNotFoundException e) {
			new RuntimeException("File is not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			new RuntimeException("IO exception occured");
		}
		return propValue;
	}
		

	public static String getURL() {
		return webDriver.get().getCurrentUrl();
	}
}
