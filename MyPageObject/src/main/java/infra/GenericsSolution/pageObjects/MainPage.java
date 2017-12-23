package infra.GenericsSolution.pageObjects;

import org.openqa.selenium.WebDriver;
import infra.web.elements.Button;
import infra.web.objectRepositories.MainPageElements;

public class MainPage extends AbstractPageObject {

	public MainPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	@Override
	protected void assertInPage() {
		
	}

	private void initElements() {
		addButton(new Button(driver, MainPageElements.EXPLORE_GITHUB_BTN, MainPageElements.EXPLORE_GITHUB_BTN.getByXpath()));
	}
}
