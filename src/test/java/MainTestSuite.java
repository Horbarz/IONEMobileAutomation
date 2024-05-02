import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.BottomNav.InvestmentsPage;
import pages.BottomNav.Profile.ProfilePage;
import pages.CreateAccount.CreateAccountPage;
import pages.DashboardPage;
import pages.Home.*;
import pages.LoginPage;
import pages.Savings.FundsTransferPage;
import pages.StockTrading.*;
import setup.BaseClass;

import java.io.IOException;

import static org.testng.Assert.*;

public class MainTestSuite extends BaseClass {


    @Test
    public void CreateNewAccountTest(){
        homePage.skipSplashPage();
        CreateAccountPage createAccountPage = homePage.clickCreateAccountBtn();
        var verifyEmail = createAccountPage.enterNewUserInfo(
                "Jacob",
                "Great",
                "Paul", "jacobpaul@yopmail.com");

        verifyEmail.enterOTP("12019");
    }
    @Test
    public DashboardPage LoginTest(){
        homePage.skipSplashPage();
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.allowNotifications();
        DashboardPage dashboardPage = loginPage.loginToDashboard("12487", "P@55w0rd524");
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
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        DepositMoneyPage deposit = stocks.openDepositMoneyPage();
        WalletFundingPage fundStocksWithWallet = deposit.fundStockByWallet("2000.00");
        fundStocksWithWallet.confirmPayment();
    }

    @Test
    public void fundStockAccountWithCard(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        DepositMoneyPage depositByCard = stocks.openDepositMoneyPage();
        CardFundingPage fundStockWithCard = depositByCard.fundStockByCard("1000.00");
        String textMessage = fundStockWithCard.completePayment();
        assertEquals(textMessage,"Funding Successful", "Wrong text");
        var transactionDone = fundStockWithCard.clickDone();
        var backToDashboard = transactionDone.goToDashBoard();
        var openTransaction = backToDashboard.openTransactions();
        if(openTransaction.verifyTransactionAmount("₦1,000.00")){
            test.log(Status.PASS, "FundStock Testcase Passed");
        }else{
            test.log(Status.FAIL, "FundStock Testcase Failed");
        }

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


    @Test
    public void TradeStocks(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        TradeStocksPage tradeStocksPage = stocks.tradeStock();
        var stockResult = tradeStocksPage.searchStock("mori");
        var stockPurchase = stockResult.buyStock();
        //stockPurchase.SeeBids();
        var buyStock = stockPurchase.BuyStock("10");
        buyStock.enterTransactionPin("123456");
        //test.log(Status.PASS, "See Bids Page Opened Successfully");
    }


    @Test
    public void investFixedDeposit() throws IOException {
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        FixedIncomePage fixedIncomePage = investmentsPage.openFixedIncomePage();
        var fundingType = fixedIncomePage.selectInvestmentPlan();
        try {
            fundingType.CardFunding();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //fundingType.goBack();
        var fundwithstockbroking = fundingType.StockBroking();
        fundwithstockbroking.terminateInvestment();
    }


    @Test
    public void WithdrawFromSavingsTest(){
        DashboardPage dashboardPage = LoginTest();
        SavingsPage savings = dashboardPage.swipeToOpenSavingsPage();
//        FundsTransferPage fundsTransfer = savings.openTransferPage();
//        pages.Savings.WithdrawFundPage withdrawFundPage = fundsTransfer.openWithdrawToBank();
//        ConfirmTransactionPage confirm = withdrawFundPage.withdrawFundsToBank("1000.00");
//        confirm.enterTransactionPin("123456");
//        confirm.clickConfirmTransactionButton();
//        test.log(Status.PASS, "Withdrawal Testcase Passed");
    }


    @Test
    public void buyAirtime() throws InterruptedException {
        DashboardPage dashboardPage = LoginTest();
        AirtimePage airtimePage = dashboardPage.openAirtimePage();
        airtimePage.buyAirtime("100","mtn","08137210473");
    }


    @Test
    public void purchaseData() throws InterruptedException {
        DashboardPage dashboardPage = LoginTest();
        DataPage dataPage = dashboardPage.openDataPage();
        dataPage.buyData("mtn","08137219473");
    }


    @Test
    public void purchaseUtilities() throws InterruptedException {
        DashboardPage dashboardPage = LoginTest();
        BillsPaymentPage billsPaymentPage = dashboardPage.openBillsPaymentPage();
        billsPaymentPage.purchaseElectricity("1000", "12001220");
    }


    @Test
    public void virtualAccount(){
        DashboardPage dashboardPage = LoginTest();
        var virtualAccountPage = dashboardPage.openVirtualPage();
        virtualAccountPage.copyAccountNumber();
        virtualAccountPage.shareAccountNumber();
    }

    @Test
    public void addBankAccount(){
        DashboardPage dashboardPage = LoginTest();
        var profilePage = dashboardPage.openProfilePage();
        var personalAccounts = profilePage.personalAccountPage();
        var bankAccounts = personalAccounts.registerBankAccount();
        var addPersonalAccount = bankAccounts.addPersonalAccount();
        addPersonalAccount.registerAccount("1505857304");
    }






}
