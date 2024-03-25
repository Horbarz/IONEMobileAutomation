package pages.CreateAccount;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class VerifyTokenPage {

    private AppiumDriver driver;

    public VerifyTokenPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void enterOTP(String otp){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utils utils = new Utils(driver);
        WebElement otpEle = driver.findElement(AppiumBy.xpath("//*[@index='4']"));
        Dimension sizeOtp = otpEle.getSize();
        Point midPoint = new Point((int) (sizeOtp.width * 0.5), (int) (sizeOtp.height * 0.5)); // get the midpoint of the screen
        int left = midPoint.x - (int) (midPoint.x * 0.2);
        Utils.tapOnElement(otpEle);
    }
}
