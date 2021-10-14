package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountPage extends BasePage {

    private By signOutButtonBy = By.className("logout");

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    public UserAccountPage logout() {
        click(signOutButtonBy);
        return this;
    }
}
