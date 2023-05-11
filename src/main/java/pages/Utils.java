package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public boolean isTextPresent(String text){
        try{
            driver.findElement(MobileBy.AccessibilityId(text));
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void goBack(){
        driver.navigate().back();
    }
}
