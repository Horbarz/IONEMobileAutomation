package pages.BottomNav.Profile.KYC_Checklist.Checklist_Items;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

import java.util.Random;

public class NextOfKin {

    private AppiumDriver driver;

    Utils utils;

    private By fullNameIndex = AppiumBy.xpath("//*[@index='3']");
    private By relationshipIndex = AppiumBy.xpath("//*[@index='4']");

    private By phoneNumber = AppiumBy.xpath("//*[@index='6']");
    private By addressIndex = AppiumBy.xpath("//*[@index='7']");
    private By cityIndex = AppiumBy.xpath("//*[@index='8']");
    private By countrySelectIndex = AppiumBy.xpath("//*[@index='9']");
    private By stateSelectIndex = AppiumBy.xpath("//*[@index='10']");

    private By zipCode = AppiumBy.xpath("//*[@index='11']");

    private By proceedBtn = AppiumBy.accessibilityId("Proceed");


    public NextOfKin(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void UpdateNOKDetails(String fullName,
                                 String relationship,
                                 String address,
                                 String city,
                                 String zip){

        Random rnd  = new Random();
        int phnNumber = rnd.nextInt(99999999);
        String phoneNum = String.format("%08d",phnNumber);
        String phoneNo = "080"+phoneNum;

        utils.isTextPresent("Next of Kin");
        utils.isTextPresent("Provide the information below to create an investment portfolio");

        driver.findElement(proceedBtn).click();
        utils.isTextPresent("Please supply all fields");

        WebElement nameElement = driver.findElement(fullNameIndex);
        nameElement.click();
        nameElement.sendKeys(fullName);

        WebElement relationshipElement = driver.findElement(relationshipIndex);
        relationshipElement.click();
        relationshipElement.sendKeys(relationship);

        WebElement phoneElement = driver.findElement(phoneNumber);
        phoneElement.click();
        phoneElement.sendKeys(phoneNo);

        driver.navigate().back();

        WebElement addressElement = driver.findElement(addressIndex);
        addressElement.click();
        addressElement.sendKeys(address);

        driver.navigate().back();

        WebElement cityElement = driver.findElement(cityIndex);
        cityElement.click();
        cityElement.sendKeys(city);

        driver.navigate().back();

        WebElement countryElement = driver.findElement(countrySelectIndex);
        countryElement.click();
        utils.containsText("Nigeria").click();

        driver.navigate().back();

        driver.findElement(stateSelectIndex).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        utils.containsText("Abia").click();

        driver.navigate().back();

        WebElement zipcodeElement = driver.findElement(zipCode);
        zipcodeElement.click();
        zipcodeElement.sendKeys(zip);

        driver.navigate().back();
        driver.findElement(proceedBtn).click();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try{
            utils.isTextPresent("KYC Checklist");
            utils.isTextPresent("Kindly complete pending items on the list");
        }catch (Exception e){
            driver.navigate().back();
            utils.isTextPresent("KYC Checklist");
            utils.isTextPresent("Kindly complete pending items on the list");
        }



    }
}
