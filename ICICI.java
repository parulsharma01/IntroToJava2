public class ICICI extends Bank{
    String bankName = "ICICI";
    double rateOfInterest = 8;
    String bankType; //savings or current

    public ICICI(type bankType){
        this.bankType = String.valueOf(bankType);
    }

    @Override
    public String getBankDetails() {
        String details = "";
        details += "Bank name : " +this.bankName +"\n";
        details += "Rate of Interest : " +this.rateOfInterest +"\n";
        details += "Bank type : " +this.bankType +"\n";
        return details;
    }
}
