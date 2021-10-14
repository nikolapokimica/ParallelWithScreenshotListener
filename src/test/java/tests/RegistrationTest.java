package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.VerifyPage;
import data_generators.DataGeneratorForRegistration;
import utilities.PropertyManager;

public class RegistrationTest extends BaseTest {

    @Test
    public void registration() {

        DataGeneratorForRegistration registrationData = new DataGeneratorForRegistration();
        //System.out.println(registrationData);
        new RegistrationPage(driver)
                .openHomePage(PropertyManager.getInstance().getUrl())
                .navigateToRegistrationPage(registrationData.getData().get("email"))
                .register(registrationData.getData());
        try {
            new VerifyPage(driver).verifyLogin("Sign out");

            PropertyManager.getInstance()
                    .readyConfiguration("loginEmail", registrationData.getData().get("email"))
                    .readyConfiguration("first_name", registrationData.getData().get("first name"))
                    .readyConfiguration("last_name",  registrationData.getData().get("last name"))
                    .readyConfiguration("loginPassword", registrationData.getData().get("password"))
                    .setConfiguration();

            System.out.println("RegistrationTest: User is registered");

        } catch (Exception e) {
            Assert.fail("User is not registered");
        }
    }

}
