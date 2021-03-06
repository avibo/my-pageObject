package infra.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import infra.web.objectRepositories.PageElements;
import infra.web.pageObjects.NavigationAction;

public class Button extends MyWebElement {

	public Button(WebDriver driver, PageElements elementData, By elementBy, NavigationAction afterAction) {
		super(driver, elementData, elementBy, afterAction);
	}
	
	public Button(WebDriver driver, PageElements elementData, By elementBy) {
		super(driver, elementData, elementBy);
	}
}
