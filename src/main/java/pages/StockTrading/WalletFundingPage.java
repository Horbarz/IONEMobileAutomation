package pages.StockTrading;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Home.StockTradingPage;
import pages.Utils;

import java.util.concurrent.TimeUnit;

public class WalletFundingPage {

    private AppiumDriver driver;
    Utils utils;

    StockTradingPage stockTradingPage;

    private By walletFundingNotification = By.xpath("//*[@index='0']");

    public WalletFundingPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
        stockTradingPage = new StockTradingPage(driver);
    }

    public void confirmPayment(){
        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
        utils.delay(5);
        utils.isTextPresent("Please wait...");

    }

    public void displayNotificationMessage(){
        String message = driver.findElement(walletFundingNotification).getText();
        utils.containsText("Funding Successful");
        utils.delay(3);
        Utils.tapOnCoordinates(353,906);
        stockTradingPage.toggleBalance();
    }


}
