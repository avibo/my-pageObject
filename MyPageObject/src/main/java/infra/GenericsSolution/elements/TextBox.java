package infra.GenericsSolution.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infra.GenericsSolution.objectRepositories.PageElements;
import infra.GenericsSolution.pageObjects.NavigationAction;


public class TextBox extends MyWebElement {

	public TextBox(WebDriver driver, PageElements elementData, By elementBy, NavigationAction afterAction) {
		super(driver, elementData, elementBy, afterAction);
	}

	public TextBox(WebDriver driver, PageElements elementData, By elementBy) {
		super(driver, elementData, elementBy);
	}
	

}
