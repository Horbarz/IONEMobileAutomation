package pages.BottomNav.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import pages.BottomNav.Profile.KYC_Checklist.KycPage;
import pages.BottomNav.Profile.PersonalAccount.PersonalAccountPage;
import pages.LoginPage;
import pages.Utils;

public class ProfilePage {
    private AppiumDriver driver;

    Utils utils;

    public ProfilePage(AppiumDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void verifyUserInfo(String email, String firstname, String middleName, String lastName){
        utils.isTextPresent("User ID: "+email);
        utils.isTextPresent(email);
        utils.isTextPresent("Email:");
        utils.isTextPresent("Phone Number:");
        utils.isTextPresent("Account Officer:");
        utils.isTextPresent("Account Officer Email:");
        utils.isTextPresent(firstname+" "+middleName+" "+lastName);
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
        WebElement privacypolicyBtn = driver.findElement(AppiumBy.accessibilityId("Privacy Policy"));
        privacypolicyBtn.click();
        return new PrivacyPolicyPage(driver);
    }

    public EditProfilePage openEditProfilePage(){
        WebElement editProfileBtn = driver.findElement(AppiumBy.accessibilityId("Edit Profile"));
        editProfileBtn.click();
        return new EditProfilePage(driver);
    }



}
