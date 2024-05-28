package Hooks;


import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.sql.Timestamp;

import io.cucumber.plugin.event.TestStep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.DriverManager;
import Utility.Util;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class hook extends DriverManager{
	
	Date date = new Date(0);
	  Timestamp lDate = new Timestamp(date.getTime());

	public interface PickleStepTestStep
			extends TestStep{
		String getStepText();
	}
/*
	@AfterStep
	public void afterStep(Scenario scenario) {



		System.out.println("After Step Screenshot*****************");
		//scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName().replaceAll(" ","_")+lDate);
		Allure.addAttachment(scenario.getName().replaceAll(" ","_")+lDate, "image/png", new ByteArrayInputStream(((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES)),"png");
		
	}*/
	


	/*@After
	public void afterScenario(Scenario scenario) {
		System.out.println("After Scenario Screenshot*****************");
		//scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName().replaceAll(" ","_")+lDate); 
		Allure.addAttachment(scenario.getName().replaceAll(" ","_")+lDate, "image/png", new ByteArrayInputStream(((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES)),"png");
	}*/

	@After
	public void failScenario(Scenario scenario) {

		if(scenario.isFailed()){
		System.out.println("Fail Scenario Screenshot*****************");
		//scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName().replaceAll(" ","_")+lDate);
		Allure.addAttachment(scenario.getName().replaceAll(" ","_")+lDate, "image/png", new ByteArrayInputStream(((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES)),"png");
		}
	}

	}
