package infra.GenericsSolution.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infra.GenericsSolution.pageObjects.NavigationAction;


public class Button extends MyWebElement {

	public Button(WebDriver driver, String elementName, By elementBy, NavigationAction afterAction) {
		super(driver, elementName, elementBy, afterAction);
	}
	
	public Button(WebDriver driver, String elementName, By elementBy) {
		super(driver, elementName, elementBy);
	}
}
