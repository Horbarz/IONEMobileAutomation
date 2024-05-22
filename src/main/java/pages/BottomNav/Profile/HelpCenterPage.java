package pages.BottomNav.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Utils;

public class HelpCenterPage {

    private AppiumDriver driver;

    Utils utils;

    public HelpCenterPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void viewFAQs(){
        driver.findElement(AppiumBy.accessibilityId("Frequently Asked Questions")).click();
        utils.delay(5);
        Utils.scroll(Utils.ScrollDirection.DOWN,0.5,null);
        utils.isTextPresent("Deposits");
        utils.isTextPresent("Fixed Income");
        utils.isTextPresent("General");
        utils.isTextPresent("KYC Verification");
        utils.isTextPresent("Stock Trading");
        utils.isTextPresent("WINSAVE");
        utils.isTextPresent("Withdrawals");
        utils.isTextPresent("zPlan");
        utils.isTextPresent("zSave");

        utils.containsText("Deposits").click();
        utils.delay(5);
        utils.isTextPresent("How do I deposit money?");
        utils.isTextPresent("What happens when there’s no money in my bank account for automated funding?");
        utils.containsText("How do I").click();
        driver.navigate().back();

        utils.containsText("Fixed Income").click();
        utils.delay(5);
        Utils.scroll(Utils.ScrollDirection.DOWN,0.5,null);
        utils.isTextPresent("What is the minimum amount investible?");
        utils.isTextPresent("What is the minimum time frame for an investment?");
        utils.isTextPresent("What happens upon the maturity of an investment?");
        utils.isTextPresent("Can I have multiple fixed income investments?");
        utils.isTextPresent("Can I top-up an existing fixed income investment?");
        utils.isTextPresent("Are there any charges?");
        utils.isTextPresent("Are there any charges when withdrawing my matured investment?");
        utils.isTextPresent("How can I fund my Fixed Income investment?");
        utils.isTextPresent("What happens if I need to liquidate a fixed income investment before maturity?");
        utils.containsText("What is the minimum amount investible?").click();
        driver.navigate().back();

        utils.containsText("General").click();
        utils.delay(5);
        utils.isTextPresent("What is the Investment One App (I-One app)?");
        utils.isTextPresent("Who is Investment One?");
        utils.isTextPresent("How is the Investment One App different from other digital platforms?");
        utils.isTextPresent("Why should I choose the Investment One App?");
        utils.isTextPresent("How long does it take to register?");
        utils.isTextPresent("What exactly can I do on the Investment One App?");
        utils.isTextPresent("What do I need to create an account?");
        utils.isTextPresent("I’m already an Investment One customer. Do I need to register again?");
        utils.isTextPresent("Is my money safe?");
        Utils.scroll(Utils.ScrollDirection.DOWN,0.7,null);
        utils.isTextPresent("How do I earn interest on zSave and zPLan?");
        utils.isTextPresent("How do I earn interest on Fixed Income?");
        utils.isTextPresent("Are there any charges?");
        utils.isTextPresent("I have submitted my document, but my account is restricted, why?");
        utils.isTextPresent("Why do I need to provide my BVN?");
        utils.isTextPresent("Why do I need to submit additional documents?");
        utils.isTextPresent("Can I use the Investment One App on more than one device?");
        utils.isTextPresent("What devices are compatible?");
        utils.containsText("Why do I need to provide my BVN?").click();
        utils.containsText("We require your BVN as part of a wider AML/CFT");
        driver.navigate().back();

        utils.containsText("KYC Verification").click();
        utils.delay(5);
        utils.isTextPresent("What documents am I to upload?");
        utils.isTextPresent("How long does verification take?");
        utils.containsText("How long does verification take?").click();
        utils.containsText("All documents uploaded on the Investment One app are verified within 24 hours");
        driver.navigate().back();

        utils.containsText("Stock Trading").click();
        utils.delay(5);
        Utils.scroll(Utils.ScrollDirection.DOWN,0.7,null);
        utils.isTextPresent("How do I signup to begin trading?");
        utils.isTextPresent("How long does the account opening take?");
        utils.isTextPresent("Who is my stockbroking account domiciled with?");
        utils.isTextPresent("What kind of investor can invest in the stock market?");
        utils.isTextPresent("Is my investment guaranteed?");
        utils.isTextPresent("Do I get evidence of my ownership of shares on the Investment One App?");
        utils.isTextPresent("Can I cancel a trade?");
        utils.isTextPresent("Can I withdraw immediately after a sale?");
        utils.isTextPresent("How do I receive dividends on my shares?");
        utils.isTextPresent("Are there any charges when I buy and sell stocks on the I-One App?");
        utils.containsText("Can I cancel a trade?").click();
        utils.containsText("es. However, trades can only be cancelled from 4pm to 7am on working days");
        driver.navigate().back();

        utils.containsText("WINSAVE").click();
        utils.delay(5);
        utils.containsText("WINSAVE Rules").click();
        utils.containsText("Terms and Conditions of Winning");
        driver.navigate().back();

        utils.containsText("Withdrawals").click();
        utils.delay(5);
        utils.isTextPresent("How do I withdraw money?");
        utils.isTextPresent("Can I transfer money between accounts?");
        utils.isTextPresent("How long do withdrawals take?");
        utils.isTextPresent("What happens if I need my money before the maturity period?");
        utils.isTextPresent("What happens upon maturity?");
        utils.isTextPresent("Are there any withdrawal charges?");
        utils.isTextPresent("Can I transfer money to someone else on the Investment One App? In-app Transfers.");
        utils.containsText("What happens upon maturity?").click();
        utils.containsText("Upon maturity of a goal in your zPlan account");
        driver.navigate().back();

        utils.containsText("zPlan").click();
        utils.delay(5);
        utils.isTextPresent("What is the minimum amount investible?");
        utils.isTextPresent("What is the minimum tenure for a plan?");
        utils.isTextPresent("What is the interest rate on zPlan?");
        utils.isTextPresent("What happens upon the expiration or maturity of a plan?");
        utils.isTextPresent("Can I setup multiple plans?");
        utils.isTextPresent("What happens when I pause a plan?");
        utils.isTextPresent("Are there any charges on Plan at maturity?");
        utils.isTextPresent("How can I fund my plans?");
        utils.isTextPresent("Can I terminate a plan before maturity?");
        utils.containsText("Can I setup multiple plans?").click();
        utils.containsText("You can have multiple plans running at the same time");
        driver.navigate().back();

        Utils.scroll(Utils.ScrollDirection.DOWN,0.7,null);
        utils.containsText("zSave").click();
        utils.isTextPresent("What is the minimum amount I can fund my zSave with?");
        utils.isTextPresent("Is there a minimum time frame for deposits to be accessible?");
        utils.isTextPresent("Are there any penalties incurred using the zSave?");
        utils.isTextPresent("What is the interest rate on the zSave account?");
        utils.isTextPresent("What can I do from my zSave Account?");
        utils.isTextPresent("Are there any charges?");
        utils.containsText("Are there any charges?").click();
        utils.containsText("Utility bills payments and transfer services attract their customary charges");
        driver.navigate().back();
        driver.navigate().back();
    }

    public void contactUs(String message){
        driver.findElement(AppiumBy.accessibilityId("Contact Us")).click();
        utils.isTextPresent("37 Kofo Abayomi, Victoria Island, Lagos, Nigeria");
        utils.isTextPresent("Email");
        utils.isTextPresent("Phone");
        utils.isTextPresent("Twitter");
        utils.isTextPresent("Instagram");
        utils.isTextPresent("Linkedin");
        utils.isTextPresent("Website");

        utils.delay(5);
        driver.findElement(AppiumBy.accessibilityId("Enquiry Type\n" +
                "Enquiry Type")).click();
        driver.findElement(AppiumBy.accessibilityId("General Comment")).click();

        WebElement sendMssgBtn = driver.findElement(AppiumBy.accessibilityId("Send Message"));
        sendMssgBtn.click();

        utils.isTextPresent("Message must be greater than 10 characters");

        WebElement messageEle = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
        messageEle.click();
        messageEle.sendKeys(message);

        sendMssgBtn.click();

        utils.isTextPresent("Sending request...");

        utils.delay(10);

    }


}
