package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CreateAccount.CreateAccountPage;

public class LoginPage {

    private AppiumDriver driver;

    private By usernameField = By.xpath("//*[@index='4']");

    private By passwordField = By.xpath("//*[@index='6']");

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
    }


    public void enterLoginDetails(String username, String password){
        WebElement usernameDriver = driver.findElement(usernameField);
        usernameDriver.click();
        usernameDriver.sendKeys(username);
        driver.navigate().back();
        WebElement passwordDriver = driver.findElement(passwordField);
        passwordDriver.click();
        passwordDriver.sendKeys(password);
        driver.navigate().back();
    }

    public void allowNotifications(){
        //driver.findElement(AppiumBy.accessibilityId("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(AppiumBy.xpath("//*[@class='android.widget.Button'][1]")).click();
    }

    public DashboardPage loginToDashboard(String name, String password){
        WebElement newError = null;
        driver.findElement(AppiumBy.accessibilityId("Login")).click();
        WebElement errorMessage = driver.findElement(AppiumBy.accessibilityId("Please fill all empty fields"));
        while(errorMessage!=null){
            enterLoginDetails(name,password);
            try {
                driver.findElement(AppiumBy.accessibilityId("Login")).click();
            }catch(Exception e){
                driver.navigate().back();
                driver.findElement(AppiumBy.accessibilityId("Login")).click();
            }
            errorMessage = newError;
        }
        return new DashboardPage(driver);
    }


    public CreateAccountPage createNewAccount(){
        driver.findElement(AppiumBy.accessibilityId("Create Account")).click();
        return new CreateAccountPage(driver);
    }


}
