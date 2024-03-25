package pages.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import pages.Savings.FundZsaveAccountPage;
import pages.Savings.FundsTransferPage;
import pages.Utils;

public class SavingsPage {

    private AppiumDriver driver;

    public SavingsPage(AppiumDriver driver){
        this.driver = driver;
    }

    public FundsTransferPage openTransferPage(){
        driver.findElement(AppiumBy.accessibilityId("Transfer Service Box\n" +
                "Transfer")).click();
        return new FundsTransferPage(driver);
    }

    public FundZsaveAccountPage openFundAccountPage(){
        Utils utils = new Utils(driver);
        utils.tapOnCoordinates(132,459);
        return new FundZsaveAccountPage(driver);
    }




}
