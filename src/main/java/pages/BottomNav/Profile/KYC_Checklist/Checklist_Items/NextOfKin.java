package pages.BottomNav.Profile.KYC_Checklist.Checklist_Items;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NextOfKin {

    private AppiumDriver driver;

    private By fullNameIndex = AppiumBy.xpath("//*[@index='3']");
    private By relationshipIndex = AppiumBy.xpath("//*[@index='4']");
    private By addressIndex = AppiumBy.xpath("//*[@index='7']");
    private By cityIndex = AppiumBy.xpath("//*[@index='8']");
    private By countrySelectIndex = AppiumBy.xpath("//*[@index='9']");
    private By countryIndex = AppiumBy.xpath("//*[@index='0']");
    private By stateSelectIndex = AppiumBy.xpath("//*[@index='10']");
    private By stateIndex = AppiumBy.xpath("//*[@content-desc='Abia']");



    public NextOfKin(AppiumDriver driver){
        this.driver = driver;
    }

    public void UpdateNOKDetails(String fullName,
                                 String relationship,
                                 String address,
                                 String city,
                                 String country,
                                 String state,
                                 String zip){

        WebElement nameElement = driver.findElement(fullNameIndex);
        nameElement.click();
        nameElement.sendKeys(fullName);

        WebElement relationshipElement = driver.findElement(relationshipIndex);
        relationshipElement.click();
        relationshipElement.sendKeys(relationship);

        WebElement addressElement = driver.findElement(addressIndex);
        addressElement.click();
        addressElement.sendKeys(address);

        WebElement cityElement = driver.findElement(cityIndex);
        cityElement.click();
        cityElement.sendKeys(city);

        WebElement countryElement = driver.findElement(countrySelectIndex);
        countryElement.sendKeys();

        driver.findElement(countryIndex).click();

        driver.findElement(stateSelectIndex).click();
        driver.findElement(stateIndex).click();

//        WebElement zipCodeElement = driver.findElement()

    }
}
