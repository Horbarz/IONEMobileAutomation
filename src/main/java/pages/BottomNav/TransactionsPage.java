package pages.BottomNav;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TransactionsPage {

    private AppiumDriver driver;

    public TransactionsPage(AppiumDriver driver){
        this.driver = driver;
    }

    public boolean verifyTransactionAmount(String amount){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDateTime now = LocalDateTime.now();
        var todaysDate = dtf.format(now);
        System.out.println(todaysDate);
        var transactionEle = driver.findElement(AppiumBy.xpath("//*[@class='android.widget.ImageView'][1]"));
        String transactionText = transactionEle.getAttribute("content-desc");
        System.out.println(transactionText);

        if(transactionText.contains(amount) && transactionText.contains(todaysDate)){
            return true;
        }
        return false;
    }


}
