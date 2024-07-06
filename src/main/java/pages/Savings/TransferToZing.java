package pages.Savings;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferToZing {

    private AppiumDriver driver;

    WebElement beneficiaryMail = driver.findElement(By.xpath("//*[@index='1']"));
    WebElement nickName = driver.findElement(By.xpath("//*[@index='2']"));

    public TransferToZing(AppiumDriver driver){

    }

    public void AddToBeneficiary(){

    }
}
