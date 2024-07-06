package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CreateAccount.CreateAccountPage;

public class HomePage {
    TestData testData = new TestData();
    private AppiumDriver driver;

    private By splashSwipeButton = AppiumBy.xpath("//*[@index='4']");

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
        if(testData.deviceName.equalsIgnoreCase("Ione Device")){
            WebElement swipeBtn = driver.findElement(splashSwipeButton);
            for(int i=0; i<3; i++){
                swipeBtn.click();
            }
        }else{
            WebElement skip = driver.findElement(AppiumBy.accessibilityId("Skip >>"));
            skip.click();
        }

    }

    public void goBack(){
        driver.navigate().back();
    }

    public void ignoreAppUpdate(){
        driver.findElement(AppiumBy.accessibilityId("LATER")).click();
    }
}
