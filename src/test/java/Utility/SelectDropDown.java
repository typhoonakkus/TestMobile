package Utility;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.DriverManager;

public class SelectDropDown extends DriverManager {
	
	WebElement element = null ; 
	
	public static void selectFromChombobox(WebElement element , String text) {
		
	
		Select dropDown= new Select(element);
		dropDown.deselectByVisibleText(text);
	}

	public static void selectFromDropDown(WebElement element , String text) {


		Select dropDown= new Select(element);
		dropDown.deselectByVisibleText(text);
	}
}
