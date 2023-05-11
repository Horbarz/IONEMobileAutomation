package setup;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserTest extends BaseClass{

    @Test
    public void testOne(){
//        driver.get("https://google.com");
//        driver.findElement(By.name("q")).sendKeys("Automation Testing");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]"));
        WebElement skip = driver.findElement(MobileBy.AccessibilityId("Skip >>"));
        skip.click();

        System.out.println("Test completed");

    }
}
