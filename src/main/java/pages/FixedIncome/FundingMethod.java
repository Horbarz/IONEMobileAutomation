package pages.FixedIncome;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pages.Home.FixedIncomePage;

public class FundingMethod {

    private AppiumDriver driver;

    public FundingMethod(AppiumDriver driver){
        this.driver = driver;
    }

    public void CardFunding() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Card Funding\n" +
                "Fund with your card")).click();
        driver.findElement(AppiumBy.accessibilityId("***")).click();
        Thread.sleep(5000);
        driver.navigate().back();
    }

    public FixedIncomePage WalletFunding(){
        driver.findElement(AppiumBy.accessibilityId("My Wallet\n" +
                "Fund from your wallet")).click();
        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
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
