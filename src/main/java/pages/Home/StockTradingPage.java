package pages.Home;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StockTrading.DepositMoneyPage;
import pages.StockTrading.WithdrawFundPage;

import java.time.Duration;

public class StockTradingPage {
    private WebDriver driver;

    public StockTradingPage(WebDriver driver){
        this.driver = driver;

    }

    public DepositMoneyPage openDepositMoneyPage(){
        WebElement portfolio_amount = driver.findElement(MobileBy.AccessibilityId("₦58.50"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(portfolio_amount));

        driver.findElement(MobileBy.AccessibilityId("Deposit Money")).click();
        return new DepositMoneyPage(driver);
    }

    public WithdrawFundPage openWithdrawMoneyPage(){
        WebElement portfolio_amount = driver.findElement(MobileBy.AccessibilityId("₦58.50"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(portfolio_amount));
        driver.findElement(MobileBy.AccessibilityId("Withdraw Fund")).click();
        return new WithdrawFundPage(driver);
    }


}
