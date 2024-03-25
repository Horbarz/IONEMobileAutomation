package pages.BottomNav.Profile.PersonalAccount;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class BankAccountsPage {

    private AppiumDriver driver;

    public BankAccountsPage(AppiumDriver driver){
        this.driver = driver;
    }

    public CreatePersonalAccount addPersonalAccount(){
        WebElement clickAddPersonalAccount = driver.findElement(AppiumBy.accessibilityId("Add Personal Account\n" +
                "Register your personal account"));
        clickAddPersonalAccount.click();
        return new CreatePersonalAccount(driver);
    }




}
