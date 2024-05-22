package pages.BottomNav.Profile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.Utils;

public class PrivacyPolicyPage {

    private AppiumDriver driver;

    Utils utils;

    public PrivacyPolicyPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void navigatePrivacyPage(){
        utils.delay(10);
    }
}
