package pages.BottomNav.Profile.KYC_Checklist.Checklist_Items;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class NIN {

    private AppiumDriver driver;

    private By ninField = By.xpath("//*[@class='android.widget.EditText']");

    Utils utils;

    public NIN(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void enterNinDetails(String nin){
        utils.isTextPresent("Kindly fill in your national identification number");
        utils.isTextPresent("National Identification Number");
        utils.isTextPresent("To get your NIN, text *346# ");

        WebElement submitBtn = driver.findElement(AppiumBy.accessibilityId("Submit"));
        WebElement ninInput = driver.findElement(ninField);


        submitBtn.click();
        utils.isTextPresent("Please supply your nin");
        ninInput.click();
        ninInput.sendKeys("12910");
        utils.isTextPresent("Invalid NIN, should have 11 digits");
        ninInput.click();
        ninInput.sendKeys(nin);
        submitBtn.click();
        utils.isTextPresent("Submitting NIN...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        driver.navigate().back();
//        driver.navigate().back();
//
//        utils.isTextPresent("KYC Checklist");
//        utils.isTextPresent("Kindly complete pending items on the list");
    }
}
