package pages.BottomNav.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class AccountSettingsPage {

    Utils utils;

    private By genderdropdown = AppiumBy.xpath("(//*[@class='android.widget.Button'])[1]");

    private By maritalstatusdropdown = AppiumBy.xpath("(//*[@class='android.widget.Button'])[2]");

    private By lgaTextField = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[1]");

    private By homeAddressTextField = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[2]");

    private By stateOfResidenceTextField = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[3]");

    private By cityTextField = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[4]");

    private By zipTextField = AppiumBy.xpath("(//*[@class='android.widget.EditText'])[5]");



    private AppiumDriver driver;

    public AccountSettingsPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }


    public void updatePersonalData(String gender, String maritalStatus, String motherMaidenName){
        driver.findElement(AppiumBy.accessibilityId("Personal Data")).click();
        driver.findElement(genderdropdown).click();
        switch (gender){
            case "Male":
                driver.findElement(AppiumBy.accessibilityId("Male")).click();
                break;
            case "Female":
                driver.findElement(AppiumBy.accessibilityId("Female")).click();
                break;
        }
        driver.findElement(maritalstatusdropdown).click();
        driver.findElement(AppiumBy.accessibilityId(maritalStatus)).click();

        WebElement mothermaiden = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
        mothermaiden.click();
        mothermaiden.sendKeys(motherMaidenName);
        driver.findElement(AppiumBy.accessibilityId("Submit")).click();

        driver.findElement(AppiumBy.accessibilityId("Please wait ..."));
        utils.delay(10);

        driver.navigate().back();
        driver.navigate().back();

    }

    public void updateAddressInformation(String lga,
                                         String address,
                                         String residenceState,
                                         String city,
                                        String zip){
        driver.findElement(AppiumBy.accessibilityId("Address Information")).click();

        Utils.scroll(Utils.ScrollDirection.DOWN,0.6,null);
        driver.findElement(AppiumBy.accessibilityId("Submit")).click();
        driver.findElement(AppiumBy.accessibilityId("Please supply other details to proceed"));

        driver.findElement(AppiumBy.accessibilityId("Select Country")).click();
        utils.containsText("Nigeria").click();
        driver.findElement(AppiumBy.accessibilityId("Select State of Origin")).click();
        utils.containsText("Abia").click();

        WebElement lgaEle = driver.findElement(lgaTextField);
        lgaEle.click();
        lgaEle.sendKeys(lga);

        WebElement homeAddEle = driver.findElement(homeAddressTextField);
        homeAddEle.click();
        homeAddEle.sendKeys(address);

        driver.navigate().back();

        WebElement stateOfResEle = driver.findElement(stateOfResidenceTextField);
        stateOfResEle.click();
        stateOfResEle.sendKeys(residenceState);

        driver.navigate().back();


        WebElement cityEle = driver.findElement(cityTextField);
        cityEle.click();
        cityEle.sendKeys(city);

        driver.navigate().back();


        WebElement zipEle = driver.findElement(zipTextField);
        zipEle.click();
        zipEle.sendKeys(zip);

        driver.navigate().back();

        driver.findElement(AppiumBy.accessibilityId("Submit")).click();
        utils.delay(5);
    }


}
