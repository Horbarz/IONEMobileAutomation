package pages.StockTrading;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepositMoneyPage {

    private AppiumDriver driver;

    private By amountToFundField = By.xpath("//*[@index='3']");

    private By cardFundingBtn = By.xpath("//*[@index='5']");

    private By walletFundingBtn = By.xpath("//*[@index='6']");



    public DepositMoneyPage(AppiumDriver driver){
        this.driver = driver;
    }

    public WalletFundingPage fundStockByWallet(String amountToFund){
        WebElement amount = driver.findElement(amountToFundField);
        amount.click();
        amount.sendKeys(amountToFund);
        driver.findElement(walletFundingBtn).click();
        return new WalletFundingPage(driver);
    }

    public CardFundingPage fundStockByCard(String amountToFund){
        WebElement amount = driver.findElement(amountToFundField);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(amount));

        amount.click();
        amount.sendKeys(amountToFund);
        driver.findElement(cardFundingBtn).click();
        return new CardFundingPage(driver);
    }



}
