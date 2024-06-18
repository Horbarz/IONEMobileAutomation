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
    Utils utils;

    public ConfirmStockOrderPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void enterTransactionPin(String pin, String stock){
        utils.delay(20);
        driver.findElement(AppiumBy.accessibilityId("One-Touch"));
        utils.containsText("Available Balance");
        driver.findElement(AppiumBy.accessibilityId("Order Type"));
        driver.findElement(AppiumBy.accessibilityId("CSCS Account"));
        driver.findElement(AppiumBy.accessibilityId("Price per unit"));
        driver.findElement(AppiumBy.accessibilityId("Estimated Amount"));
        driver.findElement(AppiumBy.accessibilityId("Date Limit"));
        driver.findElement(AppiumBy.accessibilityId("Unit"));
        driver.findElement(AppiumBy.accessibilityId("Enter Transaction Pin"));

        try {
            utils.enterTransactionPin(pin,stock);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();

        driver.findElement(AppiumBy.accessibilityId("Order placed Successfully"));
        utils.containsText("You have successfully placed an order");
    }


}
