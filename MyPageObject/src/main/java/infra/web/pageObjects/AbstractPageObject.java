package infra.web.pageObjects;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;
import infra.web.elements.Button;
import infra.web.elements.TextBox;
import infra.web.objectRepositories.PageElements;


public abstract class AbstractPageObject {

	protected final WebDriver driver;
	protected ReportDispatcher report = ReportManager.getInstance();
	private Map<PageElements, Button> buttonMap;
	private Map<PageElements, TextBox> textBoxMap;

	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
		waitForScreenToLoad();
		buttonMap = new HashMap<PageElements, Button>();
		textBoxMap = new HashMap<PageElements, TextBox>();
	}
	
	public void takeScreenshot(String description) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			report.addImage(scrFile, description);
		} catch (Exception e) {
			report.log("Failed to take screenshot", Status.warning);
		}
	}

	public void waitForScreenToLoad(){
		report.step("In page " + this.getClass().getSimpleName());
		try {
			assertInPage();
		} catch(NullPointerException e) {
			report.log("assertInPage element locator is not defined", Status.failure);
		} finally {
			takeScreenshot(this.getClass().getSimpleName());
		}
	}
	
	public Button getButton(PageElements button) {
		return buttonMap.get(button);
	}
	
	public void addButton(Button button) {
		buttonMap.put(button.getElementData(), button);
	}
	
	public TextBox getTextbox(PageElements textBox) {
		return textBoxMap.get(textBox);
	}
	
	public void addTextBox(TextBox tb) {
		textBoxMap.put(tb.getElementData(), tb);
	}
	
	protected abstract void assertInPage();
	
}
