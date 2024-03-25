package pages.StockTrading;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pages.Utils;

import java.time.Duration;
import java.util.Collections;

public class ConfirmStockOrderPage {

    private AppiumDriver driver;

    public ConfirmStockOrderPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void enterTransactionPin(String pin){
        WebElement transactionPin = driver.findElement(AppiumBy.xpath("//*[@class='android.view.View'][16]"));
        Utils.tapOnElement(transactionPin);

    }


}
