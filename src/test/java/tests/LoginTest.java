package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerifyPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest {

    @Test(groups= {"TestsWithoutLogin"})
    public void login() {
        LoginPage page = new LoginPage(driver);
        page.openPage(PropertyManager.getInstance().getHomePageUrl());
        page.login(PropertyManager.getInstance().getLoginEmail(),
                PropertyManager.getInstance().getLoginPassword());

        try {
            new VerifyPage(driver).verifyLogin("Sign out");
            System.out.println("LoginTest: User is logged in");
        } catch (Exception e) {
            Assert.fail("User is not logged in");
        }
    }

}
