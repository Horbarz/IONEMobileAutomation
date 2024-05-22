package pages.BottomNav.Profile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class AppAppearance {

    private AppiumDriver driver;

    Utils utils;


    public AppAppearance(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void toggleDarkMode(boolean data){
        boolean currentStatus;
        utils.isTextPresent("Switch to dark theme");
        utils.isTextPresent("Switch to dark mode");
        WebElement switchBtn = driver.findElement(By.xpath("//*[@class='android.widget.Switch']"));

        if(switchBtn.getAttribute("checked") == "true"){
            currentStatus = true;
        }else{
            currentStatus = false;
        }

        if(currentStatus != data){
            switchBtn.click();
        }

    }
}
