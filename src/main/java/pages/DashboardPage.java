package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import pages.BottomNav.InvestmentsPage;
import pages.BottomNav.ProfilePage;
import pages.BottomNav.TransactionsPage;
import pages.Home.FixedIncomePage;
import pages.Home.SavingsPage;
import pages.Home.StockTradingPage;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver){

        this.driver = driver;
    }

    public FixedIncomePage openFixedIncomePage(){
        driver.findElement(MobileBy.AccessibilityId("Fixed Income")).click();
        return new FixedIncomePage(driver);
    }

    public StockTradingPage openStockTradingPage(){
        driver.findElement(MobileBy.AccessibilityId("Stock Trading")).click();
        return new StockTradingPage(driver);
    }

    public SavingsPage openSavingsPage(){
        driver.findElement(MobileBy.AccessibilityId("Savings")).click();
        return new SavingsPage(driver);
    }

    public InvestmentsPage openInvestments(){
        driver.findElement(MobileBy.AccessibilityId("Investments")).click();
        return new InvestmentsPage(driver);
    }

    public TransactionsPage openTransactions(){
        driver.findElement(MobileBy.AccessibilityId("Transactions")).click();
        return new TransactionsPage(driver);
    }

    public ProfilePage openProfilePage(){
        driver.findElement(MobileBy.AccessibilityId("Profile")).click();
        return new ProfilePage(driver);
    }




}
