package pages.BottomNav.Profile.KYC_Checklist.Checklist_Items;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class BVN {

    private AppiumDriver driver;

    Utils utils;

    private By bvnField = By.xpath("//*[@class='android.widget.EditText']");

    public BVN(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void enterBVNDetails(String bvn, String year, String date){
        WebElement submitBtn = driver.findElement(AppiumBy.accessibilityId("Submit"));
        WebElement bvnInput = driver.findElement(bvnField);
        WebElement dobInput = driver.findElement(AppiumBy.accessibilityId("Date of Birth"));

        submitBtn.click();
        utils.isTextPresent("Please supply your bvn");
        bvnInput.click();
        bvnInput.sendKeys("12019");
        utils.isTextPresent("Invalid BVN, should have 11 digits");
        bvnInput.click();
        bvnInput.sendKeys(bvn);
        dobInput.click();
        utils.selectCalendarDate(year, date, true);
        submitBtn.click();
        utils.isTextPresent("Validating BVN...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//
//            driver.navigate().back();
//            driver.navigate().back();
//
//            utils.isTextPresent("KYC Checklist");
//            utils.isTextPresent("Kindly complete pending items on the list");
        }


}
