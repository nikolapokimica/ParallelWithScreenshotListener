package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.PropertyManager;

public class BuyOneItemFromHomePage extends BasePage {

    private By addToCartButtonBy = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"),
                proceedToCheckOutButtonBy = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"),
                proceedToCheckOutButtonSecondBy = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"),
                proceedToCheckoutButtonThirdBy = By.xpath("//*[@id=\"center_column\"]/form/p/button/span"),
                proceedToCheckoutButtonForthBy = By.xpath("//*[@id=\"form\"]/p/button/span"),
                payByBankWireButtonBY = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"),
                confirmOrderButtonBy = By.xpath("//*[@id=\"cart_navigation\"]/button/span"),
                checkBoxBy =  By.id("cgv");

    public BuyOneItemFromHomePage(WebDriver driver) {
        super(driver);
    }

    public BuyOneItemFromHomePage selectArticleAndAddToCart() {

        //Dugme za dodavanje item-a u cart nije vidljivo dok se ne predje misem preko tog elementa
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
        action.moveToElement(element).perform();

        click(addToCartButtonBy);
        click(proceedToCheckOutButtonBy);
        click(proceedToCheckOutButtonSecondBy);
        click(proceedToCheckoutButtonThirdBy);

        //Proverava da li je checkbox Terms and conditions oznacen i ako nije cekira ga
        WebElement checkBoxElement = driver.findElement(checkBoxBy);
        if (!checkBoxElement.isSelected()) checkBoxElement.click();

        click(proceedToCheckoutButtonForthBy);
        click(payByBankWireButtonBY);
        click(confirmOrderButtonBy);

        return this;
    }

}
