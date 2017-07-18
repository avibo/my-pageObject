package infraWeb;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import infraConfigs.ResourceUtils;
import infraConfigs.TestConfig;

public class WebdriverFactory {

	public static WebDriver getWebdriver() {

		String type = TestConfig.INSTANCE.getDriverType().toLowerCase().trim();
		WebDriver driver = null;
		switch (type) {
		case "chrome":
			copyDriverToRoot("chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			copyDriverToRoot("geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}
		driver = new EventFiringWebDriver(driver);
		((EventFiringWebDriver) driver).register(new ScreenshotEventListener());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	private static void copyDriverToRoot(String driverName) {
		try {
			byte[] content = ResourceUtils.getResournceAsByteArray("drivers/" + driverName);
			FileUtils.writeByteArrayToFile(new File(driverName), content);
		} catch (IOException e) {
			// handle exception
		}
	}
}
