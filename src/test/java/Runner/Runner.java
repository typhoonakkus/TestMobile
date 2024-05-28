package Runner;

import Base.Driver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		monochrome = true,
		features = "src/test/resources/Features",
		glue = {"stepDef","Hooks"},
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		plugin = {"pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)


public class Runner extends Driver{

}
