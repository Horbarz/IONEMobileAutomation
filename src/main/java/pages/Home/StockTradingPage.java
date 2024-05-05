package pages.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.StockTrading.*;
import pages.StockTrading.WatchList.WatchListPage;

import java.time.Duration;

public class StockTradingPage {
    private AppiumDriver driver;

    private By viewAllMyStocks = AppiumBy.xpath("(//android.view.View[@content-desc=\"See All\"])[1]");

    private By viewAllWatchlist = AppiumBy.xpath("(//android.view.View[@content-desc=\"See All\"])[2]");


    public StockTradingPage(AppiumDriver driver){
        this.driver = driver;

    }

    public TradeStocksPage tradeStock(){
        driver.findElement(AppiumBy.accessibilityId("Trade Stock")).click();
        return new TradeStocksPage(driver);
    }

    public SeeTradesPage seeTradesPage(){
        driver.findElement(AppiumBy.accessibilityId("See Trades")).click();
        return new SeeTradesPage(driver);
    }

    public DepositMoneyPage openDepositMoneyPage(){
        WebElement portfolio_cost = driver.findElement(AppiumBy.accessibilityId("Portfolio Cost"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(portfolio_cost));
        driver.findElement(AppiumBy.accessibilityId("Deposit Money")).click();
        return new DepositMoneyPage(driver);
    }

    public WithdrawFundPage openWithdrawMoneyPage(){
        WebElement portfolio_cost = driver.findElement(AppiumBy.accessibilityId("Portfolio Cost"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(portfolio_cost));
        driver.findElement(AppiumBy.accessibilityId("Withdraw Fund")).click();
        return new WithdrawFundPage(driver);
    }

    public MyStocksPage openMyStocksPage(){
        driver.findElement(viewAllMyStocks).click();
        return new MyStocksPage(driver);
    }

    public WatchListPage openWatchListPage(){
        driver.findElement(viewAllWatchlist).click();
        return new WatchListPage(driver);
    }



    public DashboardPage goToDashBoard(){
        driver.navigate().back();
        return new DashboardPage(driver);
    }


}
