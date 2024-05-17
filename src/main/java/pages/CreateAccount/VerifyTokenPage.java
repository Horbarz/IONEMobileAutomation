package pages.CreateAccount;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import pages.Utils;

public class VerifyTokenPage {

    private AppiumDriver driver;

    Utils utils;

    public VerifyTokenPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public CreatePassword enterOTP(String otp){

        driver.findElement(By.xpath("(//*[contains(@content-desc,'Verify Email')])[1]"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("(//*[contains(@content-desc,'Verify Email')])[2]")).click();
        utils.isTextPresent("Verifying email...");
//        Utils utils = new Utils(driver);
//        WebElement otpEle = driver.findElement(AppiumBy.xpath("//*[@index='4']"));
//        Dimension sizeOtp = otpEle.getSize();
//        Point midPoint = new Point((int) (sizeOtp.width * 0.5), (int) (sizeOtp.height * 0.5)); // get the midpoint of the screen
//        int left = midPoint.x - (int) (midPoint.x * 0.2);
//        Utils.tapOnElement(otpEle);

        return new CreatePassword(driver);
    }
}
