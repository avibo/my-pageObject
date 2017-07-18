package tests.github;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import infra.web.objectRepositories.LoginPageElements;
import infra.web.pageObjects.LoginPage;
import tests.AbstractTestCase;

public class Login extends AbstractTestCase {
	
	@DataProvider(name = "test dp")
	public String[][] getUsers() {
		return new String[][]{{username, password}};
	}
	
	@Test(dataProvider = "test dp")
	public void simpleLogin(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getTextbox(LoginPageElements.USER_LOGIN_TB).setValue(username);
		loginPage.getTextbox(LoginPageElements.PASSWORD_TB).setValue(password);
		loginPage.getButton(LoginPageElements.LOGIN_BTN).click();
	}

}
