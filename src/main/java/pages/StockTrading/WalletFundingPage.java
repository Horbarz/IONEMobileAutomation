package pages.StockTrading;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletFundingPage {

    private AppiumDriver driver;

    private By walletFundingNotification = By.xpath("//*[@index='0']");

    public WalletFundingPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void confirmPayment(){
        driver.findElement(MobileBy.AccessibilityId("Confirm")).click();
    }

    public void notificationMessage(){
        String message = driver.findElement(walletFundingNotification).getText();
        System.out.println("Notification Text:"+message);
        //return message;
    }


}
