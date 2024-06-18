package pages.CreateAccount;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Utils;

import java.util.Random;

public class CreateAccountPage {

    private AppiumDriver driver;

    Utils utils;

    private By firstnameField = By.xpath("//*[@text='First name']");

    private By firstnameIndex = By.xpath("//*[@index='7']");

    private By middlenameIndex = By.xpath("//*[@index='10']");
    private By lastnameField = By.xpath("//*[@text='Last name']");

    private By lastnameIndex = By.xpath("//*[@index='13']");
    private By emailField = By.xpath("//*[@text='Email address']");

    private By emailIndex= By.xpath("//*[@index='15']");
    private By phoneField = By.xpath("//*[@index='17']");
    private By createAccountBtn = By.xpath("//*[@content-desc='Create Account']");

    public CreateAccountPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);

    }

    public VerifyTokenPage enterNewUserInfo(String firstname, String middlename, String lastname, String email){
        Random rnd  = new Random();
        int phnNumber = rnd.nextInt(99999999);
        String phoneNum = String.format("%08d",phnNumber);
        String phoneNumber = "080"+phoneNum;

        WebElement firstnameDriver = driver.findElement(firstnameIndex);
        firstnameDriver.click();
        firstnameDriver.sendKeys(firstname);

        WebElement middlenameDriver = driver.findElement(middlenameIndex);
        middlenameDriver.click();
        middlenameDriver.sendKeys(middlename);

        WebElement lastnameDriver = driver.findElement(lastnameIndex);
        lastnameDriver.click();
        lastnameDriver.sendKeys(lastname);

        WebElement emailDriver = driver.findElement(emailIndex);
        emailDriver.click();
        emailDriver.sendKeys(email);

        driver.navigate().back();

        WebElement phoneDriver = driver.findElement(phoneField);
        phoneDriver.click();
        phoneDriver.sendKeys(phoneNumber);

        driver.navigate().back();
        driver.findElement(AppiumBy.xpath("(//*[contains(@content-desc,'Create Account')])[2]")).click();

        //Send verification code
        utils.delay(10);

        return new VerifyTokenPage(driver);
    }

    public VerifyTokenPage clickCreateAccountBtn(){
        driver.navigate().back();
        driver.findElement(createAccountBtn).click();
        return new VerifyTokenPage(driver);
    }

}
