package tests_with_login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserAccountPage;

public class LogoutTest extends BaseTestWithLogin {

    @Test
    public void logout() {
        new UserAccountPage(driver).logout();

        try {
            verifyPage.verifyUserIsLoggedOut("Sign in");
            System.out.println("LogoutTest: User is logged out");
        } catch (Exception e) {
            Assert.fail("User is not logged out");
        }
    }
}
