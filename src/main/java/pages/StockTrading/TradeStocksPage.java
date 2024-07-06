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

    private By searchStockField = By.xpath("//*[@class='android.widget.EditText']");

    public TradeStocksPage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }


    public StockResultPage searchStock(String stock){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@content-desc, '7UP')]"))));
        WebElement searchField = driver.findElement(searchStockField);
        searchField.click();
        searchField.clear();
        utils.delay(3);
        searchField.sendKeys(stock.toLowerCase());
        try{
            utils.containsText(stock.toUpperCase()).click();
        }catch(Exception e){
            utils.containsText("7UP").click();
        }
        return new StockResultPage(driver);
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void scrollStockList(){
        utils.delay(2);
        Utils.scroll(Utils.ScrollDirection.DOWN,0.8,null);
    }




}
