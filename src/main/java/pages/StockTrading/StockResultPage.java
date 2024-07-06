package pages.StockTrading;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StockTrading.WatchList.AddToWatchListPage;
import pages.Utils;

import java.time.Duration;

public class StockResultPage {

    private AppiumDriver driver;

    Utils utils;

    private By heartIcon = By.xpath("//*[@index='1']");

    public StockResultPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }


    public AddToWatchListPage clickHeartIcon(){
        driver.findElement(heartIcon).click();
        return new AddToWatchListPage(driver);
    }

    public StockPurchasePage buyStock(){
        utils.delay(10);
        WebElement buyButton = driver.findElement(AppiumBy.accessibilityId("Buy"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(buyButton));
        buyButton.click();
        return new StockPurchasePage(driver);
    }

    public StockPurchasePage sellStock(){
        utils.delay(10);
        WebElement sellButton = driver.findElement(AppiumBy.accessibilityId("Sell"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(sellButton));
        sellButton.click();
        return new StockPurchasePage(driver);
    }




}
