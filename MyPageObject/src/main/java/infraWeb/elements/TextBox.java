package infraWeb.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infraWeb.objectRepositories.PageElements;

public class TextBox extends MyWebElement {

	public TextBox(WebDriver driver, PageElements elementData, By elementBy, Runnable afterAction) {
		super(driver, elementData, elementBy, afterAction);
	}

	public TextBox(WebDriver driver, PageElements elementData, By elementBy) {
		super(driver, elementData, elementBy);
	}
	

}
