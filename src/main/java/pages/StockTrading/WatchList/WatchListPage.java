package pages.StockTrading.WatchList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Utils;

import java.time.Duration;

public class WatchListPage {

    private AppiumDriver driver;

    Utils utils;

    private By openStockOne = AppiumBy.xpath("//android.view.View[@content-desc=\"ABBEYBDS\n" +
            "₦2.44\n" +
            "43.53\"]");

    public WatchListPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public AddToWatchListPage addToWatchList(){
        driver.findElement(AppiumBy.accessibilityId("Add to Watchlist")).click();
        return new AddToWatchListPage(driver);
    }

    public void verifyStocksAddedToWatchList(String stock){
        if(utils.isTextPresent("No stock found")){
            System.out.println("No stock found");
        }else {
            utils.containsText(stock).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("Details"))));
            driver.findElement(AppiumBy.accessibilityId("Sector"));
            driver.findElement(AppiumBy.accessibilityId("Open"));
            driver.findElement(AppiumBy.accessibilityId("Close"));
            driver.findElement(AppiumBy.accessibilityId("Last"));
            driver.findElement(AppiumBy.accessibilityId("Segment"));
            driver.findElement(AppiumBy.accessibilityId("50 days Moving Average"));
            driver.findElement(AppiumBy.accessibilityId("200 day Moving Average"));
        }
    }

}
