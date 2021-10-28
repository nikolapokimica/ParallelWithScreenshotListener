package cookie_saver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.PropertyManager;

import java.util.Set;

public class CookieSaver {

    private static Cookie cookie = null;

    private CookieSaver() {}

    //Pri prvom pozivu ove klase uradice se Login putem UI-a i sacuvace cookie za tu sesiju
    //Svaki sledeci poziv ce preskociti UI logovanje i vratiti vec sacuvani cookie
    public static Cookie getCookie(WebDriver driver, LoginPage loginPage) {
        if (cookie == null) {
            //sprecava stvaranje vise od jedne instance tokom paralelnog izvrsavanja
            synchronized (CookieSaver.class) {
                loginPage.login(PropertyManager.getInstance().getLoginEmail(),
                        PropertyManager.getInstance().getLoginPassword());
                Set<Cookie> cookies = driver.manage().getCookies();
                cookie = (Cookie) cookies.toArray()[0];
            }
        }
        return cookie;
    }
}


