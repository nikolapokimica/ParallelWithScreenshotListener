package tests_with_login;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.PropertyManager;

public class CorrectUserLoggedInTest extends BaseTestWithLogin {

    @Test(groups= {"TestsWithLogin", "InDevelopment"})
    public void userLoggedIn() {

        try {
            //Prva verifikacija ce da failuje test zbog demonstracije skipovanja testova iz grupe "InDevelopment"
            //Zameniti zakomentarisane linije za pravilan rad
            verifyPage.verifyLoggedUser("Fail intentionaly" + " " + PropertyManager.getInstance().getLastName());
            //verifyPage.verifyLoggedUser(PropertyManager.getInstance().getFirstName() + " " + PropertyManager.getInstance().getLastName());
            System.out.println("CorrectUserLoggedInTest: Correct user is logged in");
        } catch (Exception e) {
            Assert.fail("Something is wrong");
        }
    }
}
