package pages.StockTrading;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Utils;

import java.net.URL;

public class StockPurchasePage {

    private AppiumDriver driver;
    public Utils utils;

    public StockPurchasePage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public ConfirmStockOrderPage BuyStock(String quantity, String cscsNumber){
        driver.findElement(AppiumBy.accessibilityId("Select")).click();
        driver.findElement(AppiumBy.accessibilityId(cscsNumber)).click();
        //WebElement quant = driver.findElement(By.xpath("//*[@index='5']"));
        WebElement quant = driver.findElement(AppiumBy.xpath("//*[@class='android.widget.EditText'][1]"));
        quant.click();
        quant.sendKeys(quantity);
        utils.goBack();
        WebElement orderType = driver.findElement(By.xpath("//*[@index='6']"));
        orderType.click();
        driver.findElement(AppiumBy.accessibilityId("Market")).click();
        driver.findElement(AppiumBy.accessibilityId("BUY")).click();
        return new ConfirmStockOrderPage(driver);
    }

    public ConfirmStockOrderPage SellStock(String quantity, String cscsNumber){
        driver.findElement(AppiumBy.accessibilityId("Select")).click();
        driver.findElement(AppiumBy.accessibilityId(cscsNumber)).click();
        //WebElement quant = driver.findElement(By.xpath("//*[@index='5']"));
        WebElement quant = driver.findElement(AppiumBy.xpath("//*[@class='android.widget.EditText'][1]"));
        quant.click();
        quant.sendKeys(quantity);
        utils.goBack();
        WebElement orderType = driver.findElement(By.xpath("//*[@index='6']"));
        orderType.click();
        driver.findElement(AppiumBy.accessibilityId("Market")).click();
        driver.findElement(AppiumBy.accessibilityId("SELL")).click();
        return new ConfirmStockOrderPage(driver);
    }
}
