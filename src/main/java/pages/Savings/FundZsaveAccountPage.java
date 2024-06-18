package pages.Savings;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Home.SavingsPage;
import pages.Utils;

import java.math.BigDecimal;

public class FundZsaveAccountPage {

    private AppiumDriver driver;

    Utils utils;


    SavingsPage savingsPage;

    public FundZsaveAccountPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
        savingsPage = new SavingsPage(driver);
    }



    public void fundAccount(String amount, long currentAccountBal){
        System.out.println("Current Balance: "+currentAccountBal);
        WebElement amountInputElement = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));

        utils.containsText("Card Funding").click();

        utils.isTextPresent("Amount cannot be empty");

        amountInputElement.click();
        amountInputElement.sendKeys("100.00");

        utils.containsText("Card Funding").click();

        utils.isTextPresent("Minimum funding amount is ₦ 1000");

        amountInputElement.click();
        amountInputElement.clear();
        amountInputElement.sendKeys(amount);

        utils.containsText("Card Funding").click();

        utils.delay(5);
        try{
            utils.containsText("***").click();
        }catch (Exception e){

        }

        utils.isTextPresent("Processing ...");

        utils.delay(10);
        utils.isTextPresent("Funding Successful");
        utils.isTextPresent("Product");
        utils.isTextPresent("Convenience Fee");
        utils.isTextPresent("Total Amount");
        utils.isTextPresent("Transaction Date");

        utils.containsText("Done").click();

        Utils.scroll(Utils.ScrollDirection.UP,0.9,null);

        utils.delay(10);

        var actualBal = savingsPage.returnBalance();


        utils.delay(2);

        var amountInDouble = Double.valueOf(amount);
        BigDecimal currentBalDec = BigDecimal.valueOf(currentAccountBal).movePointLeft(2);
        var proposedBal = currentBalDec.doubleValue() + amountInDouble;

        BigDecimal actualBalance = BigDecimal.valueOf(actualBal).movePointLeft(2);
        var actualAccountBalance = actualBalance.doubleValue();

        System.out.println("New Balance: "+actualAccountBalance);
        System.out.println("Proposed Bal: "+proposedBal);

        if(proposedBal==actualAccountBalance){
            Utils.scroll(Utils.ScrollDirection.DOWN,0.9,null);
            viewSavingsTransactions();
        }
    }

    public void viewSavingsTransactions(){
        utils.containsText("Funds Deposit").click();
        utils.isTextPresent("TRANSACTION DETAILS");
        utils.isTextPresent("SUCCESS");
        utils.isTextPresent("Amount:");
        utils.isTextPresent("Reference:");
        utils.isTextPresent("Narration:");
        utils.isTextPresent(utils.getTodaysDate());
        utils.containsText("Done").click();
        System.out.println("Transactions viewed");
    }


}
