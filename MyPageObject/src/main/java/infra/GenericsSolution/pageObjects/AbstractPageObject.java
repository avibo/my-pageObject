package infra.GenericsSolution.pageObjects;

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


	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
		waitForScreenToLoad();
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
	
	protected abstract void assertInPage();
	
}
