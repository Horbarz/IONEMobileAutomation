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

    public void SeeBids(){

        TapOptions tapOptions = new TapOptions();
        tapOptions.withPosition(PointOption.point(558,308));
        System.out.println("Tapped on this position");
        //driver.perform();

//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(PointOption.point(551,308)).release().perform();
        //driver.findElement(MobileBy.AccessibilityId("See Bids")).click();
    }

    public ConfirmStockOrderPage BuyStock(String quantity){
        driver.findElement(AppiumBy.accessibilityId("Select")).click();
        driver.findElement(AppiumBy.accessibilityId("0012345670")).click();
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
}
