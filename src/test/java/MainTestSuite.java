import com.aventstack.extentreports.Status;
import com.mailosaur.MailosaurException;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pages.BottomNav.InvestmentsPage;
import pages.BottomNav.Profile.ProfilePage;
import pages.CreateAccount.CreateAccountPage;
import pages.DashboardPage;
import pages.Home.*;
import pages.HomePage;
import pages.LoginPage;
import pages.Savings.FundZsaveAccountPage;
import pages.Savings.FundsTransferPage;
import pages.Savings.SavingsPlanPage;
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
                data.newEmail);
        var createPassword = verifyEmail.enterOTP(data.newEmail);
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
        helpcenterPage.viewFAQs();
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
        fundStocksWithWallet.displayNotificationMessage();

    }

    @Test
    public void fundStockAccountWithCard(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        stocks.toggleBalance();
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
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        stocks.toggleBalance();
        WithdrawFundPage withdrawFundPage = stocks.openWithdrawMoneyPage();
        ConfirmTransactionPage confirm = withdrawFundPage.withdrawFundsToWallet("1000.00");
        confirm.enterTransactionPin(data.transactionPin,data.withdrawalModule,data.deviceType);
        confirm.clickConfirmTransactionButton();
        confirm.waitForSuccessMessage(5);
        test.log(Status.PASS, "Withdrawal Testcase Passed");
    }


    @Test
    public void BuyStocks(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        TradeStocksPage tradeStocksPage = stocks.tradeStock();
        var stockResult = tradeStocksPage.searchStock(data.stockToBuy);
        var stockPurchase = stockResult.buyStock();
        //stockPurchase.SeeBids();
        var buyStock = stockPurchase.BuyStock("10",data.uatCSCSNumber);
        try {
            buyStock.enterTransactionPin(data.transactionPin, data.stocksModule,data.deviceType);
        }catch (Exception e){
            tradeStocksPage.goBack();
            tradeStocksPage.goBack();
            tradeStocksPage.scrollStockList();
            tradeStocksPage.searchStock(data.newStock);
            stockResult.buyStock();
            //stockPurchase.SeeBids();
            stockPurchase.BuyStock("10",data.uatCSCSNumber);
            buyStock.enterTransactionPin(data.transactionPin, data.stocksModule,data.deviceType);

        }
        test.log(Status.PASS, "See Bids Page Opened Successfully");
    }

    @Test
    public void SellStocks(){
        DashboardPage dashboardPage = LoginTest();
        InvestmentsPage investmentsPage = dashboardPage.openInvestments();
        StockTradingPage stocks = investmentsPage.openStockTradingPage();
        TradeStocksPage tradeStocksPage = stocks.tradeStock();
        var stockResult = tradeStocksPage.searchStock(data.stockToSell);
        var stockPurchase = stockResult.sellStock();
        //stockPurchase.SeeBids();
        var sellStock = stockPurchase.SellStock("10",data.uatCSCSNumber);
        sellStock.enterTransactionPin(data.transactionPin,data.stocksModule, data.deviceType);
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

        if(watchListPage.verifyStocksAddedToWatchList(data.stockToAdd.toLowerCase())){
            watchListPage.removeStockFromWatchList();
            test.log(Status.PASS, "Stocks found in watchlist");
        }else {
            AddToWatchListPage addToWatchListPage = watchListPage.openAddToWatchListPage();
            if(addToWatchListPage.addStockToWatchlist(data.stockToAdd.toLowerCase(), data.alertPrice)){
                test.log(Status.PASS, "Stocks successfully added");
            }
        }
    }


//**************************************FIXED DEPOSIT************************************

    @Test
    public void investFixedDepositWithCard() {
        DashboardPage dashboardPage = LoginTest();
        FixedIncomePage fixedIncomePage = dashboardPage.swipeToOpenFixedIncomePage();
        var fundingType = fixedIncomePage.selectInvestmentPlan(data.plan, data.fd_amount);
        var fixedIncomeViaCard = fundingType.CardFunding();
        fixedIncomeViaCard.verifyFixedIncomePage();
    }

    @Test
    public void investFixedDepositViaStockBroking() {
        DashboardPage dashboardPage = LoginTest();
        FixedIncomePage fixedIncomePage = dashboardPage.swipeToOpenFixedIncomePage();
        var fundingType = fixedIncomePage.selectInvestmentPlan(data.plan, data.fd_amount);
        var fixedIncomeViaCard = fundingType.StockBroking();
        fixedIncomeViaCard.verifyFixedIncomePage();
    }

    @Test
    public void investFixedDepositViaWallet() {
        DashboardPage dashboardPage = LoginTest();
        FixedIncomePage fixedIncomePage = dashboardPage.swipeToOpenFixedIncomePage();
        var fundingType = fixedIncomePage.selectInvestmentPlan(data.plan, data.fd_amount);
        var fixedIncomeViaCard = fundingType.WalletFunding();
        fixedIncomeViaCard.verifyFixedIncomePage();
    }


//    **************************************Savings************************************
    @Test
    public void fundSavingsAccountTest(){
        DashboardPage dashboardPage = LoginTest();
        SavingsPage savings = dashboardPage.swipeToOpenSavingsPage();
        savings.toggleBalance();
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
        confirm.enterTransactionPin(data.transactionPin, data.withdrawalModule,data.deviceType);
        confirm.clickConfirmTransactionButton();
        confirm.processingWithdrawal();
        test.log(Status.PASS, "Withdrawal Testcase Passed");
    }

    @Test
    public void CreatePlan(){
        DashboardPage dashboardPage = LoginTest();
        SavingsPage savings = dashboardPage.swipeToOpenSavingsPage();
        SavingsPlanPage savingsPlanPage = savings.savingsPlanPage();
        savingsPlanPage.createNewPlan(data.planName,data.planAmount,data.lockPlan);
        savingsPlanPage.viewPlanDetails(data.planName);
        savingsPlanPage.topupPlan(data.planName,data.topupAmount,data.topUpFundingMethod);
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
