package pages.BottomNav.Profile.PersonalAccount;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class CardsPage {

    private AppiumDriver driver;

    public CardsPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void addNewCard(){
        WebElement newCardBtn = driver.findElement(MobileBy.AccessibilityId("New Card\n" +
                "Add a new card"));

        newCardBtn.click();
        WebElement fundZsave = driver.findElement(MobileBy.AccessibilityId("Add ₦100 to Wallet"));
        fundZsave.click();
        WebElement successDebit = driver.findElement(By.xpath("//android.widget.TextView[@text='Success']"));
        successDebit.click();
        WebElement paymentBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Pay NGN 100']"));
        paymentBtn.click();
    }

    public void removeCard(){
        Utils utils = new Utils(driver);

        if(utils.isTextPresent("***")){
            driver.findElement(MobileBy.AccessibilityId("***")).click();
            WebElement removeCardBtn = driver.findElement(MobileBy.AccessibilityId("Remove Card"));
            removeCardBtn.click();

        }else{

        }
    }
}
