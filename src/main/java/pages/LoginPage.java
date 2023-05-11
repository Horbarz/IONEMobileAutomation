package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CreateAccount.CreateAccountPage;

public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.xpath("//*[@index='4']");

    private By passwordField = By.xpath("//*[@index='6']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void enterLoginDetails(String username, String password){
        WebElement usernameDriver = driver.findElement(usernameField);
        usernameDriver.click();
        usernameDriver.sendKeys(username);
        WebElement passwordDriver = driver.findElement(passwordField);
        passwordDriver.click();
        passwordDriver.sendKeys(password);

    }

    public DashboardPage loginToDashboard(){
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UIScrollable(new UiSelector().scrollable(true).instance(0))"
//                + ".scrollIntoView(new UiSelector()"+ ".textMatches(\""+"Login"+"\").instance(0)"));
        driver.findElement(MobileBy.AccessibilityId("Login")).click();
        return new DashboardPage(driver);
    }

    public CreateAccountPage createNewAccount(){
        driver.findElement(MobileBy.AccessibilityId("Create Account")).click();
        return new CreateAccountPage(driver);
    }


}
