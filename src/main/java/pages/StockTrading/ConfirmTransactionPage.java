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

public class ConfirmTransactionPage {

    private AppiumDriver driver;

    Utils utils;

    public ConfirmTransactionPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void enterTransactionPin(String pin, String module){
        Utils utils = new Utils(driver);
        try {
            utils.enterTransactionPin(pin,module);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.accessibilityId("Confirm Transaction")).click();
    }

    public void clickConfirmTransactionButton(){
        driver.findElement(By.xpath("(//*[contains(@content-desc,'Confirm Transaction')])[2]")).click();
    }

    public void waitForSuccessMessage(long waitPeriod){
        utils.containsText("Processing");
        utils.delay(waitPeriod);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(utils.containsText("Withdrawal Successful")));
        Utils.tapOnCoordinates(327,868);
        utils.isTextPresent("Stock Trading Balance");
    }

    public void processingWithdrawal(){
        utils.isTextPresent("Processing withdrawal");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(utils.containsText("Withdrawal successful")));
    }
}
