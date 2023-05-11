package pages.BottomNav;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage logout(){
        WebElement logOutBtn = driver.findElement(MobileBy.AccessibilityId("Log Out"));
        logOutBtn.click();
        return new LoginPage(driver);
    }
}
