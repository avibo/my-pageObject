package tests.github;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import infra.GenericsSolution.pageObjects.MainPage;
import infra.web.objectRepositories.LoginPageElements;
import infra.web.pageObjects.AbstractPageObject;
import infra.web.pageObjects.LoginPage;
import tests.AbstractTestCase;

public class Login extends AbstractTestCase {
	
	@DataProvider(name = "test dp")
	public String[][] getUsers() {
		return new String[][]{{username, password}};
	}
	
	@Test(dataProvider = "test dp")
	public void LoginElementsMapsSolution(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getTextbox(LoginPageElements.USER_LOGIN_TB).setValue(username);
		loginPage.getTextbox(LoginPageElements.PASSWORD_TB).setValue(password);
		AbstractPageObject mainPage = loginPage.getButton(LoginPageElements.LOGIN_BTN).click();
	}
	

	@Test(dataProvider = "test dp")
	public void LoginGenericsSolution(String username, String password) {
		infra.GenericsSolution.pageObjects.LoginPage loginPage = new infra.GenericsSolution.pageObjects.LoginPage(driver);
		loginPage.passwordTb.setValue(username);
		loginPage.passwordTb.setValue(password);
		MainPage mainPage = loginPage.loginBtn.click();
	}

}
