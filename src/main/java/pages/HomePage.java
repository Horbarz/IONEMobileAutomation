package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CreateAccount.CreateAccountPage;

public class HomePage {

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver){
        this.driver = driver;
    }


    public LoginPage clickLoginBtn(){
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("Login"));
        loginBtn.click();
        return new LoginPage(driver);
    }

    public CreateAccountPage clickCreateAccountBtn(){
        WebElement createAcctBtn = driver.findElement(AppiumBy.accessibilityId("Create Account"));
        createAcctBtn.click();
        return new CreateAccountPage(driver);
    }

    public void skipSplashPage(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement skip = driver.findElement(AppiumBy.accessibilityId("Skip >>"));
        skip.click();
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void ignoreAppUpdate(){
        driver.findElement(AppiumBy.accessibilityId("LATER")).click();
    }
}
