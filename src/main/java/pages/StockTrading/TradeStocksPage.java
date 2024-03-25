package pages.StockTrading;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TradeStocksPage {

    private AppiumDriver driver;

    public Utils utils;

    private By searchStockField = By.xpath("//*[@index='2']");

    private By searchResult = By.xpath("//*[@index='0']");

    public TradeStocksPage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }


    public StockResultPage searchStock(String stock){
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchField = driver.findElement(searchStockField);
        searchField.click();
        searchField.sendKeys(stock);
        driver.findElement(searchResult).click();
        return new StockResultPage(driver);
    }




}
