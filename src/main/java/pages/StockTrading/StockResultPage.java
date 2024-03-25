package pages.StockTrading;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.StockTrading.WatchList.AddToWatchListPage;

public class StockResultPage {

    private AppiumDriver driver;

    private By heartIcon = By.xpath("//*[@index='1']");

    public StockResultPage(AppiumDriver driver){
        this.driver = driver;
    }


    public AddToWatchListPage clickHeartIcon(){
        driver.findElement(heartIcon).click();
        return new AddToWatchListPage(driver);
    }

    public StockPurchasePage buyStock(){
        driver.findElement(AppiumBy.accessibilityId("Buy")).click();
        return new StockPurchasePage(driver);
    }

    public StockPurchasePage sellStock(){
        driver.findElement(AppiumBy.accessibilityId("Sell")).click();
        return new StockPurchasePage(driver);
    }




}
