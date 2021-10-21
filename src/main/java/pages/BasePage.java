package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Nadklasa sa metodama za navigaciju na stranici i za koriscenje elemenata stranice.
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        //Postavlja eksplicitan wait na 20s, u tom periodu ce proveravati condition definisan u metodi waitVisibility()
        wait = new WebDriverWait(driver, 20);
    }

    public void waitVisibility(By elementBy) {
        //postavlja wait da ceka dok element koji mu se prosledjuje ne postane vidljiv ili dok ne istekne 20 sekundi
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public BasePage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertStringEquals(String string, String expectedText) {
        Assert.assertEquals(string, expectedText);
    }
}
