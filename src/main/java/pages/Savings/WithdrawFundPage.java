package pages.Savings;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.StockTrading.ConfirmTransactionPage;
import pages.Utils;

public class WithdrawFundPage {

    private AppiumDriver driver;
    private By amountToFundField = By.xpath("//*[@index='2']");

    private By selectBankAccount = By.xpath("//*[@index='0']");

    private By selectWithdrawalAccount = By.xpath("//*[@index='5']");

    public Utils utils;

    public WithdrawFundPage(AppiumDriver driver){
        this.driver = driver;
    }

    public ConfirmTransactionPage withdrawFundsToBank(String amountToWithdraw){
        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
        utils = new Utils(driver);
        utils.isTextPresent("Please supply neccessary fields");
        WebElement amount = driver.findElement(amountToFundField);
        amount.click();
        amount.sendKeys("10.00");
        driver.findElement(selectWithdrawalAccount).click();
        driver.findElement(AppiumBy.accessibilityId("Bank Account")).click();
        driver.findElement(selectBankAccount).click();
        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
        utils.isTextPresent("Please supply a valid amount");
        amount.click();
        amount.sendKeys(amountToWithdraw);
        utils.goBack();
        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
        return new ConfirmTransactionPage(driver);
    }

}
