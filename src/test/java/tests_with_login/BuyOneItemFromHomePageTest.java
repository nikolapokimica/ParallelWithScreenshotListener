package tests_with_login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BuyOneItemFromHomePage;
import pages.VerifyPage;

public class BuyOneItemFromHomePageTest extends BaseTestWithLogin {

    @Test
    public void buyStuff() {
        new BuyOneItemFromHomePage(driver)
                .navigateToHomePage()
                .selectArticleAndAddToCart();

        try {
            new VerifyPage(driver).verifyOrderConfirmation("Your order on My Store is complete.");
            System.out.println("BuyOneItemFromHomePageTest: Item is ordered");
        } catch (Exception e) {
            Assert.fail("Order wasn't completed");
        }
    }

}
