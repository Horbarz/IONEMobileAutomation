package setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.*;
import pages.HomePage;
import report.ExtentManger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static AppiumDriver driver;
    public static HomePage homePage;

    public static ExtentManger extentManger;

    public static ExtentReports extentReports;
    public static ExtentTest test;

    @BeforeTest
    public static void setup(){
        try {
            DesiredCapabilities cap = new DesiredCapabilities();

            String platform = "android";
            if(platform.equalsIgnoreCase("android")){
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy A03s");
                cap.setCapability(MobileCapabilityType.UDID,"R9HR80HYTEJ");
                cap.setCapability("app","/Users/horbarz/Downloads/InvestmentOneMobileApps/phoenixuat.apk");
                cap.setCapability("appPackage","com.investment.one.phoenix");
                cap.setCapability("appActivity", "com.investment.one.phoenix.MainActivity");
            }else if(platform.equalsIgnoreCase("ios")) {
                cap.setCapability("platformName", "iOS");
                cap.setCapability("deviceName", "iPhone 8");
                cap.setCapability("platformVersion", "14.5");
                //cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
                //cap.setCapability("app", "/Users/horbarz/Downloads/InvestmentOneMobileApps/");
            }
            goHome(cap);


        }catch (Exception e){
            System.out.println("Cause is: "+ e.getCause());
            System.out.println("Message is: "+e.getMessage());
            e.printStackTrace();
        }
        extentReports = extentManger.createReportInstance("IONEApp");
        test = extentReports.createTest("IONE Tests", "Investment One Mobile app test report.");
    }


    public static void goHome(DesiredCapabilities cap) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        homePage = new HomePage(driver);

    }

    public void sampleTest(){
        System.out.println("Mobile Automation started");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getTestName());
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
    }

    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
        extentReports.flush();
    }
}
