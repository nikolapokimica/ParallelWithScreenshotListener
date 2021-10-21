package tests_with_login;

import cookie_saver.CookieSaver;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.VerifyPage;
import tests.BaseTest;
import utilities.PropertyManager;

public abstract class BaseTestWithLogin extends BaseTest {

    protected VerifyPage verifyPage;

    @Override
    @BeforeMethod
    public void setup() {
        super.setup();

        LoginPage loginPage = new LoginPage(driver);

        //Otvara se login stranica
        loginPage.openPage(PropertyManager.getInstance().getLoginPageUrl());

        //Preskace se Login UI umetanjem cookie-a
        driver.manage().addCookie(CookieSaver.getCookie(driver, loginPage));

        //Stranica se refresuje da bi se logovali sa kukijem
        driver.navigate().refresh();

        verifyPage = new VerifyPage(driver);
    }

}
