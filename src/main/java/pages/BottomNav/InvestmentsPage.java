package pages.BottomNav;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import pages.Home.FixedIncomePage;
import pages.Home.StockTradingPage;
import pages.Utils;

public class InvestmentsPage {
    private AppiumDriver driver;

    Utils utils;


    public InvestmentsPage(AppiumDriver driver){

        this.driver = driver;

        utils = new Utils(driver);
    }

    public FixedIncomePage openFixedIncomePage(){
        utils.containsText("Fixed Income").click();
        return new FixedIncomePage(driver);
    }


    public StockTradingPage openStockTradingPage(){
        driver.findElement(AppiumBy.accessibilityId("Stock Trading\n" +
                "Trade stocks seamlessly")).click();
        return new StockTradingPage(driver);
    }

}
