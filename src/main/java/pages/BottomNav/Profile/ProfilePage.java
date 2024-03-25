package pages.BottomNav.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import pages.BottomNav.Profile.KYC_Checklist.KycPage;
import pages.BottomNav.Profile.PersonalAccount.PersonalAccountPage;
import pages.LoginPage;

public class ProfilePage {
    private AppiumDriver driver;

    public ProfilePage(AppiumDriver driver){
        this.driver = driver;
    }

    public LoginPage logout(){
        WebElement logOutBtn = driver.findElement(AppiumBy.accessibilityId("Log Out"));
        logOutBtn.click();
        return new LoginPage(driver);
    }

    public PersonalAccountPage personalAccountPage(){
        WebElement personalAccBtn = driver.findElement(AppiumBy.accessibilityId("Personal Accounts"));
        personalAccBtn.click();
        return new PersonalAccountPage(driver);
    }

    public KycPage kycPage(){
        WebElement kycChecklistBtn = driver.findElement(AppiumBy.accessibilityId("KYC Checklist"));
        kycChecklistBtn.click();
        return new KycPage(driver);
    }

    public PasswordSecurityPage passwordSecurityPage(){
        WebElement passwordSecBtn = driver.findElement(AppiumBy.accessibilityId("Password & Security"));
        passwordSecBtn.click();
        return new PasswordSecurityPage(driver);
    }

    public AccountSettingsPage accountSettingsPage(){
        WebElement accSettingsBtn = driver.findElement(AppiumBy.accessibilityId("Account Settings"));
        accSettingsBtn.click();
        return new AccountSettingsPage(driver);
    }

    public LinkSwitchAccountPage linkSwitchAccountPage(){
        WebElement linkSwitchBtn = driver.findElement(AppiumBy.accessibilityId("Link / Switch Account"));
        linkSwitchBtn.click();
        return new LinkSwitchAccountPage(driver);
    }

    public HelpCenterPage helpCenterPage(){
        WebElement helpCenterBtn = driver.findElement(AppiumBy.accessibilityId("Help Center"));
        helpCenterBtn.click();
        return new HelpCenterPage(driver);
    }

    public TermsConditionsPage termsConditionsPage(){
        WebElement tandcBtn = driver.findElement(AppiumBy.accessibilityId("Terms & Condition"));
        tandcBtn.click();
        return new TermsConditionsPage(driver);
    }

    public PrivacyPolicyPage privacyPolicyPage(){
        WebElement privacypolicyBtn = driver.findElement(MobileBy.AccessibilityId("Privacy Policy"));
        privacypolicyBtn.click();
        return new PrivacyPolicyPage(driver);
    }



}
