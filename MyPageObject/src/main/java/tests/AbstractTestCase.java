package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import infra.configuration.TestSUT;
import infra.web.WebdriverFactory;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTestCase {

	protected static ReportDispatcher report = ReportManager.getInstance();
	private static String url = TestSUT.INSTANCE.getProperty("url");
	protected WebDriver driver;
	protected String username = TestSUT.INSTANCE.getProperty("user");
	protected String password = TestSUT.INSTANCE.getProperty("password");
	/*protected AssertUtils myAssert;
	protected Verify verify;
	protected SQLConnectionModule dbConnection;*/

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = WebdriverFactory.getWebdriver();
		driver.get(url);
		/*verify = new Verify(driver);
		myAssert = new AssertUtils(driver);
		dbConnection= new SQLConnectionModule(DBConnections.CONST);*/
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
