package pages.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.Utils;

import java.util.List;

public class DataPage {

    private AppiumDriver driver;

    public DataPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void buyData(String biller, String phoneNumber) throws InterruptedException {
        Utils utils = new Utils(driver);

        Thread.sleep(10000);
        driver.findElement(AppiumBy.accessibilityId("Select Network Provider\n" +
                "Select Network Provider")).click();

        switch (biller){
            case "9mobile":
                driver.findElement(AppiumBy.accessibilityId("9mobile Data Bundles")).click();
                break;
            case "airtel":
                driver.findElement(AppiumBy.accessibilityId("Airtel Prepaid Data Bundle ")).click();
                break;
            case "glo":
                driver.findElement(AppiumBy.accessibilityId("GLO Data Bundle")).click();
                break;
            case "mtn":
                driver.findElement(AppiumBy.accessibilityId("MTN Mobile Data Plan")).click();
                break;
        }

        Thread.sleep(10000);
        driver.findElement(AppiumBy.accessibilityId("Select Data Plan\n" +
                "Select Data Plan")).click();

        driver.findElement(AppiumBy.accessibilityId("100MB   1day (N100)")).click();

        WebElement proceedBtn = driver.findElement(AppiumBy.accessibilityId("Proceed"));
        proceedBtn.click();

        driver.findElement(AppiumBy.accessibilityId("Please supply required inputs"));

        WebElement phoneNumberField = driver.findElement(AppiumBy.xpath("//*[@text='Phone Number']"));
        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);

        driver.navigate().back();

        proceedBtn.click();

        driver.findElement(AppiumBy.accessibilityId("Pay ₦100.00")).click();

        WebElement pinBox = driver.findElement(AppiumBy.xpath("//*[@text='|']"));
        pinBox.click();
        pinBox.sendKeys("1");
        System.out.println(1);
        Thread.sleep(2000);
        utils.tapOnCoordinates(276,1078);
        System.out.println(2);
        Thread.sleep(2000);
        utils.tapOnCoordinates(458,1078);
        System.out.println(3);
        Thread.sleep(2000);
        utils.tapOnCoordinates(103,1202);
        System.out.println(4);
        Thread.sleep(2000);
        utils.tapOnCoordinates(278,1193);
        System.out.println(5);
        Thread.sleep(2000);
        utils.tapOnCoordinates(454,1198);
        System.out.println(6);
        Thread.sleep(10000);
    }
}
