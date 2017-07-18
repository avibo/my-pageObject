package infraWeb.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infraWeb.elements.Button;
import infraWeb.elements.TextBox;
import infraWeb.objectRepositories.LoginPageElements;

public class LoginPage extends AbstractPageObject {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initElements() {
		addButton(new Button(driver, LoginPageElements.LOGIN_BTN, LoginPageElements.LOGIN_BTN.getByXpath()));
		addTextBox(new TextBox(driver, LoginPageElements.USER_LOGIN_TB, LoginPageElements.USER_LOGIN_TB.getByXpath()));
		addTextBox(new TextBox(driver, LoginPageElements.PASSWORD_TB, LoginPageElements.PASSWORD_TB.getByXpath()));
	}

}
