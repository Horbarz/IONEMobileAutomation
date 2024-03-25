package pages.BottomNav.Profile.KYC_Checklist;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.BottomNav.Profile.KYC_Checklist.Checklist_Items.JobDetails;
import pages.BottomNav.Profile.KYC_Checklist.Checklist_Items.NextOfKin;
import pages.BottomNav.Profile.KYC_Checklist.Checklist_Items.POR;

public class KycPage {

    private AppiumDriver driver;

    public KycPage(AppiumDriver driver){
        this.driver = driver;
    }

    public JobDetails openJobDetailsPage(){
        WebElement jobdetailsPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Job Details"));
        return new JobDetails(driver);
    }

    public NextOfKin openNokPage(){
        WebElement nokPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Next of Kin Information"));
        return new NextOfKin(driver);
    }

    public POR openPORPage(){
        WebElement nokPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Proof of Residence"));
        return new POR(driver);
    }






}
