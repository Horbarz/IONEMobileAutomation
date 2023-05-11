package pages.StockTrading;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardFundingPage {

    private WebDriver driver;

    private By visaCard = By.xpath("//android.widget.ImageView[@content-desc=\"***\"]");


    public CardFundingPage(WebDriver driver){
        this.driver = driver;
    }

    public String completePayment(){
        driver.findElement(visaCard).click();
        String message = driver.findElement(MobileBy.AccessibilityId("Funding Successful")).getAttribute("content-desc");
        return message;
    }

    public void clickDone(){
        driver.findElement(MobileBy.AccessibilityId("Done"));
    }

}
