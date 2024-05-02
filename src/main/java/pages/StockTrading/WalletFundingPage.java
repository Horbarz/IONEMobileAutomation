package pages.StockTrading;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WalletFundingPage {

    private AppiumDriver driver;

    private By walletFundingNotification = By.xpath("//*[@index='0']");

    public WalletFundingPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void confirmPayment(){
        driver.findElement(MobileBy.AccessibilityId("Confirm")).click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



    }

    public void notificationMessage(){
        String message = driver.findElement(walletFundingNotification).getText();
        System.out.println("Notification Text:"+message);
        //return message;
    }


}
