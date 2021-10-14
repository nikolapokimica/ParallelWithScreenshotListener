package tests;

import data_generators.DataCreation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerifyPage;
import utilities.PropertyManager;

public class FailedLoginTest extends BaseTest {

    @Test(dataProvider="SearchProvider")
    public void failedLogin(String email, String password) {
        new LoginPage(driver)
                .openHomePage(PropertyManager.getInstance().getUrl())
                .login(email, password);

        try {
            new VerifyPage(driver).verifyFailedLogin("There is 1 error\nAuthentication failed.");
            System.out.println("FailedLogInTest: User is not logged in.");
        } catch (Exception e) {
            Assert.fail("User is logged in.");
        }
    }

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]
                {
                        {"arnold.feeney@hotmail.com", "cf8ly1ukx"},
                        {"carmel.vandervort@yahoo.com", "u7ao1upj6b"},
                        {DataCreation.email(), DataCreation.password()}
                };
    }
}
