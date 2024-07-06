package pages.BottomNav.Profile.PersonalAccount;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreatePersonalAccount {

    private AppiumDriver driver;

    private By AccountNumber = AppiumBy.xpath("//*[@class='android.widget.EditText']");

    public CreatePersonalAccount(AppiumDriver driver){
        this.driver = driver;
    }

    public void registerAccount(String acc_num){
        WebElement selectBankDropdown = driver.findElement(AppiumBy.accessibilityId("Select bank\n" +
                "Select bank"));
        selectBankDropdown.click();
        driver.findElement(AppiumBy.accessibilityId("Access Bank")).click();
        WebElement accountNumber = driver.findElement(AccountNumber);
        accountNumber.click();
        accountNumber.sendKeys(acc_num);
        WebElement addBankBtn = driver.findElement(AppiumBy.accessibilityId("Add Bank"));
        addBankBtn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
