package pages.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Savings.FundZsaveAccountPage;
import pages.Savings.FundsTransferPage;
import pages.Utils;

public class SavingsPage {

    private AppiumDriver driver;

    Utils utils;

    public SavingsPage(AppiumDriver driver){

        this.driver = driver;

        utils = new Utils(driver);
    }

    public FundsTransferPage openTransferPage(){
        driver.findElement(AppiumBy.accessibilityId("Transfer Service Box\n" +
                "Transfer")).click();
        return new FundsTransferPage(driver);
    }

    public FundZsaveAccountPage openFundAccountPage(){
        utils.containsText("Fund Account").click();
        return new FundZsaveAccountPage(driver);
    }


    public long returnBalance(){
        try{
            WebElement toggleBalEle = driver.findElement(By.xpath("//android.view.View[@content-desc=\"zSave Information\n" +
                    "Available Balance\n" +
                    "XXXXX.XX\"]/android.widget.Button"));
            toggleBalEle.click();
        }catch (Exception e){
            e.toString();
        }

        String balance = utils.containsText("zSave Information Available").getText();
        System.out.println(balance);

        long finalBal = Long.parseLong(balance.replaceAll("[^0-9]",""));

        return finalBal;
    }




}
