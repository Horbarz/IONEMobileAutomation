package pages.StockTrading;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.Home.StockTradingPage;

public class CardFundingPage {

    private AppiumDriver driver;

    private By visaCard = By.xpath("//android.widget.ImageView[@content-desc=\"***\"]");


    public CardFundingPage(AppiumDriver driver){
        this.driver = driver;
    }

    public String completePayment(){
        driver.findElement(visaCard).click();
        String message = driver.findElement(AppiumBy.accessibilityId("Funding Successful")).getAttribute("content-desc");
        return message;
    }

    public StockTradingPage clickDone(){
        driver.findElement(AppiumBy.accessibilityId("Done")).click();
        return new StockTradingPage(driver);
    }


}
