package pages.BottomNav.Profile.KYC_Checklist.Checklist_Items;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.Utils;

public class POR {

    private AppiumDriver driver;

    Utils utils;

    private By file = AppiumBy.xpath("(//*[@class='android.widget.ImageView'])[6]");


    public POR(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void uploadPORDocument(){
        utils.containsText("Select files").click();
        utils.containsText("Browse Files").click();
        driver.findElement(file).click();
        driver.findElement(AppiumBy.accessibilityId("Upload")).click();

        utils.isTextPresent("Uploading...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        utils.isTextPresent("KYC Checklist");
        utils.isTextPresent("Kindly complete pending items on the list");


    }


}
