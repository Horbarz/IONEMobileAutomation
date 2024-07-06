package pages.CreateAccount;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Utils;

import java.time.Duration;

public class CreatePassword {

    private AppiumDriver driver;

    Utils utils;

    By password_one = By.xpath("(//*[@class='android.widget.EditText'])[1]");
    By confirm_password = By.xpath("(//*[@class='android.widget.EditText'])[2]");

    By checkBox = By.xpath("//*[@class='android.widget.CheckBox']");

    By createPaswordBtn = By.xpath("(//*[@content-desc='Create Password'])[3]");

    public CreatePassword(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void enterPassword(String password){
        driver.findElement(createPaswordBtn).click();
        utils.isTextPresent("Please fill empty fields");
        driver.findElement(password_one).click();
        driver.findElement(password_one).sendKeys(password);
        driver.findElement(confirm_password).click();
        driver.findElement(confirm_password).sendKeys(password);
        driver.findElement(checkBox).click();
        driver.findElement(createPaswordBtn).click();
        utils.isTextPresent("Creating account...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(utils.containsText("Registration Successful")));
    }
}
