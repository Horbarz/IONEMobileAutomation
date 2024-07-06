package pages;

public class TestData {

    //Device Setup
    public String actualDeviceUUID = "R9HR80HYTEJ";
    public String emulatorUUID = "emulator-5554";
    public String deviceName = "Ione Device";
    public String androidVersion = "13.0";
    public String deviceType = "emulator"; //physical

    //Mailosaur Credentials
    public String apiKey = "2y1mJCcAxIYraJ5ILGIkgmOnqXwbwAOZ";
    public String serverId = "zepiyj08";
    public String serverDomain = "@"+serverId+".mailosaur.net";


    //Production Login
    public String productionUserId = "12487";
    public String productionPassword = "P@ssword105";


    public boolean staging = true;
    public String firstName = "Isaac";
    public String middleName = "Benjamin";
    public String lastName = "Kantiyok";
    public String newEmail = "isaacbenjamin"+Utils.generateRandomNumber(50)+serverDomain;

    public String email = "isaacbenjamin0"+serverDomain; //isaacpaul15,isaacbenjamin0

    public String password = "P@ssword1";


    //KYC Fields
    public String bvn = "12019922010";

    public String nin = "21002910210";
    public String nameOfEmployer = "Dangote";
    public String addressEmployer = "21 Adewale Street";
    public String city = "Ikeja";
    public String zipCode = "12001";
    public String fullName = "Adeleke Seun";
    public String relationship = "Brother";
    public String nokAddress = "32 Herbert Macauly Street";
    public String nokCity = "Lagos";
    public String zip = "123191";
    public String meansOfIdType = "international_passport"; //international_passport,drivers_licence,nin,voterscard
    public String docId = "B012192889";
    public String newMiddleName = "George";

    //Address Info
    public String lga = "Mainland";
    public String homeAddress = "22 Adejola Street";
    public String stateOfResidence = "Lagos";
    public String cityofResidence = "Yaba";
    public String residentZipCode = "129100";

    //Personal Data
    public String gender = "Male"; //Female
    public String maritalStatus = "Single"; //Married, Separated, Divorced, Widowed
    public String motherMaiden = "Adekunle";

    //Contact Us
    public String contactUsMessage = "Hello we are grateful for this amazing app";


    //Savings
    public String amountToFund = "2000.00";

    //Stocks
    public String stockToBuy = "MBENEFIT"; //IMG,INFINITY,JAPAULGOLD,JULI,LIVESTOCK,MBENEFIT

    public String stockToSell = "GTCO";

    public String transactionPin = "123456";

    public String stocksModule = "stocks";

    public String withdrawalModule = "withdrawal";

    public String transferModule = "transfer";

    public String uatCSCSNumber = "0012345670";

    public String newStock = "JULI";//IMG,INFINITY,JAPAULGOLD,JULI,LIVESTOCK,MBENEFIT

    public String alertPrice = "5.0";

    public String stockToAdd = "conoil";

    //Fixed income investment
    public String plan = "Fixed Deposit Investment";
    public String fd_amount = "110,000.00";

    //Savings Plan
    public String planName = "Kilo Automated";
    public String planAmount = "100,000.00";
    public boolean lockPlan = false;

    public String topupAmount = "1,000.00";

    public String topUpFundingMethod = "card";

}
