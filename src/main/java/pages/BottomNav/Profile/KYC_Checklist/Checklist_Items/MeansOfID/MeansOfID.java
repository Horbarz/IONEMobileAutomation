package pages.BottomNav.Profile.KYC_Checklist.Checklist_Items.MeansOfID;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class MeansOfID {

    private AppiumDriver driver;

    Utils utils;

    private By file = AppiumBy.xpath("(//*[@class='android.widget.ImageView'])[6]");


    private By documentNum = AppiumBy.xpath("//*[@class='android.widget.EditText']");

    private By expiryDateSelector = AppiumBy.xpath("//*[@index='8']");
    public MeansOfID(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void uploadMeansOfId(String documentId, String idType){
        if(idType.equals("voterscard")){
            driver.findElement(AppiumBy.accessibilityId("Voter's Card")).click();
        } else if (idType.equals("nin")) {
            driver.findElement(AppiumBy.accessibilityId("NIN Document")).click();
        }else if (idType.equals("international_passport")) {
            driver.findElement(AppiumBy.accessibilityId("International Passport")).click();
        }else if (idType.equals("drivers_licence")) {
            driver.findElement(AppiumBy.accessibilityId("Driver's License")).click();
        }

        utils.containsText("Select files").click();
        utils.containsText("Browse Files").click();
        driver.findElement(file).click();

        WebElement votersIdInput = driver.findElement(documentNum);
        votersIdInput.click();
        votersIdInput.sendKeys(documentId);

        driver.navigate().back();

        if(idType.equals("international_passport") || idType.equals("drivers_licence")){
            driver.findElement(expiryDateSelector).click();
            utils.selectCalendarDate("2028","22",false);

        }

        driver.navigate().back();


        driver.findElement(AppiumBy.accessibilityId("Upload")).click();

        utils.isTextPresent("Uploading...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(idType.equals("international_passport") || idType.equals("drivers_licence")){
            utils.isTextPresent("Upload Documents");
            utils.isTextPresent("Select your Means of ID to upload");
        }
        else {
            utils.isTextPresent("KYC Checklist");
            utils.isTextPresent("Kindly complete pending items on the list");
        }


    }

}
