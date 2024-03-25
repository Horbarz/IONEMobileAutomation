package pages.BottomNav;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import pages.Home.FixedIncomePage;
import pages.Home.StockTradingPage;

public class InvestmentsPage {
    private AppiumDriver driver;


    public InvestmentsPage(AppiumDriver driver){
        this.driver = driver;
    }

    public FixedIncomePage openFixedIncomePage(){
//        FlutterFinder flutterFinder = new FlutterFinder(driver);
//        FlutterElement fixed_income_element = flutterFinder.byValueKey("Fixed Income");
        driver.findElement(AppiumBy.accessibilityId("")).click();
        return new FixedIncomePage(driver);
    }


    public StockTradingPage openStockTradingPage(){
        driver.findElement(AppiumBy.accessibilityId("Stock Trading\n" +
                "Trade stocks seamlessly")).click();
        return new StockTradingPage(driver);
    }

}
