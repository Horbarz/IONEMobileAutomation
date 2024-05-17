package pages.BottomNav.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class EditProfilePage {

    private AppiumDriver driver;

    Utils utils;

    private By middleNameInput = AppiumBy.xpath("//*[@index='5']");

    private By backBtn = AppiumBy.xpath("//*[@index='0']");

    public EditProfilePage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void enterProfileInfo(String middleName){
        utils.isTextPresent("Manage Profile");
        utils.isTextPresent("First Name");
        utils.isTextPresent("Middle Name (optional)");
        utils.isTextPresent("Last Name");
        utils.isTextPresent("Email Address");
        utils.isTextPresent("Phone Number");

        WebElement middleNameEle = driver.findElement(middleNameInput);
        middleNameEle.clear();
        middleNameEle.sendKeys(middleName);

        driver.findElement(AppiumBy.accessibilityId("Update")).click();
        utils.isTextPresent("Please wait ...");

        System.out.println(middleNameEle.getText());

        if(middleName.equals(middleNameEle.getText())){
            System.out.println("Success");
        }

    }
}
