package pages.StockTrading;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class WithdrawFundPage {

    private WebDriver driver;

    private By amountToFundField = By.xpath("//*[@index='2']");

    private By selectWithdrawalAccount = By.xpath("//*[@index='5']");

    public Utils utils;





    public WithdrawFundPage(WebDriver driver){
        this.driver = driver;
    }

    public ConfirmTransactionPage withdrawFundsToWallet(String amountToWithdraw){
        driver.findElement(MobileBy.AccessibilityId("Proceed")).click();
        utils = new Utils(driver);
        utils.isTextPresent("Please supply neccessary fields");
        WebElement amount = driver.findElement(amountToFundField);
        amount.click();
        amount.sendKeys("10.00");
        driver.findElement(selectWithdrawalAccount).click();
        driver.findElement(MobileBy.AccessibilityId("Investment One Wallet")).click();
        driver.findElement(MobileBy.AccessibilityId("Proceed")).click();
        utils.isTextPresent("Please supply a valid amount");
        amount.click();
        amount.sendKeys(amountToWithdraw);
        utils.goBack();
        driver.findElement(MobileBy.AccessibilityId("Proceed")).click();
        return new ConfirmTransactionPage(driver);
    }


}
