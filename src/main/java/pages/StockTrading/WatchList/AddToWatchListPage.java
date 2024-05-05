package pages.StockTrading.WatchList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Home.StockTradingPage;

public class AddToWatchListPage {


    private AppiumDriver driver;
    private WebElement addToWatchlistButton = driver.findElement(AppiumBy.accessibilityId("Add to Watchlist"));
    private WebElement backToWatchlistButton = driver.findElement(AppiumBy.accessibilityId("Back to Watchlist"));


    public AddToWatchListPage(AppiumDriver driver){
        this.driver = driver;
    }

    public StockTradingPage AddTStockToWatchList(){
        addToWatchlistButton.click();
        backToWatchlistButton.click();
        return new StockTradingPage(driver);
    }

    public void addStockToWatchlist(){

    }
}
