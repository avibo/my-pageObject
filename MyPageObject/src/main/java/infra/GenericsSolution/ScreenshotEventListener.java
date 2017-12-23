package infra.GenericsSolution;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

public class ScreenshotEventListener implements WebDriverEventListener {

	private ReportDispatcher report = ReportManager.getInstance();

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {

	}

	@Override
	public void afterScript(String script, WebDriver driver) {

	}

	/**Captures screenshot when WebDriver throws exception in case it's not TimeoutException
	 * and it didn't cause by wait
	 */
	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		try {
			if((throwable instanceof TimeoutException)||(!isExceptionCausedFromWait(throwable))) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				report.addImage(scrFile, "Exception was thrown: " + throwable.getMessage());
			}
		} catch (Exception e) {
			report.log("Failed to take screenshot", Status.warning);
		}
	}
	
	/**
	 * @param throwable
	 * @return true if throwable cause by wait 
	 */
	private boolean isExceptionCausedFromWait(Throwable throwable) {
		StackTraceElement[] stackTraceElements = throwable.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements) {
			if(stackTraceElement.getClassName().contains("Wait")) {
				return true;
			}
		}
		return false;
	}	
}



