package infraWeb.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infraWeb.objectRepositories.PageElements;

public class Button extends MyWebElement {

	public Button(WebDriver driver, PageElements elementData, By elementBy) {
		super(driver, elementData, elementBy);
	}
	
	
}
