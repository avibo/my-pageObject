package infra.GenericsSolution.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infra.GenericsSolution.elements.Button;

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
		exploreGitHubBtn = new Button(driver, "Explore GitHub button", By.xpath("//a[text() = 'Explore GitHub']"));
	}
}
