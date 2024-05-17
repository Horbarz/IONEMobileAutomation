package pages.BottomNav.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class PasswordSecurityPage {

    private AppiumDriver driver;

    private By oldPasswordInput = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[1]");

    private By newPasswordInput = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[2]");

    private By confirmPasswordInput = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[3]");

    private By securityQAInputBox = AppiumBy.xpath("(//*[@class='android.widget.CheckBox'])[1]");

    private By emailVerificationBox = AppiumBy.xpath("(//*[@class='android.widget.CheckBox'])[2]");

    private By editButton = AppiumBy.xpath("//*[@class='android.widget.Button']");

    Utils utils;

    public PasswordSecurityPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void changePassword(String oldPassword, String password){
        driver.findElement(AppiumBy.accessibilityId("Change Password")).click();
        utils.isTextPresent("Update password to strengthen security");

        driver.findElement(AppiumBy.accessibilityId("Update")).click();
        utils.isTextPresent("Fields can not be empty");

        WebElement oldPasswordElement = driver.findElement(oldPasswordInput);
        oldPasswordElement.click();
        oldPasswordElement.sendKeys(oldPassword);

        WebElement passwordElement = driver.findElement(newPasswordInput);
        passwordElement.click();
        passwordElement.sendKeys(password);

        WebElement confirmPasswordElement = driver.findElement(confirmPasswordInput);
        confirmPasswordElement.click();
        confirmPasswordElement.sendKeys(password);

        driver.findElement(AppiumBy.accessibilityId("Update")).click();
    }


    public void twoFactorAuthentication(boolean QnA, boolean email){
        driver.findElement(AppiumBy.accessibilityId("2 Factor Authentication")).click();
        utils.isTextPresent("Select your preferred form of authentication for transactions on the app");
        driver.findElement(editButton).click();

        if(QnA){
            driver.findElement(securityQAInputBox).click();
        }else if(email){
            driver.findElement(emailVerificationBox).click();
        }

        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();

    }

    public void securityQA(String ans){
        driver.findElement(AppiumBy.accessibilityId("Security Q & A")).click();
        utils.isTextPresent("Security Q & A");
        utils.isTextPresent("Security Questions and Answer");
        driver.findElement(AppiumBy.accessibilityId("Security Question\n" +
                "Security Question")).click();
        driver.findElement(AppiumBy.accessibilityId("Name of favourite pet")).click();
        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
    }

    public void toogleBiometrics(){
        driver.findElement(AppiumBy.accessibilityId("Biometrics")).click();
        utils.isTextPresent("Set  biometrics");
        utils.isTextPresent("Enable Biometrics for login");
        driver.findElement(AppiumBy.xpath("//*[@class='android.widget.Switch']")).click();
    }

}
