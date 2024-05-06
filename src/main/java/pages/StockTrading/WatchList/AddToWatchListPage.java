package pages.StockTrading.WatchList;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Home.StockTradingPage;
import pages.Utils;


import java.time.Duration;

public class AddToWatchListPage {


    private AppiumDriver driver;

    private By alertPriceInput = By.xpath("//*[@index='5']");

    private By stockSearch = By.xpath("//*[@class='android.widget.EditText']");
    private WebElement addToWatchlistButton = driver.findElement(AppiumBy.accessibilityId("Add to Watchlist"));
    private WebElement backToWatchlistButton = driver.findElement(AppiumBy.accessibilityId("Back to Watchlist"));

    Utils utils;

    public AddToWatchListPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public StockTradingPage AddTStockToWatchList(){
        addToWatchlistButton.click();
        backToWatchlistButton.click();
        return new StockTradingPage(driver);
    }

    public boolean addStockToWatchlist(String nameOfStocks, String alertPrice){
        driver.findElement(AppiumBy.accessibilityId("Select stock\n" +
                "Select stock")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("7UP"))));
        try {
            driver.findElement(AppiumBy.accessibilityId(nameOfStocks)).click();
        }catch(Exception e){
            driver.findElement(stockSearch).sendKeys(nameOfStocks.toLowerCase());
            driver.findElement(AppiumBy.accessibilityId(nameOfStocks)).click();
            e.toString();
        }
        if(alertPrice != null){
            driver.findElement(alertPriceInput).sendKeys(alertPrice);
        }
        driver.findElement(AppiumBy.accessibilityId("Add to Watchlist")).click();

        if(utils.isTextPresent("Stock Added to Watchlist Successfully")){
            return true;
        }
        return false;
    }
}
