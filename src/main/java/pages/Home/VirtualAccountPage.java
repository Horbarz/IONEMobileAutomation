package pages.Home;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class VirtualAccountPage {

    private AppiumDriver driver;

    public VirtualAccountPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void copyAccountNumber(){
        driver.findElement(AppiumBy.xpath("//*[@index='3']")).click();
    }

    public void shareAccountNumber(){
        driver.findElement(AppiumBy.xpath("//*[@index='5']")).click();
        driver.navigate().back();
    }

}
