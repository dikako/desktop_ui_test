package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utility.TakeScreenshot;

public class Setup {
	protected RemoteWebDriver driver;

	@BeforeMethod
	public void set() throws MalformedURLException {
		FirefoxOptions handlessOptions = new FirefoxOptions();
		handlessOptions.addArguments("start-maximized");
		handlessOptions.addArguments("enable-automation");
		handlessOptions.addArguments("--no-sandbox");
		handlessOptions.addArguments("--disable-infobars");
		handlessOptions.addArguments("--disable-dev-shm-usage");
		handlessOptions.addArguments("--disable-browser-side-navigation");
		handlessOptions.addArguments("--disable-gpu");
		handlessOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//URL url = new URL("http://172.31.0.70:4444/wd/hub");
		 URL url = new URL("http://localhost:4444/wd/hub");
		// URL url = new URL("http://selenium.mncplus.com/wd/hub");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, handlessOptions);
		handlessOptions.merge(capabilities);
		driver = new RemoteWebDriver(url, handlessOptions);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@AfterMethod
	public void done(ITestResult result) throws InterruptedException {
		String name = result.getName();
		if (ITestResult.FAILURE == result.getStatus()) {
			TakeScreenshot.captureScreenshot(driver, "Error_" + name);

			System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed!");
			System.out.println(result.getMethod().getMethodName() + " failed!");
			Thread.sleep(5000);
			driver.quit();
		} else {
			TakeScreenshot.captureScreenshot(driver, "Pass_" + name);
			Thread.sleep(5000);
			driver.quit();
		}
	}
}
