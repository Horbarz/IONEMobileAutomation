package pages.BottomNav.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class LinkSwitchAccountPage {

    private AppiumDriver driver;

    private By customerNumText = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[1]");

    private By passwordNumText = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[2]");


    Utils utils;

    public LinkSwitchAccountPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void linkAccount(String customerID, String password){
        utils.isTextPresent("Select account to switch account");
        WebElement btnEle = driver.findElement(By.xpath("//*[@class='android.widget.Button']"));
        btnEle.click();

        WebElement linkAcctBtn = driver.findElement(AppiumBy.accessibilityId("Link Account"));

        driver.findElement(AppiumBy.accessibilityId("Link Account")).click();

        WebElement customerNumEle = driver.findElement(customerNumText);
        WebElement passwordEle = driver.findElement(passwordNumText);

        customerNumEle.click();
        customerNumEle.sendKeys("129");
        linkAcctBtn.click();

        passwordEle.click();
        passwordEle.sendKeys(password);
        linkAcctBtn.click();

        utils.isTextPresent("Linking ...");
        utils.delay(11);

        customerNumEle.click();
        customerNumEle.clear();
        customerNumEle.sendKeys(customerID);
        linkAcctBtn.click();

        utils.isTextPresent("Linking ...");

        utils.delay(6);

        utils.containsText("Email Address");
        utils.containsText("Name");
        utils.containsText(customerID);
        utils.containsText("Customer Number");

    }

    public void switchAccount(String customerID, String password){
        utils.isTextPresent("Provide password to switch account");
        utils.containsText(customerID).click();
        WebElement switchBtnEle = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Switch Account']"));
        WebElement passwordEle = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));

        switchBtnEle.click();
        utils.isTextPresent("Password field is required");

        passwordEle.click();
        passwordEle.sendKeys(password);

        switchBtnEle.click();

        utils.isTextPresent("Switching ...");

        utils.delay(7);

        utils.isTextPresent("Portfolio Balance");



    }


}
