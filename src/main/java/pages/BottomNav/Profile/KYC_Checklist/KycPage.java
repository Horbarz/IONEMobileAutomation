package pages.BottomNav.Profile.KYC_Checklist;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.BottomNav.Profile.KYC_Checklist.Checklist_Items.*;
import pages.BottomNav.Profile.KYC_Checklist.Checklist_Items.MeansOfID.MeansOfID;
import pages.Utils;

public class KycPage {

    private AppiumDriver driver;

    Utils utils;

    public KycPage(AppiumDriver driver){

        this.driver = driver;
        utils = new Utils(driver);
    }

    public void verifyListPending(){
        utils.isTextPresent("KYC Checklist");
        utils.isTextPresent("Kindly complete pending items on the list");
    }

    public BVN openBVNPage(){
        WebElement bvnPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "BVN"));
        bvnPage.click();
        return new BVN(driver);
    }

    public NIN openNinPage(){
        WebElement ninPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "NIN"));
        ninPage.click();
        return new NIN(driver);
    }

    public JobDetails openJobDetailsPage(){
        WebElement jobdetailsPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Job Details"));
        jobdetailsPage.click();
        return new JobDetails(driver);
    }

    public NextOfKin openNokPage(){
        WebElement nokPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Next of Kin Information"));
        nokPage.click();
        return new NextOfKin(driver);
    }

    public POR openPORPage(){
        WebElement porPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Proof of Residence"));
        porPage.click();
        return new POR(driver);
    }

    public Passport openPassportPage(){
        WebElement passportPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Passport Photograph"));
        passportPage.click();
        return new Passport(driver);
    }

    public Signature openSignature(){
        WebElement signaturePage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Signature"));
        signaturePage.click();
        return new Signature(driver);
    }

    public MeansOfID openMeansOfID(){
        Utils.scroll(Utils.ScrollDirection.DOWN,0.8,null);
        WebElement meansOfIdPage = driver.findElement(AppiumBy.accessibilityId("Pending\n" +
                "Means of ID"));
        meansOfIdPage.click();
        return new MeansOfID(driver);
    }






}
