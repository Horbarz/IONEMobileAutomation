package pages.Home;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.Utils;

import java.text.DecimalFormat;

public class BillsPaymentPage {

    private AppiumDriver driver;
    public BillsPaymentPage(AppiumDriver driver){
        this.driver = driver;
    }


    public void purchaseElectricity(String amount, String electricityNumber) throws InterruptedException {
        Utils utils = new Utils(driver);
        Thread.sleep(10000);
        driver.findElement(AppiumBy.accessibilityId("Select Category\n" +
                "Select Category")).click();

        driver.findElement(AppiumBy.accessibilityId("Utilities")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Select Biller\n" +
                "Select Biller")).click();
        driver.findElement(AppiumBy.accessibilityId("Eko Electricity Distribution Company Plc Prepaid")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Select biller item\n" +
                "Select biller item")).click();
        driver.findElement(AppiumBy.accessibilityId("Prepaid")).click();
        WebElement amountText = driver.findElement(AppiumBy.xpath("//*[@text='0, Amount']"));
        amountText.click();
        amountText.sendKeys(amount);
        WebElement customerIdField = driver.findElement(AppiumBy.xpath("//*[@index='7']"));
        customerIdField.click();
        customerIdField.sendKeys(electricityNumber);

        driver.navigate().back();

        driver.findElement(AppiumBy.accessibilityId("Proceed")).click();

        Thread.sleep(5000);

        double amt = Double.parseDouble(amount)+100;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        System.out.println(formatter.format(amt));
        driver.findElement(AppiumBy.accessibilityId("Pay ₦"+String.valueOf(formatter.format(amt)))).click();

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
