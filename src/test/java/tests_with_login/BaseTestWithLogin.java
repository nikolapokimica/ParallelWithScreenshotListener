package tests_with_login;

import cookie_saver.CookieSaver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.VerifyPage;
import tests.BaseTest;
import utilities.PropertyManager;

import java.util.concurrent.TimeUnit;

public abstract class BaseTestWithLogin extends BaseTest {

    protected VerifyPage verifyPage;

    @Override
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getDriverPath());

        driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver).openHomePage(PropertyManager.getInstance().getUrl());
        driver.manage().addCookie(CookieSaver.getCookie(driver, loginPage));
        driver.navigate().refresh();

        verifyPage = new VerifyPage(driver);
    }

}
