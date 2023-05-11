package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManger {

    static ExtentSparkReporter extentSparkReporter;
    static ExtentReports extentReports;
    static SimpleDateFormat simpleDate = new SimpleDateFormat("dd MM yyyy");

    public static ExtentReports createReportInstance(String reportFilePath){
        Date currentDate = new Date();
        String formattedDate = simpleDate.format(currentDate);
        extentSparkReporter = new ExtentSparkReporter("/Users/horbarz/Documents/MobileAutomationTestReport/"+formattedDate+reportFilePath+".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);


        extentSparkReporter.config().setDocumentTitle("Investment One Mobile Automation Report - "+formattedDate);
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        return extentReports;
    }
}
