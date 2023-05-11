package pages.StockTrading;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmTransactionPage {

    private WebDriver driver;

    private By pinInput = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[11]");
    private By confirmTransactionBtn = By.xpath("(//android.view.View[@content-desc=\"Confirm Transaction\"])[2]");
    public ConfirmTransactionPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterTransactionPin(String pin){
        WebElement pinInputElement = driver.findElement(pinInput);
        pinInputElement.click();
        pinInputElement.sendKeys(pin);
        driver.findElement(MobileBy.AccessibilityId("Confirm Transaction")).click();
    }

    public void clickConfirmTransactionButton(){
        driver.findElement(confirmTransactionBtn).click();
    }

}
