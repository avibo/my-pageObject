package infra.web.objectRepositories;

import org.openqa.selenium.By;

public enum MainPageElements implements PageElements {
	EXPLORE_GITHUB_BTN("explore gitHub button", "//a[text() = 'Explore GitHub']");

	private String name;
	private String locaotr;
	
	MainPageElements(String name, String locator) {
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
