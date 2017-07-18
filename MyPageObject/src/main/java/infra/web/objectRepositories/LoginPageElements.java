package infra.web.objectRepositories;

import org.openqa.selenium.By;

public enum LoginPageElements implements PageElements {

	LOGIN_BTN("login", "//input[@value = 'Sign in']"),
	USER_LOGIN_TB("user name or email textbox", "//input[@id = 'login_field']"),
	PASSWORD_TB("password textbox", "//input[@id = 'password']");
	
	private String name;
	private String locaotr;
	
	LoginPageElements(String name, String locator) {
		this.name = name;
		this.locaotr = locator;
	}

	public String getName() {
		return name;
	}

	public String getLocator() {
		return locaotr;
	}
	
	public By getByXpath() {
		return By.xpath(getLocator());
	}
}
