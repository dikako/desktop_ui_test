package testcases;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_Login extends Setup {
	
	public String path = "../desktop_ui_test/src/main/java/data/data_test.xlsx";
	
	@DataProvider
	public String[][] login_success() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Success");
	}
	
	@DataProvider
	public String[][] login_username_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Username");
	}
	
	@DataProvider
	public String[][] login_password_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Password");
	}
	
	@DataProvider
	public String[][] login_popup_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Popup");
	}
	
//	@Severity(SeverityLevel.CRITICAL)
//	@Description("Login Test - Success Login")
//	@Test(priority = 0, testName = "Login Success", dataProvider = "login_success")
//	public void login_test_success(String username, String password, String alertText) throws InterruptedException {
//		Url url = new Url(driver);
//		Input input = PageFactory.initElements(driver, Input.class);
//		Button button = PageFactory.initElements(driver, Button.class);
//		Alert alerts = PageFactory.initElements(driver, Alert.class);
//		
//		System.out.println("Login Test - Login Success");
//		
//		url.urls("/login");
//		input.byId("username", username);
//		input.byId("password", password);
//		button.byId("btnLogin");
//		Thread.sleep(5000);
//		
//		button.byClassByIndex("nav-link", 5);
//		alerts.byXpath("//li[contains(text(),'" + alertText + "')]", alertText);
//	}
//	
//	@Severity(SeverityLevel.CRITICAL)
//	@Description("Login Test - Success Login Logout")
//	@Test(priority = 1, testName = "Login Success Logout Success", dataProvider = "login_success")
//	public void login_test_logout(String username, String password, String alertText) throws InterruptedException {
//		Url url = new Url(driver);
//		Input input = PageFactory.initElements(driver, Input.class);
//		Button button = PageFactory.initElements(driver, Button.class);
//		Alert alerts = PageFactory.initElements(driver, Alert.class);
//		
//		System.out.println("Login Test - Login Success Logout Success");
//		
//		url.urls("/login");
//		input.byId("username", username);
//		input.byId("password", password);
//		button.byId("btnLogin");
//		Thread.sleep(5000);
//		
//		button.byClassByIndex("nav-link", 5);
//		alerts.byXpath("//li[contains(text(),'" + alertText + "')]", alertText);
//		button.byClass("btn-logOut");
//		Thread.sleep(5000);
//		button.byClassByIndex("nav-link", 5);
//		Thread.sleep(5000);
//		alerts.urlValidate("/login");
//	}

	@Severity(SeverityLevel.MINOR)
	@Description("Login Test - Success Alert username")
	@Test(priority = 2, testName = "Login Alert Username", dataProvider = "login_username_alert")
	public void login_test_username_alert(String username, String password, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Login Test - Login Alert Username");
		
		url.urls("/login");
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		Thread.sleep(5000);
		alerts.byClass("text-danger", alertText);
	}
	
	@Severity(SeverityLevel.MINOR)
	@Description("Login Test - Success Alert Password")
	@Test(priority = 3, testName = "Login Success", dataProvider = "login_password_alert")
	public void login_test_password_alert(String username, String password, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Login Test - Login Alert Password");
		
		url.urls("/login");
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		Thread.sleep(5000);
		alerts.byClass("text-warning-custom", alertText);
	}
	
	@Severity(SeverityLevel.MINOR)
	@Description("Login Test - Success Alerrt Popup")
	@Test(priority = 3, testName = "Login Success", dataProvider = "login_popup_alert")
	public void login_test_popup_alert(String username, String password, String alertText) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Login Test - Login Alert Password");
		
		url.urls("/login");
		input.byId("username", username);
		input.byId("password", password);
		button.byId("btnLogin");
		Thread.sleep(5000);
		alerts.byClass("text-warning-custom", alertText);
	}
}
