package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By signInButtonBy = By.className("login"),
               emailFieldBy = By.id("email"),
               passwordFieldBy = By.id("passwd") ,
               loginButtonBy = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openHomePage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage login(String email, String password) {
        click(signInButtonBy);
        writeText(emailFieldBy, email);
        writeText(passwordFieldBy, password);
        click(loginButtonBy);
        return this;
    }
}
