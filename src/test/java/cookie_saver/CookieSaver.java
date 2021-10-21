package cookie_saver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.PropertyManager;

import java.util.Set;

public class CookieSaver {

    private static Cookie cookie = null;

    private CookieSaver() {}

    public static Cookie getCookie(WebDriver driver, LoginPage loginPage) {
        if (cookie == null) {
            loginPage.login(PropertyManager.getInstance().getLoginEmail(),
                    PropertyManager.getInstance().getLoginPassword());
            Set<Cookie> cookies = driver.manage().getCookies();
            cookie = (Cookie) cookies.toArray()[0];
        }
        return cookie;
    }
}
