package tests_with_login;

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

        new LoginPage(driver)
                .openHomePage(PropertyManager.getInstance().getUrl())
                .login(PropertyManager.getInstance().getLoginEmail(),
                        PropertyManager.getInstance().getLoginPassword());

        verifyPage = new VerifyPage(driver);
    }

}
