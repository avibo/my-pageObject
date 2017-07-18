package infraWeb.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import infraWeb.objectRepositories.PageElements;

public class MyWebElement {
	
	protected ReportDispatcher report = ReportManager.getInstance();
	private WebDriver driver;
	private PageElements elementData;
	private String elementName;
	private By elementBy;
	private Runnable afterAction; 
	private WebElement element = null;
	
	public MyWebElement(WebDriver driver, PageElements elementData, By elementBy, Runnable afterAction) {
		this.driver = driver;
		this.elementData = elementData;
		this.elementName = elementData.getName();
		this.elementBy = elementBy;
		this.afterAction = afterAction;
	}
	
	public MyWebElement(WebDriver driver, PageElements elementData, By elementBy) {
		this(driver, elementData, elementBy, null);
	}
	
	public PageElements getElementData() {
		return elementData;
	}
	
	public String getElementName() {
		return elementName;
	}

	public void click(boolean runAfterAction) {
		report.log("About to click " + elementName);
		initElement();
		element.click();
		report.log("Clicked on " + elementName);
		afterAction(runAfterAction);
	}
	
	public void click() {
		click(true);
	}
	
	public void setValue(String value) {
		report.log("About to set value " + value + " in " + elementName);
		initElement();
		element.sendKeys(value);
		report.log("Successfuly set the value " + value + " in " + elementName);
	}
	
	public String getText() {
		report.log("About to get text from " + elementName);
		initElement();
		String text = element.getText();
		report.log("got the text " + text + " from " + elementName);
		return text;
	}
	
	protected void initElement() {
		element = driver.findElement(elementBy);
	}
	
	protected void afterAction(boolean runAfterAction) {
		if(afterAction != null && runAfterAction)
		{
			afterAction.run();
		}
	}
}
