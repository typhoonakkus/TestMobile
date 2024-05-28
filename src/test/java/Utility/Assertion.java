package Utility;

import Base.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.ByteArrayInputStream;

public class Assertion extends DriverManager {

    public enum ATimeOut{

        LOW(15),
        MIDDLE(30),
        HIGH(45),
        CUSTOM_MAX(60);

        private final int value;

        public int getValue() {
            return value;
        }

        private ATimeOut(int value){

            this.value = value;
        }
    }

    public static void TextExactMatch(WebElement element , String expectedText) {
        try {
            System.out.println("****************START ASSERT TEXT EXACTMATCH:" + element);
            Reporter.log("Starting Text Includes Assertion.**********");
            Assert.assertEquals(element.getText(), expectedText, "Assert error !!!!!Text of the element do not match****" + element);
            Allure.addAttachment("TextIncludesAssertScreen", new ByteArrayInputStream(Util.takeScreenShot()));
            System.out.println("****************TEXT EXACTMATCH SUCESS:" + element+ "///" + element.getText()+ "///"+ expectedText);
        }catch (Exception e){
            System.out.println("Something went wrong while Assertion !!!! ********* " +e);
        }
    }

    public static void TextIncludes(WebElement element , String expectedText) {

        Reporter.log("Starting Text Includes Assertion.**********");
        System.out.println("****************ELEMENT_TEXT:"+element.getText());
        Assert.assertSame(element.getText(), expectedText, "Assert error !!!!!Text of the element do not match****"+element);
        Allure.addAttachment("TextIncludesAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
        System.out.println("****************TEXT INCLUDES SUCCESS:" + element+ "///" + element.getText()+ "///"+ expectedText);
    }

    public static void ElementExist(WebElement element) {

        Reporter.log("Starting Eelement Exist Assertion.**********");
        Assert.assertNotNull(element,"Assert error !!!!!  Element not exist********");
        Allure.addAttachment("ElementExistAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
        System.out.println("****************ELEMENT EXIST:" + element);
    }

    public static void notElementExist(WebElement element) {

        System.out.println("**********Start element not exist assertion" + element);
        Reporter.log("Starting Eelement Exist Assertion.**********");
        Assert.assertNull(element,"Assert error !!!!!  Element exist********");
        Allure.addAttachment("ElementExistAssertScreen",new ByteArrayInputStream(Util.takeScreenShot()));
    }

 }
