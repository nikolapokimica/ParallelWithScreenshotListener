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
        LoginPage page = new LoginPage(driver);
        page.openPage(PropertyManager.getInstance().getHomePageUrl());
        page.login(email, password);

        try {
            new VerifyPage(driver).verifyFailedLogin("There is 1 error\nAuthentication failed.");
            System.out.println("FailedLogInTest: User is not logged in.");
        } catch (Exception e) {
            Assert.fail("User is logged in.");
        }
    }

    //Data provider omogucava da se test pokrene vise puta sa razlicitim parametrima. Parametri ce biti prosledjeni metodi sa
    //anotacijom @Test(DataProvider="Data Prodvider Name") i moraju odgovarati potpisu te metode
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]
                {
                        //namerno izazvano da test padne u prva dva poziva prosle]ivanjem parametara
                        //korisnika koji vec imaju napravljen profil. Treci poziv koristi random podatke
                        {"arnold.feeney@hotmail.com", "cf8ly1ukx"},
                        {"carmel.vandervort@yahoo.com", "u7ao1upj6b"},
                        {DataCreation.email(), DataCreation.password()}
                };
    }
}
