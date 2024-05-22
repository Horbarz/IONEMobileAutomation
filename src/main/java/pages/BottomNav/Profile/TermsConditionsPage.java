package pages.BottomNav.Profile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class TermsConditionsPage {

    private AppiumDriver driver;

    Utils utils;

    public TermsConditionsPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void navigateTandCPage(){
        utils.delay(15);
    }


}
