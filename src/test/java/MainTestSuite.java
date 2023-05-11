import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BottomNav.ProfilePage;
import pages.DashboardPage;
import pages.Home.StockTradingPage;
import pages.LoginPage;
import pages.StockTrading.*;
import setup.BaseClass;
import static org.testng.Assert.*;

public class MainTestSuite extends BaseClass {


//    public DashboardPage CreateNewAccountTest(){
//        homePage.skipSplashPage();
//        LoginPage loginPage = homePage.clickLoginBtn();
//    }
    public DashboardPage LoginTest(){
        homePage.skipSplashPage();
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterLoginDetails("12487", "P@ssword2");
        homePage.goBack();
        DashboardPage dashboardPage = loginPage.loginToDashboard();
        test.log(Status.PASS,"Login Test case passed");
        return dashboardPage;
    }

    @Test
    public LoginPage logout(){
        DashboardPage dashboardPage = LoginTest();
        ProfilePage profilePage = dashboardPage.openProfilePage();
        LoginPage logout = profilePage.logout();
        test.log(Status.PASS, "Logout test passed");
        return logout;
    }

    @Test
    public void FundStockAccountTest(){
        DashboardPage dashboardPage = LoginTest();
        StockTradingPage stocks = dashboardPage.openStockTradingPage();
        DepositMoneyPage deposit = stocks.openDepositMoneyPage();
        WalletFundingPage fundStocksWithWallet = deposit.fundStockByWallet("5000.00");
        fundStocksWithWallet.confirmPayment();
        homePage.goBack();
        DepositMoneyPage depositByCard = stocks.openDepositMoneyPage();
        CardFundingPage fundStockWithCard = depositByCard.fundStockByCard("1000.00");
        String textMessage = fundStockWithCard.completePayment();
        //System.out.println("notification message: "+textMessage);
        assertEquals(textMessage,"Funding Successful", "Wrong text");
        fundStockWithCard.clickDone();
    }

    @Test
    public void WithdrawFromStockAccountTest(){
        DashboardPage dashboardPage = LoginTest();
        StockTradingPage stocks = dashboardPage.openStockTradingPage();
        WithdrawFundPage withdrawFundPage = stocks.openWithdrawMoneyPage();
        ConfirmTransactionPage confirm = withdrawFundPage.withdrawFundsToWallet("1000.00");
        confirm.enterTransactionPin("123456");
        confirm.clickConfirmTransactionButton();
        test.log(Status.PASS, "Withdrawal Testcase Passed");
    }






}
