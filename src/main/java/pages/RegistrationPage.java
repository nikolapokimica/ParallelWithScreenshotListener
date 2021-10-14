package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;


public class RegistrationPage extends BasePage {

    private By  signInButtonBy = By.className("login"),
                emailInputFieldBy = By.id("email_create"),
                createAccountButtonBy = By.id("SubmitCreate"),
                genderRadioButtonBy = By.id("id_gender1"),
                firstNameInputFieldBy = By.id("customer_firstname"),
                lastNameInputFieldBy = By.id("customer_lastname"),
                passwordInputFieldBy = By.id("passwd"),
                addressInputFieldBy = By.id("address1"),
                cityInputFieldBy = By.id("city"),
                postCodeInputFieldBy = By.id("postcode"),
                mobilePhoneInputFieldBy = By.id("phone_mobile"),
                aliasAddressInputFieldBy = By.id("alias"),
                registerButtonBy = By.id("submitAccount"),
                stateDropDownBy = By.id("id_state");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage openHomePage(String url) {
        driver.get(url);
        return this;
    }
    public RegistrationPage navigateToRegistrationPage(String regEmail) {
        click(signInButtonBy);
        writeText(emailInputFieldBy, regEmail);
        click(createAccountButtonBy);
        return this;
    }

    public RegistrationPage register(HashMap<String, String> registrationData) {
        click(genderRadioButtonBy);
        writeText(firstNameInputFieldBy, registrationData.get("first name"));
        writeText(lastNameInputFieldBy, registrationData.get("last name"));
        writeText(passwordInputFieldBy, registrationData.get("password"));
        writeText(addressInputFieldBy, registrationData.get("address"));

        Select state = new Select(driver.findElement(stateDropDownBy));
        state.selectByIndex((int)(1 + Math.random()*(state.getOptions().size()-1-1)));

        writeText(cityInputFieldBy, registrationData.get("city"));
        writeText(postCodeInputFieldBy, registrationData.get("postcode"));
        writeText(mobilePhoneInputFieldBy, registrationData.get("mobile phone"));
        writeText(aliasAddressInputFieldBy, registrationData.get("alias address"));
        click(registerButtonBy);
        return this;
    }


}
