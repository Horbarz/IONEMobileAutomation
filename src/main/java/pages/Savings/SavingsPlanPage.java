package pages.Savings;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.Home.SavingsPage;
import pages.Utils;

public class SavingsPlanPage {

    private AppiumDriver driver;
    SavingsPage savingsPage;

    private By nameOfPlan = AppiumBy.xpath("//*[@index='3']");
    private By targetAmount = AppiumBy.xpath("//*[@index='5']");
    private By planDescription = AppiumBy.xpath("//*[@index='7']");

    private By switchLockPlan = AppiumBy.xpath("//*[@class='android.widget.Switch']");

    private By planDetailsHarmbugerMenu = AppiumBy.xpath("//*[@index='2']");

    private By topupAmountEle = AppiumBy.xpath("//*[@text='0.00']");

    Utils utils;


    public SavingsPlanPage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
        savingsPage = new SavingsPage(driver);
    }

    public void createNewPlan(String plan, String planAmount, boolean lockPlan){
        utils.isTextPresent("Create New Plan");
        utils.isTextPresent("Name of your plan");
        utils.isTextPresent("Target Amount");
        utils.delay(2);
        driver.findElement(nameOfPlan).click();
        driver.findElement(nameOfPlan).sendKeys(plan);
        utils.delay(2);
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Start Date")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        driver.findElement(AppiumBy.accessibilityId("End Date")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Frequency")).click();
        utils.containsText("Target amount");
        driver.findElement(targetAmount).click();
        driver.findElement(targetAmount).sendKeys(planAmount);
        utils.delay(1);
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Frequency")).click();
        utils.delay(3);
        utils.containsText("Daily").click();
        utils.delay(1);
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Select funding source\n" +
                "Select funding source")).click();
        driver.findElement(AppiumBy.accessibilityId("Wallet")).click();
        Utils.scroll(Utils.ScrollDirection.DOWN,0.75,null);
        utils.delay(2);
        driver.findElement(planDescription).click();
        driver.navigate().back();
        driver.findElement(planDescription).sendKeys("Automated PLAN Setup");
        driver.navigate().back();
        if(lockPlan){
            driver.findElement(switchLockPlan).click();
        }
        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();

        utils.isTextPresent(plan);
        if(!lockPlan){
            utils.isTextPresent("Not Locked");
        }else{
            utils.isTextPresent("Locked");
        }
        utils.isTextPresent("Wallet");
        utils.isTextPresent("Daily");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Create Plan']")).click();
        utils.isTextPresent("Creating plan, Please wait...");
        utils.delay(4);
        savingsPage.toggleBalance();
    }

    public void viewPlanDetails(String planName){
        Utils.scroll(Utils.ScrollDirection.UP,0.8,null);
        utils.delay(2);
        utils.containsText(planName).click();
        utils.isTextPresent("Plan Details");
        utils.isTextPresent(planName);
        utils.isTextPresent("Running");
        utils.isTextPresent("Target Amount");
        utils.isTextPresent("Interest rate");
        utils.isTextPresent("Start Date");
        utils.isTextPresent("Fund From");
        utils.isTextPresent("End Date");
        utils.isTextPresent("Current Principal");
        utils.isTextPresent("Frequency");
        utils.isTextPresent("Accrued Interest");
        utils.isTextPresent("31 days remaining");
        utils.isTextPresent("Top up");
        utils.isTextPresent("Terminate");
        utils.isTextPresent("History");

    }

    public void topupPlan(String planName, String topupAmount, String fundingMethod){
//        utils.containsText(planName).click();
        utils.isTextPresent("Plan Details");
        driver.findElement(AppiumBy.accessibilityId("Top up")).click();
        utils.isTextPresent("Fund Account for zplan");
        driver.findElement(topupAmountEle).click();
        driver.findElement(topupAmountEle).sendKeys(topupAmount);
        if(fundingMethod.equals("card")){
            driver.findElement(AppiumBy.accessibilityId("Card Funding\n" +
                    "Fund with your card")).click();
            driver.findElement(AppiumBy.accessibilityId("***")).click();
            utils.isTextPresent("Processing ...");
            utils.isTextPresent("Product");
            utils.isTextPresent("zplan");
            utils.isTextPresent("Amount");
            utils.isTextPresent("Total Amount");
            utils.isTextPresent("Transaction Date");
            driver.findElement(AppiumBy.accessibilityId("Done")).click();
            utils.containsText(planName).click();
            utils.delay(5);
            try{
                utils.containsText(planName+"\n" +
                        "₦"+topupAmount+"\n" );
            }catch (Exception e){
                driver.navigate().back();
                utils.containsText(planName).click();
                utils.containsText(planName+"\n" +
                        "₦"+topupAmount+"\n" );
            }

        }

    }

}
