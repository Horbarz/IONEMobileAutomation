package pages.Home;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestData;
import pages.Utils;

import java.time.Duration;

public class AirtimePage {
    private AppiumDriver driver;

    TestData testData = new TestData();

    Utils utils;

    protected WebElement billerElement = null;
    public AirtimePage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void buyAirtime(String amount, String biller, String phoneNumber) throws InterruptedException {
        Utils utils = new Utils(driver);
        WebElement billerLogo =  driver.findElement(AppiumBy.xpath("//*[@class='android.widget.ImageView'][4]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(billerLogo));

        switch (biller){
            case "9mobile":
                billerElement = driver.findElement(AppiumBy.xpath("//*[@class='android.widget.ImageView'][1]"));
                billerElement.click();
            break;
            case "airtel":
                billerElement = driver.findElement(AppiumBy.xpath("//*[@class='android.widget.ImageView'][2]"));
                billerElement.click();
            break;
            case "glo":
                billerElement = driver.findElement(AppiumBy.xpath("//*[@class='android.widget.ImageView'][3]"));
                billerElement.click();
            break;
            case "mtn":
                billerElement = driver.findElement(AppiumBy.xpath("//*[@class='android.widget.ImageView'][4]"));
                billerElement.click();
            break;
        }

        WebElement amountField = driver.findElement(AppiumBy.xpath("(//*[@class='android.widget.EditText'])[1]"));
        amountField.click();
        amountField.sendKeys(amount);

        driver.navigate().back();

        WebElement proceedBtn = driver.findElement(AppiumBy.accessibilityId("Proceed"));
        proceedBtn.click();

        driver.findElement(AppiumBy.accessibilityId("Please supply required inputs"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(error_text));

        WebElement phoneNumberField = driver.
                findElement(AppiumBy.xpath("(//*[@class='android.widget.EditText'])[2]"));
        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);

        driver.navigate().back();

        proceedBtn.click();

        driver.findElement(AppiumBy.accessibilityId("Pay ₦"+amount+".00")).click();

        utils.enterTransactionPin("123456","bills", testData.deviceType);

//        WebElement pinBox = driver.findElement(AppiumBy.xpath("//*[@text='|']"));
//        pinBox.click();
//        pinBox.sendKeys("1");
//        System.out.println(1);
//        Thread.sleep(2000);
//        utils.tapOnCoordinates(276,1078);
//        System.out.println(2);
//        Thread.sleep(2000);
//        utils.tapOnCoordinates(458,1078);
//        System.out.println(3);
//        Thread.sleep(2000);
//        utils.tapOnCoordinates(103,1202);
//        System.out.println(4);
//        Thread.sleep(2000);
//        utils.tapOnCoordinates(278,1193);
//        System.out.println(5);
//        Thread.sleep(2000);
//        utils.tapOnCoordinates(454,1198);
//        System.out.println(6);
//        Thread.sleep(10000);
    }
}
