package infra.web.pageObjects;

import org.openqa.selenium.WebDriver;

import infra.web.elements.Button;
import infra.web.elements.TextBox;
import infra.web.objectRepositories.LoginPageElements;

public class LoginPage extends AbstractPageObject {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	@Override
	protected void assertInPage() {
		
	}
	
	private void initElements() {
		addButton(new Button(driver, LoginPageElements.LOGIN_BTN, LoginPageElements.LOGIN_BTN.getByXpath(), () -> loginAction()));
		addTextBox(new TextBox(driver, LoginPageElements.USER_LOGIN_TB, LoginPageElements.USER_LOGIN_TB.getByXpath()));
		addTextBox(new TextBox(driver, LoginPageElements.PASSWORD_TB, LoginPageElements.PASSWORD_TB.getByXpath()));
	}
	
	public MainPage loginAction() {
		return new MainPage(driver);
	}

}
