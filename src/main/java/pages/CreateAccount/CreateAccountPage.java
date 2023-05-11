package pages.CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {

    private WebDriver driver;
    private By firstnameField = By.xpath("//*[@index='7']");
    private By lastnameField = By.xpath("//*[@index='10']");
    private By emailField = By.xpath("//*[@index='12']");
    private By phoneField = By.xpath("//*[@index='14']");
    private By createAccountBtn = By.xpath("//android.view.View[@content-desc=\"Create Account\"])[2]");

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterNewUserInfo(String firstname, String lastname, String email, String phoneNumber){
        WebElement firstnameDriver = driver.findElement(firstnameField);
        firstnameDriver.click();
        firstnameDriver.sendKeys(firstname);

        WebElement lastnameDriver = driver.findElement(lastnameField);
        lastnameDriver.click();
        lastnameDriver.sendKeys(lastname);

        WebElement emailDriver = driver.findElement(emailField);
        emailDriver.click();
        emailDriver.sendKeys(email);

        WebElement phoneDriver = driver.findElement(phoneField);
        phoneDriver.click();
        phoneDriver.sendKeys(phoneNumber);
    }

    public VerifyTokenPage clickCreateAccountBtn(){
        driver.findElement(createAccountBtn).click();
        return new VerifyTokenPage(driver);
    }



}
