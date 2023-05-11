package pages.StockTrading;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletFundingPage {

    private WebDriver driver;

    private By walletFundingNotification = By.xpath("//*[@index='0']");

    public WalletFundingPage(WebDriver driver){
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
