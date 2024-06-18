package pages.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.FixedIncome.FundingMethod;
import pages.Utils;

import java.io.IOException;

public class FixedIncomePage {

    private AppiumDriver driver;

    Utils utils;

    private By amountField = AppiumBy.xpath("//*[@text='0.00']");



    public FixedIncomePage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public FundingMethod selectInvestmentPlan(String investmentPlan, String amount){

        driver.findElement(AppiumBy.accessibilityId("Add New Investment")).click();
        utils.delay(20);

        switch (investmentPlan){
            case "Fixed Deposit Investment":
                utils.containsText("Fixed Deposit Investment").click();
                break;
            case "High Yield Note":
                utils.containsText("High Yield Note").click();
                break;
            case "IJARA":
                utils.containsText("IJARA").click();
                break;
            case "Medium Term Note":
                utils.containsText("Medium Term Note").click();
                break;
            case "Real Estate Note":
                utils.containsText("Real Estate Note").click();
                break;
        }

        WebElement amountEle = driver.findElement(amountField);

        amountEle.click();
        amountEle.sendKeys(amount);
        utils.delay(3);
        utils.goBack();
        utils.isTextPresent("Min Amount");
        utils.isTextPresent("Max Amount");
        utils.isTextPresent("Tenure");
        utils.isTextPresent("Rate per annum");
        utils.goBack();
        driver.findElement(AppiumBy.accessibilityId("Select")).click();
        driver.findElement(AppiumBy.accessibilityId("30")).click();
        Utils.scroll(Utils.ScrollDirection.DOWN, 0.75, null);
        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
        return new FundingMethod(driver);
    }

    public void viewAllInvestments(){
        driver.findElement(AppiumBy.accessibilityId("View All")).click();
    }

    public void terminateInvestment(){
        driver.navigate().back();
        viewAllInvestments();
        driver.findElement(By.xpath("//*[@index='1']")).click();
        driver.findElement(AppiumBy.accessibilityId("Terminate")).click();
    }

    public void verifyFixedIncomePage(){
        utils.delay(5);
        utils.containsText("Total Investment Amount");
        utils.containsText("Total Cash Amount");
        utils.containsText("My Investments");
        utils.isTextPresent("Fixed Income");

    }



}
