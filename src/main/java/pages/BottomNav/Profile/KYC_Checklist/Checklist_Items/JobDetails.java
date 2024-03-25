package pages.BottomNav.Profile.KYC_Checklist.Checklist_Items;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JobDetails {

    private AppiumDriver driver;

    private By nationalityIndex = AppiumBy.xpath("//*[@index='3']");

    private By countryIndex = AppiumBy.xpath("//*[@index='0']");

    private By nameOfEmployerIndex = AppiumBy.xpath("//*[@index='4']");

    private By addressOfEmployerIndex = AppiumBy.xpath("//*[@index='5']");

    private By stateIndex = AppiumBy.xpath("//*[@index='6']");

    private By selectState = AppiumBy.xpath("//*[@content-desc='Abia']");

    private By proceedBtn = AppiumBy.accessibilityId("Proceed");

    private By cityIndex = AppiumBy.xpath("//*[@index='7']");

    private By zipCodeIndex = AppiumBy.xpath("//*[@index='8']");



    public JobDetails(AppiumDriver driver){
        this.driver = driver;
    }

    public void UpdateJobDetails(String nameOfEmployer,
                                 String addressEmployer,
                                 String city,
                                 String zipCode){

        WebElement nationalityElement = driver.findElement(nationalityIndex);
        nationalityElement.click();
        WebElement selectCountry = driver.findElement(countryIndex);
        selectCountry.click();

        WebElement nameOfEmployerElement = driver.findElement(nameOfEmployerIndex);
        nameOfEmployerElement.click();
        nameOfEmployerElement.sendKeys(nameOfEmployer);

        WebElement addressOfEmployerElement = driver.findElement(addressOfEmployerIndex);
        addressOfEmployerElement.click();
        addressOfEmployerElement.sendKeys(addressEmployer);

        WebElement stateElement = driver.findElement(stateIndex);
        stateElement.click();
        driver.findElement(selectState).click();

        WebElement cityElement = driver.findElement(cityIndex);
        cityElement.click();
        cityElement.sendKeys(city);

        WebElement zipcodeElement = driver.findElement(zipCodeIndex);
        zipcodeElement.click();
        zipcodeElement.sendKeys(zipCode);

        driver.findElement(proceedBtn).click();
    }




}
