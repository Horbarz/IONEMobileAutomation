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

    private By amountField = AppiumBy.xpath("//*[@text='0.00, Amount']");



    public FixedIncomePage(AppiumDriver driver){
        this.driver = driver;
    }

    public FundingMethod selectInvestmentPlan() throws IOException {

        Utils utils = new Utils(driver);
        driver.findElement(AppiumBy.accessibilityId("Add New Investment")).click();
        utils.tapOnCoordinates(275,1075);
        WebElement amountEle = driver.findElement(amountField);
        utils.tapOnCoordinates(275,1075);
//        while(!(utils.verifyElementPresent(amountField))){
//            utils.tapOnCoordinates(275,1075);
//        }
        try{
            amountEle.click();
        }catch(org.openqa.selenium.NoSuchElementException e){
            utils.tapOnCoordinates(134,1092);
            amountEle.click();
        }
        amountEle.click();
        amountEle.sendKeys("50000000");
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Min Amount"));
        driver.findElement(AppiumBy.accessibilityId("Max Amount"));
        driver.findElement(AppiumBy.accessibilityId("Tenure"));
        driver.findElement(AppiumBy.accessibilityId("Rate per annum"));
        driver.findElement(AppiumBy.accessibilityId("Select")).click();
        driver.findElement(AppiumBy.accessibilityId("30")).click();
        Utils.scroll(Utils.ScrollDirection.DOWN, 0.75, null);
        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
        return new FundingMethod(driver);
    }

    public void viewAllFunding(){
        driver.findElement(AppiumBy.accessibilityId("View All")).click();
    }

    public void terminateInvestment(){
        driver.navigate().back();
        viewAllFunding();
        driver.findElement(By.xpath("//*[@index='1']")).click();
        driver.findElement(AppiumBy.accessibilityId("Terminate")).click();
    }



}
