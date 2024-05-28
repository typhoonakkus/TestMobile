package stepDef;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.Driver;
import Base.DriverManager;
import Utility.Assertion;
import Utility.Find;
import Utility.Find.FTimeOut;
import Utility.Find.Locator;
import Utility.Util;
import Utility.Util.TimeOut;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login extends DriverManager {


    @Given("validate login page and click login")
    public void validate_login_page_and_click_login() {
        MobileElement loginBtn = Find.Element(Locator.id, "Top_Login", FTimeOut.MIDDLE);
        Assertion.ElementExist(loginBtn);
        Util.clickFunction(loginBtn, TimeOut.LOW);
    }

	@When("write username {string}")
    public void write_username(String user) {
		MobileElement usrname = Find.Element(Locator.id, "txtLogInEM1", FTimeOut.MIDDLE);
		Util.sendKeysFunction(usrname, user, TimeOut.HIGH);
    }
    @And("write password {string}")
    public void write_password(String password)  {
        MobileElement pword = Find.Element( Locator.id, "txtLogInPW1", FTimeOut.MIDDLE);
		Util.sendKeysFunction(pword, password, TimeOut.LOW);
    }
    @And("clicks on login btn")
    public void clicks_on_login_btn() {
        MobileElement loginBtn = Find.Element( Locator.id, "LogIn", FTimeOut.MIDDLE);
		Util.clickFunction(loginBtn, TimeOut.LOW);
    }
    @Then("user is navigate to the home page")
    public void user_is_navigate_to_the_home_page() {
        MobileElement assertElement = Find.Element(Locator.linkText, "Profil", FTimeOut.MIDDLE);
        Assertion.ElementExist(assertElement);
    }

}
