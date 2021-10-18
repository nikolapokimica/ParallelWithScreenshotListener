package tests_with_login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BuyOneItemFromHomePage;
import pages.VerifyPage;
import utilities.PropertyManager;

public class BuyOneItemFromHomePageTest extends BaseTestWithLogin {

    @Test
    public void buyStuff() {
        new BuyOneItemFromHomePage(driver)
                .navigateToHomePage(PropertyManager.getInstance().getUrl())
                .selectArticleAndAddToCart();

        try {
            verifyPage.verifyOrderConfirmation("Your order on My Store is complete.");
            System.out.println("BuyOneItemFromHomePageTest: Item is ordered");
        } catch (Exception e) {
            Assert.fail("Order wasn't completed");
        }
    }

}
