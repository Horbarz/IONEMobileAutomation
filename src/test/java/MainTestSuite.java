import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.BottomNav.InvestmentsPage;
import pages.BottomNav.Profile.ProfilePage;
import pages.CreateAccount.CreateAccountPage;
import pages.DashboardPage;
import pages.Home.*;
import pages.LoginPage;
import pages.Savings.FundZsaveAccountPage;
import pages.Savings.FundsTransferPage;
import pages.StockTrading.*;
import pages.StockTrading.WatchList.AddToWatchListPage;
import pages.StockTrading.WatchList.WatchListPage;
import setup.BaseClass;

import pages.TestData;

import java.io.IOException;

import static org.testng.Assert.*;

public class MainTestSuite extends BaseClass {

    TestData data = new TestData();


    //****************************************Account Creation*************************************
    @Test
    public void CreateNewAccountTest(){
        homePage.skipSplashPage();
        CreateAccountPage createAccountPage = homePage.clickCreateAccountBtn();
        var verifyEmail = createAccountPage.enterNewUserInfo(
                data.firstName,
                data.middleName,
                data.lastName,
                data.email);

        var createPassword = verifyEmail.enterOTP("12019");
        createPassword.enterPassword(data.password);
    }

    public DashboardPage loginNewAccount(){
        homePage.skipSplashPage();
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.allowNotifications();
        DashboardPage dashboardPage = loginPage.loginToDashboard(data.email, data.password);
        return dashboardPage;
    }

    @Test
    public void UpdateBVN(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var kycChecklistPage = profilePage.kycPage();
        kycChecklistPage.verifyListPending();
        var bvnPage = kycChecklistPage.openBVNPage();
        bvnPage.enterBVNDetails(data.bvn,"1998","20");
    }

    @Test
    public void updateNIN(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var kycChecklistPage = profilePage.kycPage();
        kycChecklistPage.verifyListPending();
        var ninPage = kycChecklistPage.openNinPage();
        ninPage.enterNinDetails(data.nin);
    }

    @Test
    public void UpdateKYCItems(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        profilePage.verifyUserInfo(data.email,data.firstName,data.middleName,data.lastName);
        var kycChecklistPage = profilePage.kycPage();
        kycChecklistPage.verifyListPending();

        var jobDetailsPage = kycChecklistPage.openJobDetailsPage();
        jobDetailsPage.UpdateJobDetails(
            data.nameOfEmployer, data.addressEmployer, data.city,data.zipCode
        );

        var nextOfKinPage = kycChecklistPage.openNokPage();
        nextOfKinPage.UpdateNOKDetails(
                data.fullName,data.relationship,data.nokAddress,data.nokCity,data.zip
        );

        var porPage = kycChecklistPage.openPORPage();
        porPage.uploadPORDocument();

        var passportPage = kycChecklistPage.openPassportPage();
        passportPage.uploadPassportDocument();

        var signaturePage = kycChecklistPage.openSignature();
        signaturePage.uploadSignature();

        var meansOfIdPage = kycChecklistPage.openMeansOfID();
        meansOfIdPage.uploadMeansOfId(data.docId,data.meansOfIdType);
    }

    @Test
    public void updateUserProfile(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var editProfilePage = profilePage.openEditProfilePage();
        editProfilePage.enterProfileInfo(data.newMiddleName);
    }

    @Test
    public void updateAccountSettingsInfo(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var accountSettingsPage = profilePage.accountSettingsPage();
        accountSettingsPage.updatePersonalData(data.gender,data.maritalStatus,data.motherMaiden);
        accountSettingsPage.updateAddressInformation(data.lga,
                data.homeAddress,data.stateOfResidence,
                data.cityofResidence,data.residentZipCode);
    }

    @Test
    public void switchAccount(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var switchAccountPage = profilePage.linkSwitchAccountPage();
        switchAccountPage.linkAccount(data.productionUserId, data.productionPassword);
        switchAccountPage.switchAccount(data.productionUserId, data.productionPassword);
    }

    @Test
    public void darkMode(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var darkModePage = profilePage.openAppAppearancePage();
        darkModePage.toggleDarkMode(true);
    }

    @Test
    public void helpCenter(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var helpcenterPage = profilePage.helpCenterPage();
       // helpcenterPage.viewFAQs();
        helpcenterPage.contactUs(data.contactUsMessage);
    }

    @Test
    public void termsAndConditionsPage(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var tandcPage = profilePage.termsConditionsPage();
        tandcPage.navigateTandCPage();

    }

    @Test
    public void privacyPage(){
        var dashboardPage =  loginNewAccount();
        var profilePage = dashboardPage.openProfilePage();
        var privacyPage = profilePage.privacyPolicyPage();
        privacyPage.navigatePrivacyPage();
    }





    @Test
    public DashboardPage LoginTest(){
        homePage.skipSplashPage();
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.allowNotifications();
        DashboardPage dashboardPage = loginPage.loginToDashboard(data.productionUserId, data.productionPassword);
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

//*************************************Stock Broking***************************************
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
    public void BuyStocks(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        TradeStocksPage tradeStocksPage = stocks.tradeStock();
        var stockResult = tradeStocksPage.searchStock("ACCESSCORP");
        var stockPurchase = stockResult.buyStock();
        //stockPurchase.SeeBids();
        var buyStock = stockPurchase.BuyStock("10");
        buyStock.enterTransactionPin("123456");
        test.log(Status.PASS, "See Bids Page Opened Successfully");
    }

    @Test
    public void SellStocks(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        TradeStocksPage tradeStocksPage = stocks.tradeStock();
        var stockResult = tradeStocksPage.searchStock("ABBEYBDS");
        var stockPurchase = stockResult.sellStock();
        //stockPurchase.SeeBids();
        var sellStock = stockPurchase.SellStock("10");
        sellStock.enterTransactionPin("123456");
        test.log(Status.PASS, "See Bids Page Opened Successfully");
    }

    @Test
    public void SeeTrades() throws IOException {
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        SeeTradesPage seeTradesPage = stocks.seeTradesPage();
        seeTradesPage.verifyTradedOrders();
        seeTradesPage.verifyOpenPendingOrders();
        seeTradesPage.verifyCancelledOrders();
        seeTradesPage.verifyRejectedOrders();
    }

    @Test
    public void ViewMyStocks(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        MyStocksPage myStocksPage = stocks.openMyStocksPage();
        if(myStocksPage.verifyElementsOnPage()){
            test.log(Status.PASS, "My Stocks Portfolio page displays successfully");
        }
    }

    @Test
    public void viewAllWatchlist(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        WatchListPage watchListPage = stocks.openWatchListPage();

        if(watchListPage.verifyStocksAddedToWatchList("conoil")){
            watchListPage.removeStockFromWatchList();
            test.log(Status.PASS, "Stocks found in watchlist");
        }else {
            AddToWatchListPage addToWatchListPage = watchListPage.openAddToWatchListPage();
            if(addToWatchListPage.addStockToWatchlist("conoil", "7.0")){
                test.log(Status.PASS, "Stocks successfully added");
            }
        }
    }


//**************************************FIXED DEPOSIT************************************

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


//    **************************************Savings************************************
    @Test
    public void fundSavingsAccountTest(){
        DashboardPage dashboardPage = LoginTest();
        SavingsPage savings = dashboardPage.swipeToOpenSavingsPage();
        var accountBal = savings.returnBalance();
        FundZsaveAccountPage fundSavingsPage = savings.openFundAccountPage();
        fundSavingsPage.fundAccount(data.amountToFund,accountBal);
    }
    @Test
    public void WithdrawFromSavingsTest(){
        DashboardPage dashboardPage = LoginTest();
        SavingsPage savings = dashboardPage.swipeToOpenSavingsPage();
        FundsTransferPage fundsTransfer = savings.openTransferPage();
        pages.Savings.WithdrawFundPage withdrawFundPage = fundsTransfer.openWithdrawToBank();
        ConfirmTransactionPage confirm = withdrawFundPage.withdrawFundsToBank("1000.00");
        confirm.enterTransactionPin("123456");
        confirm.clickConfirmTransactionButton();
        confirm.processingWithdrawal();
        test.log(Status.PASS, "Withdrawal Testcase Passed");
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
        billsPaymentPage.purchaseElectricity("1000", "12001220",data.staging);
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
