package tests_with_login;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.PropertyManager;

public class CorrectUserLoggedInTest extends BaseTestWithLogin {

    @Test
    public void userLoggedIn() {

        try {
            verifyPage.verifyLoggedUser(PropertyManager.getInstance().getFirstName() + " " + PropertyManager.getInstance().getLastName());
            System.out.println("CorrectUserLoggedInTest: Correct user is logged in");
        } catch (Exception e) {
            Assert.fail("Something is wrong");
        }
    }
}
