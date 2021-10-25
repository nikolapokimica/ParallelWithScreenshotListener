package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utilities.PropertyManager;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        //Obavesti Windows da cemo koristiti chrome driver
        System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getDriverPath());

        //inicijalizuj driver i prosledi mu podesavanje da iskljuci sva obavestenje da ne ometaju test i da se maksimizuje
        driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications").addArguments("--start-maximized"));

        //podesi driver da ceka 20s da se element pojavi pre nego sto baci izuzetak No Such Element Exception i fejluje test
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
