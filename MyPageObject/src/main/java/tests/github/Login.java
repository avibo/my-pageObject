package tests.github;

import org.testng.annotations.Test;

import infraWeb.objectRepositories.LoginPageElements;
import infraWeb.pageObjects.LoginPage;
import tests.AbstractTestCase;

public class Login extends AbstractTestCase {
	
	@Test
	public void simpleLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getTextbox(LoginPageElements.USER_LOGIN_TB).setValue(username);
		loginPage.getTextbox(LoginPageElements.PASSWORD_TB).setValue(password);
		loginPage.getButton(LoginPageElements.LOGIN_BTN).click();
	}

}
