package pages.StockTrading;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class ConfirmTransactionPage {

    private AppiumDriver driver;

    private By pinInput = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[11]");
    private By confirmTransactionBtn = By.xpath("(//android.view.View[@content-desc=\"Confirm Transaction\"])[2]");
    public ConfirmTransactionPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void enterTransactionPin(String pin){
        Utils utils = new Utils(driver);
        try {
            utils.enterTransactionPin(pin);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.accessibilityId("Confirm Transaction")).click();
    }

    public void clickConfirmTransactionButton(){
        driver.findElement(confirmTransactionBtn).click();
    }

}
