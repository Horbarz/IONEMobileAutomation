package pages.CreateAccount;

import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import pages.Utils;
import com.mailosaur.MailosaurClient;
import pages.TestData;

import java.io.IOException;

public class VerifyTokenPage {

    private AppiumDriver driver;

    Utils utils;

    public VerifyTokenPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public String retrieveOtp(String emailAddress)throws IOException, MailosaurException {
        TestData testData = new TestData();
        MailosaurClient mailosaur = new MailosaurClient(testData.apiKey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(testData.serverId);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(emailAddress);
        Message message = mailosaur.messages().get(params, criteria);
        System.out.println("Subject: "+message.subject());
        String code = message.text().codes().get(0).value();
        System.out.println("Code: "+code);
        return code;
    }

    public CreatePassword enterOTP(String email){

        driver.findElement(By.xpath("(//*[contains(@content-desc,'Verify Email')])[1]"));
        utils.containsText("We sent a 6 digit code");
        utils.delay(5);

        try {
            String otp = retrieveOtp(email);
            char [] ch = otp.toCharArray();
            Utils.tapOnCoordinates(96,816);
            utils.delay(2);
            for(int i=0; i<ch.length;i++){
                System.out.println(ch[i]);
                utils.enterOTP(ch[i]);
                utils.delay(2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MailosaurException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("(//*[contains(@content-desc,'Verify Email')])[2]")).click();
        utils.isTextPresent("Verifying email...");

        return new CreatePassword(driver);
    }
}
