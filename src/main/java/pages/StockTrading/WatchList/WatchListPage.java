package pages.StockTrading.WatchList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WatchListPage {

    private AppiumDriver driver;

    Utils utils;

    private By openStockOne = AppiumBy.xpath("//android.view.View[@content-desc=\"ABBEYBDS\n" +
            "₦2.44\n" +
            "43.53\"]");

    private By heartIcon = AppiumBy.xpath("(//*[@class='android.widget.ImageView'])[1]");

    public WatchListPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public AddToWatchListPage openAddToWatchListPage(){
        driver.findElement(AppiumBy.accessibilityId("Add to Watchlist")).click();
        return new AddToWatchListPage(driver);
    }

    public void goBackToWatchList(){
        driver.navigate().back();
    }

    public boolean verifyStocksAddedToWatchList(String stock){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("ABBEYBDS\n" +
                "₦2.44\n" +
                "43.53"))));
        if(utils.isTextPresent("No stock found")){
            System.out.println("No stock found");
        }else {
            try{
                utils.containsText(stock.toUpperCase()).click();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("Details"))));
                driver.findElement(AppiumBy.accessibilityId("Sector"));
                driver.findElement(AppiumBy.accessibilityId("Open"));
                driver.findElement(AppiumBy.accessibilityId("Close"));
                driver.findElement(AppiumBy.accessibilityId("Last"));
                driver.findElement(AppiumBy.accessibilityId("Segment"));
                driver.findElement(AppiumBy.accessibilityId("50 days Moving Average"));
                driver.findElement(AppiumBy.accessibilityId("200 day Moving Average"));
                return true;
            }catch (Exception e){
                e.toString();

            }

        }
        return false;
    }

    public boolean removeStockFromWatchList(){
            driver.findElement(heartIcon).click();
            Utils.tapOnCoordinates(351,873);
            if(utils.isTextPresent("Removing watchlist...")){
                return true;
            }

        return false;
    }

}
