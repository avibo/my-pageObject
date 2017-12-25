package infra.GenericsSolution.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infra.GenericsSolution.elements.Button;
import infra.GenericsSolution.elements.TextBox;

public class LoginPage extends AbstractPageObject {
	
	public Button loginBtn;
	public TextBox userLoginTb;
	public TextBox passwordTb;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	@Override
	protected void assertInPage() {
		
	}
	
	private void initElements() {
		loginBtn = new Button(driver, "Login button", By.xpath("//input[@value = 'Sign in']"), () -> loginAction()){
			@Override
			public MainPage click(boolean runAfterAction) {
				return super.click(runAfterAction);
			}
		};
		userLoginTb = new TextBox(driver, "Username textbox", By.xpath("//input[@id = 'login_field']"));
		passwordTb = new TextBox(driver, "Password textbox", By.xpath("//input[@id = 'password']"));
	}
	
	public MainPage loginAction() {
		return new MainPage(driver);
	}

}
