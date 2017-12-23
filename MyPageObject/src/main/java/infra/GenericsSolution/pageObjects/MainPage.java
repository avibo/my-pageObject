package infra.GenericsSolution.pageObjects;

import org.openqa.selenium.WebDriver;

import infra.GenericsSolution.elements.Button;
import infra.GenericsSolution.objectRepositories.MainPageElements;

public class MainPage extends AbstractPageObject {
	
	public Button exploreGitHubBtn;

	public MainPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	@Override
	protected void assertInPage() {
		
	}

	private void initElements() {
		exploreGitHubBtn = new Button(driver, MainPageElements.EXPLORE_GITHUB_BTN, MainPageElements.EXPLORE_GITHUB_BTN.getByXpath());
	}
}
