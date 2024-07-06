package pages.Savings;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;

public class FundsTransferPage {
    private AppiumDriver driver;

    public FundsTransferPage(AppiumDriver driver){
        this.driver = driver;
    }


    public WithdrawFundPage openWithdrawToBank(){
        driver.findElement(AppiumBy.accessibilityId("Withdraw to Bank")).click();
        return new WithdrawFundPage(driver);
    }

    public TransferToZing openTransferToZing(){
        driver.findElement(AppiumBy.accessibilityId("Transfer to Ziing User")).click();
        return new TransferToZing(driver);
    }


}
