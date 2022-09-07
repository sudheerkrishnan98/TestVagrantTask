package org.baseclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void browserlaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void openWebPage(String url) {
		driver.get(url);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void enterText(WebElement e, String text) {
		e.sendKeys(text);

	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void click(WebElement e) {
		e.click();
	}

	public static void timeImplicity5Seconds() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static String getText(WebElement e) {
		String s = e.getText();
		return s;
	}

	public static void assertValue(String webText, String compareText) {
		SoftAssert s = new SoftAssert();
		s.assertTrue(webText.contains(compareText), "Values are matching");

	}

	public static void movieSearchSugesstion(List<WebElement> e, String movieName) {
		for (int i = 0; i <= e.size(); i++) {
			if (e.get(i).getText().contains(movieName)) {
				click(e.get(i));
			} else {
				System.out.println("Movie Not Found");
			}
		}
	}

}
