package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyPage extends BasePage {

    private By errorNotificationBy = By.xpath("//div[@id='center_column']/div[1]"),
               signOutButtonBy = By.className("logout"),
               userNameBy = By.className("account"),
               signInButtonBy = By.className("login"),
               orderConfirmationBy = By.xpath("//*[@id=\"center_column\"]/div/p/strong");

    public VerifyPage(WebDriver driver) {
        super(driver);
    }

    public VerifyPage verifyFailedLogin(String expectedMessage) {
        assertStringEquals(readText(errorNotificationBy), expectedMessage);
        return this;
    }

    public VerifyPage verifyLogin(String expectedText) {
        assertStringEquals(readText(signOutButtonBy), expectedText);
        return this;
    }

    public VerifyPage verifyLoggedUser(String expectedText) {
        assertStringEquals(readText(userNameBy), expectedText);
        return this;
    }

    public VerifyPage verifyUserIsLoggedOut(String expectedText) {
        assertStringEquals(readText(signInButtonBy), expectedText);
        return this;
    }

    public VerifyPage verifyOrderConfirmation(String expectedText) {
        assertStringEquals(readText(orderConfirmationBy), expectedText);
        return this;
    }
}
