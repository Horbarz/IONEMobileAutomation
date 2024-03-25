package pages.BottomNav.Profile.PersonalAccount;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class PersonalAccountPage {

    private AppiumDriver driver;

    public PersonalAccountPage(AppiumDriver driver){
        this.driver = driver;
    }

    public BankAccountsPage registerBankAccount(){
        WebElement bankAccountsPage = driver.findElement(AppiumBy.accessibilityId("Bank Accounts"));
        bankAccountsPage.click();
        return new BankAccountsPage(driver);
    }

    public CardsPage addRemoveCards(){
        WebElement cardsPage = driver.findElement(AppiumBy.accessibilityId("Bank Accounts"));
        cardsPage.click();
        return new CardsPage(driver);
    }

}
