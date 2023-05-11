package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage clickLoginBtn(){
        WebElement loginBtn = driver.findElement(MobileBy.AccessibilityId("Login"));
        loginBtn.click();
        return new LoginPage(driver);
    }

    public void skipSplashPage(){
        WebElement skip = driver.findElement(MobileBy.AccessibilityId("Skip >>"));
        skip.click();
    }

    public void goBack(){
        driver.navigate().back();
    }
}
