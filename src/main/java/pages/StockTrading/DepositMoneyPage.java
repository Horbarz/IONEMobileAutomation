package pages.StockTrading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepositMoneyPage {

    private WebDriver driver;

    private By amountToFundField = By.xpath("//*[@index='3']");

    private By cardFundingBtn = By.xpath("//*[@index='5']");

    private By walletFundingBtn = By.xpath("//*[@index='6']");



    public DepositMoneyPage(WebDriver driver){
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
        amount.click();
        amount.sendKeys(amountToFund);
        driver.findElement(cardFundingBtn).click();
        return new CardFundingPage(driver);
    }



}
