package pages.FixedIncome;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pages.Home.FixedIncomePage;
import pages.Utils;

public class FundingMethod {

    private AppiumDriver driver;

    Utils utils;

    public FundingMethod(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public FixedIncomePage CardFunding(){
        driver.findElement(AppiumBy.accessibilityId("Card Funding\n" +
                "Fund with your card")).click();
        utils.delay(2);
        driver.findElement(AppiumBy.accessibilityId("***")).click();
        utils.isTextPresent("Processing ...");
        utils.delay(2);
        utils.isTextPresent("Booking investment...");
        utils.delay(5);
        return new FixedIncomePage(driver);
    }

    public FixedIncomePage WalletFunding(){
        driver.findElement(AppiumBy.accessibilityId("My Wallet\n" +
                "Fund from your wallet")).click();
        utils.isTextPresent("Wallet Funding");
        utils.isTextPresent("Transaction Type");
        utils.isTextPresent("Amount to fund");
        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
        utils.isTextPresent("Please wait...");
        utils.delay(2);
        utils.isTextPresent("Booking investment...");
        utils.delay(5);
        return new FixedIncomePage(driver);
    }

    public FixedIncomePage StockBroking(){
        driver.findElement(AppiumBy.accessibilityId("Stockbroking\n" +
                "Fund from stockbroking balance")).click();
        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
        return new FixedIncomePage(driver);
    }

    public void goBack(){
        driver.navigate().back();
    }

}
