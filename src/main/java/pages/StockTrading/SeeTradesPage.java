package pages.StockTrading;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.Utils;

import java.io.IOException;

public class SeeTradesPage {

    AppiumDriver driver;

    private By openStockOne = By.xpath("//*[@index='0']");

    private By filteringOptions = By.xpath("//*[@index='2']");

    private By filteringOptionsOnOpenPage = By.xpath("//*[@elementId='00000000-0000-0298-0000-025d00000004']");

    Utils utils;

    public SeeTradesPage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }


    public void verifyTradedOrders() throws IOException {
        if(utils.isTextPresent("No traded order yet")){
           System.out.println("No orders");
        }else {
            if(utils.verifyElementPresent(openStockOne)){
                driver.findElement(openStockOne).click();
                driver.navigate().back();
            }
        }
    }

    public void verifyOpenPendingOrders() throws IOException {
        driver.findElement(filteringOptions).click();
        driver.findElement(AppiumBy.accessibilityId("Open/Pending Orders")).click();
        if(utils.isTextPresent("No open order yet")){
            System.out.println("No orders");
        }else {
            if(utils.verifyElementPresent(openStockOne)){
                driver.findElement(openStockOne).click();
                driver.navigate().back();
            }
        }
    }

    public void verifyCancelledOrders() throws IOException {
        driver.findElement(filteringOptionsOnOpenPage).click();
        driver.findElement(AppiumBy.accessibilityId("Cancelled Orders")).click();
        if(utils.isTextPresent("No cancelled order yet")){
            System.out.println("No orders");
        }else {
            if(utils.verifyElementPresent(openStockOne)){
                driver.findElement(openStockOne).click();
                driver.navigate().back();
            }
        }
    }

    public void verifyRejectedOrders() throws IOException {
        driver.findElement(filteringOptionsOnOpenPage).click();
        driver.findElement(AppiumBy.accessibilityId("Rejected Orders")).click();
        if(utils.isTextPresent("No rejected order yet")){
            System.out.println("No orders");
        }else {
            if(utils.verifyElementPresent(openStockOne)){
                driver.findElement(openStockOne).click();
                driver.navigate().back();
            }
        }
    }
}
