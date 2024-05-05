package pages.StockTrading;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pages.Utils;

public class MyStocksPage {

    AppiumDriver driver;

    Utils utils;
    public MyStocksPage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public boolean verifyElementsOnPage(){
        if (utils.isTextPresent("Portfolio Value") &&
            utils.isTextPresent("Portfolio Cost"))
        {
            return true;
        }
        return false;
    }

    public void viewMetrics(){
        driver.findElement(AppiumBy.accessibilityId("View Metrics")).click();


    }
}
