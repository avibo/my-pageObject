package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class justTest extends AbstractTestCase {
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys("ynet");
		driver.findElement(By.xpath("//input[@value = 'חיפוש ב-Google']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'ynet - חדשות, כלכלה, ספורט, בריאות')]")).click();
		Thread.sleep(4000);
	}

}
