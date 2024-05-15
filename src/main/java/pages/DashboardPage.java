package pages;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BottomNav.InvestmentsPage;
import pages.BottomNav.Profile.ProfilePage;
import pages.BottomNav.TransactionsPage;
import pages.Home.*;

import java.time.Duration;

public class DashboardPage {

    private AppiumDriver driver;

    Utils utils;

    public DashboardPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public FixedIncomePage openFixedIncomePage(){
        WebElement fixedIncomeEle = driver.findElement(AppiumBy.accessibilityId("Fixed Service Box\n" +
                "Fixed Income"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(fixedIncomeEle));
        fixedIncomeEle.click();
        return new FixedIncomePage(driver);
    }

    public StockTradingPage openStockTradingPage(){
        driver.findElement(AppiumBy.accessibilityId("Stock Service Box\n" +
                "Stock Trading")).click();
        return new StockTradingPage(driver);
    }

    public SavingsPage openSavingsPage(){
//        driver.findElement(AppiumBy.xpath("//*[@content-desc='Savings Service Box\n" +
//                "Savings']")).click();
                //driver.findElement(AppiumBy.accessibilityId("Savings")).click();
//        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Savings Service Box\n" +
//                "Savings\"]"));
        driver.findElement(By.xpath("//*[contains(@content-desc,'Savings')]")).click();
        return new SavingsPage(driver);
    }

    public AirtimePage openAirtimePage(){
        driver.findElement(AppiumBy.accessibilityId("Airtime Service Box\n" +
                "Airtime")).click();
        return new AirtimePage(driver);
    }

    public DataPage openDataPage(){
        driver.findElement(AppiumBy.accessibilityId("Data Service Box\n" +
                "Data")).click();
        return new DataPage(driver);
    }

    public BillsPaymentPage openBillsPaymentPage(){
        driver.findElement(AppiumBy.accessibilityId("Bills Service Box\n" +
                "Bills Payment")).click();
        return new BillsPaymentPage(driver);
    }

    public InvestmentsPage openInvestments(){
        driver.findElement(AppiumBy.accessibilityId("Investments")).click();
        return new InvestmentsPage(driver);
    }

    public TransactionsPage openTransactions(){
        driver.findElement(AppiumBy.accessibilityId("Transactions")).click();
        return new TransactionsPage(driver);
    }

    public ProfilePage openProfilePage(){
        driver.findElement(AppiumBy.accessibilityId("Profile")).click();
        return new ProfilePage(driver);
    }

    public VirtualAccountPage openVirtualPage(){
        driver.findElement(AppiumBy.accessibilityId("9977641971\n" +
                "Providus Bank")).click();
        return new VirtualAccountPage(driver);
    }

    public SavingsPage swipeToOpenSavingsPage(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utils utils = new Utils(driver);
        WebElement horizontalScroll = driver.findElement(AppiumBy.accessibilityId("Portfolio Balance\n" +
                "XXXXX.XX"));
        utils.scroll(Utils.ScrollDirection.LEFT,0.5, horizontalScroll);
        utils.scroll(Utils.ScrollDirection.LEFT,0.5, horizontalScroll);
        utils.scroll(Utils.ScrollDirection.LEFT,0.5, horizontalScroll);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Savings details\n" +
                "Savings Balance\n" +
                "XXXXX.XX\"]/android.view.View")).click();
        return new SavingsPage(driver);
    }






}
